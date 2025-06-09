package com.qryservice.query.service.dto;

import com.qryservice.query.service.entity.Cliente;
import com.qryservice.query.service.entity.Cuenta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteEvent {

    private String eventType;
    private Cliente cliente;
}
