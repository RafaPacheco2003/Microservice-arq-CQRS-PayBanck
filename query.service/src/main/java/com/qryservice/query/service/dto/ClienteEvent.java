package com.qryservice.query.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.qryservice.query.service.entity.Cliente;
import com.qryservice.query.service.entity.Cuenta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClienteEvent {

    private String eventType;

    @JsonProperty("clienteResponse")
    private ClienteResponse cliente;

    public ClienteEvent() {
    }

    public ClienteEvent(String eventType, ClienteResponse cliente) {
        this.eventType = eventType;
        this.cliente = cliente;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public ClienteResponse getCliente() {
        return cliente;
    }

    public void setCliente(ClienteResponse cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "ClienteEvent{" +
                "eventType='" + eventType + '\'' +
                ", cliente=" + cliente +
                '}';
    }
}
