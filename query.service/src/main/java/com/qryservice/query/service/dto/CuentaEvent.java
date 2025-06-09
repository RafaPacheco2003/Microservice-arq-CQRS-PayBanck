package com.qryservice.query.service.dto;

import com.qryservice.query.service.entity.Cliente;
import com.qryservice.query.service.entity.Cuenta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CuentaEvent {

    private String eventType;
    private Cuenta cuenta;
}
