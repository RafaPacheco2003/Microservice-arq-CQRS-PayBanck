package com.client_service.client.service.service.impl;

import com.client_service.client.service.dto.event.ClienteEvent;
import com.client_service.client.service.dto.event.CuentaEvent;
import com.client_service.client.service.dto.request.CuentaRequest;
import com.client_service.client.service.dto.response.ClienteResponse;
import com.client_service.client.service.dto.response.CuentaResponse;
import com.client_service.client.service.entity.Cuenta;
import com.client_service.client.service.mapper.CuentaMapper;
import com.client_service.client.service.repository.ClienteRepository;
import com.client_service.client.service.repository.CuentaRepository;
import com.client_service.client.service.service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CuentaServiceImpl implements CuentaService {


    @Autowired
    private CuentaRepository cuentaRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private CuentaMapper  cuentaMapper;
    @Autowired
    private KafkaTemplate <String, Object> kafkaTemplate;



    @Override
    public CuentaResponse actualizarCuenta(Long idCuenta, CuentaRequest cuentaRequest) {

        Cuenta cuenta = cuentaRepository.findById(idCuenta).orElseThrow(()-> new RuntimeException("Cuenta no encontrada"));
        cuentaMapper.updateCuenta(cuentaRequest, cuenta);
        cuentaRepository.save(cuenta);
        CuentaResponse cuentaResponse = cuentaMapper.toCuentaResponse(cuenta);
        kafkaTemplate.send("account-event-topic", new CuentaEvent("UpdateCuenta",cuentaResponse ));

        return cuentaResponse;
    }

    @Override
    public Boolean bajaCuenta(Long idCuenta) {

        Cuenta cuenta = cuentaRepository.findById(idCuenta).orElseThrow(()-> new RuntimeException("Cuenta no encontrada"));
        cuentaRepository.delete(cuenta);

        clienteRepository.delete(cuenta.getCliente());
        kafkaTemplate.send("client-event-topic", new ClienteEvent("DeleteCliente",new ClienteResponse(idCuenta)));
        kafkaTemplate.send("account-event-topic", new CuentaEvent("DeleteCuenta",new CuentaResponse(idCuenta)));



        return true;
    }
}
