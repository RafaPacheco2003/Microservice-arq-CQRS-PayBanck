package com.qryservice.query.service.service;

import ch.qos.logback.core.net.server.Client;
import com.qryservice.query.service.dto.ClienteEvent;
import com.qryservice.query.service.entity.Cliente;

public interface ClienteService {

    Cliente findByidCliente(Long idCliente);
    void processClienteEvent(ClienteEvent event);

}
