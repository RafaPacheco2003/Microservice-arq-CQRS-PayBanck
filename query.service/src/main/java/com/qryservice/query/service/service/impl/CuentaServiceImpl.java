package com.qryservice.query.service.service.impl;

import com.qryservice.query.service.dto.CuentaEvent;
import com.qryservice.query.service.entity.Cuenta;
import com.qryservice.query.service.mapper.CuentaMapper;
import com.qryservice.query.service.repository.CuentaRepository;
import com.qryservice.query.service.service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class CuentaServiceImpl implements CuentaService {

    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private CuentaMapper cuentaMapper;

    @Override
    public Cuenta findByidCliente(Long idCuenta) {
        return cuentaRepository.findByidCuenta(idCuenta);
    }

    @Override
    @KafkaListener(topics = "cuenta-event-topic", groupId = "cuenta-event-group")
    public void processClienteEvent(CuentaEvent event) {
        Cuenta cuenta = event.getCuenta();

        if (event.getEventType().equals("CreateCuenta")) {
            cuentaRepository.save(cuenta);
        }

        if (event.getEventType().equals("UpdateCuenta")) {
            Cuenta cuentaExistente = cuentaRepository.findByidCuenta(cuenta.getIdCuenta());
            if (cuentaExistente == null) {
                throw new RuntimeException("No existe la cuenta con el id " + cuenta.getIdCuenta());
            }
            Cuenta actualizada = CuentaMapper.updateCuenta(cuentaExistente, cuenta);
            cuentaRepository.save(actualizada);
        }

        if (event.getEventType().equals("DeleteCuenta")) {
            cuentaRepository.delete(cuenta);
        }
    }
}
