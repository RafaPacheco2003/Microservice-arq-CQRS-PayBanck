package com.qryservice.query.service.service;

import com.qryservice.query.service.dto.ClienteEvent;
import com.qryservice.query.service.dto.CuentaEvent;
import com.qryservice.query.service.entity.Cliente;
import com.qryservice.query.service.entity.Cuenta;

public interface CuentaService {

    Cuenta findByidCliente(Long idCuenta);
    void processClienteEvent(CuentaEvent event);
}
