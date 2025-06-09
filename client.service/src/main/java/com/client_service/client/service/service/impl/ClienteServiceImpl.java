package com.client_service.client.service.service.impl;

import com.client_service.client.service.dto.event.ClienteEvent;
import com.client_service.client.service.dto.event.CuentaEvent;
import com.client_service.client.service.dto.request.ClienteRequest;
import com.client_service.client.service.dto.response.ClienteResponse;
import com.client_service.client.service.dto.response.CuentaResponse;
import com.client_service.client.service.entity.Cliente;
import com.client_service.client.service.entity.Cuenta;
import com.client_service.client.service.mapper.ClienteMapper;
import com.client_service.client.service.mapper.CuentaMapper;
import com.client_service.client.service.repository.ClienteRepository;
import com.client_service.client.service.repository.CuentaRepository;
import com.client_service.client.service.service.ClienteService;
import com.client_service.client.service.util.GenerarLimiteCreditoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;


@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private GenerarLimiteCreditoService generarLimiteCreditoService;;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ClienteMapper clienteMapper;
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    private CuentaRepository cuentaRepository;
    @Autowired
    private CuentaMapper cuentaMapper;

    @Override
    public ClienteResponse getCliente(Long idCliente) {
        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + idCliente));
        return clienteMapper.toClienteResponse(cliente);
    }

    @Override
    public ClienteResponse agregarCliente(ClienteRequest clienteRequest) {
        Cliente cliente = clienteMapper.toCliente(clienteRequest);
        cliente.setRegistro(new Date());
        cliente = clienteRepository.save(cliente);

        ClienteResponse clienteResponse = clienteMapper.toClienteResponse(cliente);

        Cuenta cuenta = new Cuenta();
        cuenta.setLimiteCredito(generarLimiteCreditoService.generarLimite());
        cuenta.setCliente(cliente);
        cuenta.setDeuda(BigDecimal.ZERO);
        cuenta.setSaldo(new BigDecimal(0));
        cuenta.setActivo(true);
        Cuenta cuentaSaved = cuentaRepository.save(cuenta);
        CuentaResponse cuentaResponse = cuentaMapper.toCuentaResponse(cuentaSaved);


        System.out.println("!!SE le manada:" +clienteResponse);
        kafkaTemplate.send("client-event-topic", new ClienteEvent("CreateCliente",clienteResponse));
        kafkaTemplate.send("account-event-topic", new CuentaEvent("CreateCuenta",cuentaResponse));
        return clienteResponse;
    }

    @Override
    public ClienteResponse actualizarCliente(Long idCliente, ClienteRequest clienteRequest) {

        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + idCliente));

        clienteMapper.updateCliente(clienteRequest, cliente);

        clienteRepository.save(cliente);

        ClienteResponse clienteResponse = clienteMapper.toClienteResponse(cliente);
        kafkaTemplate.send("client-event-topic", new ClienteEvent("UpdateCliente",clienteResponse));

        return clienteResponse;
    }

    @Override
    public Boolean eliminarCliente(Long idCliente) {

        Cliente cliente = clienteRepository.findById(idCliente).orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + idCliente));

       clienteRepository.delete(cliente);
       kafkaTemplate.send("client-event-topic", new ClienteEvent("DeleteCliente",new ClienteResponse(idCliente)));
        return null;
    }
}
