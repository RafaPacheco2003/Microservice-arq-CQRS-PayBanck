package com.client_service.client.service.service.impl;

import com.client_service.client.service.dto.event.ClienteEvent;
import com.client_service.client.service.dto.request.ClienteRequest;
import com.client_service.client.service.dto.response.ClienteResponse;
import com.client_service.client.service.entity.Cliente;
import com.client_service.client.service.mapper.ClienteMapper;
import com.client_service.client.service.repository.ClienteRepository;
import com.client_service.client.service.service.ClienteService;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class ClienteServiceImpl implements ClienteService {

    private ClienteRepository clienteRepository;
    private ClienteMapper clienteMapper;
    private KafkaTemplate<String, Object> kafkaTemplate;


    @Override
    public ClienteResponse agregarCliente(ClienteRequest clienteRequest) {
        Cliente cliente = clienteMapper.toCliente(clienteRequest);
        cliente.setRegistro(new Date());
        clienteRepository.save(cliente);

        ClienteResponse clienteResponse = clienteMapper.toClienteResponse(cliente);
        kafkaTemplate.send("client-event-topic", new ClienteEvent("CreateCliente",clienteResponse));

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
