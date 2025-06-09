package com.qryservice.query.service.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qryservice.query.service.dto.ClienteEvent;
import com.qryservice.query.service.entity.Cliente;
import com.qryservice.query.service.mapper.ClienteMapper;
import com.qryservice.query.service.repository.ClienteRepository;
import com.qryservice.query.service.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;

    @Override
    public Cliente findByidCliente(Long idCliente) {
        return clienteRepository.findByidCliente(idCliente);
    }
    @KafkaListener(topics = "client-event-topic", groupId = "client-event-group")
    public void processClienteEvent(@Payload String message) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ClienteEvent event = objectMapper.readValue(message, ClienteEvent.class);

            System.out.println("Evento recibido: " + event);
            System.out.println("!!!!!!!!cliente-event-topic: " + event.getCliente());

            if (event.getCliente() == null) {
                throw new IllegalArgumentException("Cliente no puede ser nulo");
            }

            Cliente cliente = clienteMapper.toClienteEntity( event.getCliente());

            switch (event.getEventType()) {
                case "CreateCliente" -> clienteRepository.save(cliente);

                case "UpdateCliente" -> {
                    Cliente clienteExistente = clienteRepository.findByidCliente(cliente.getIdCliente());
                    if (clienteExistente == null) {
                        throw new RuntimeException("No existe el cliente con el id " + cliente.getIdCliente());
                    }
                    Cliente actualizado = clienteMapper.updateCliente(clienteExistente, cliente);
                    clienteRepository.save(actualizado);
                }

                case "DeleteCliente" -> clienteRepository.deleteById(cliente.getIdCliente());
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

}
