package com.qryservice.query.service.service;

import ch.qos.logback.core.net.server.Client;
import com.qryservice.query.service.dto.ClienteEvent;
import com.qryservice.query.service.entity.Cliente;
import org.springframework.messaging.handler.annotation.Payload;

public interface ClienteService {

    Cliente findByidCliente(Long idCliente);
    public void processClienteEvent(@Payload String message);

}
