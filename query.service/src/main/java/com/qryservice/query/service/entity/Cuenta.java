package com.qryservice.query.service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.math.BigDecimal;

@RedisHash
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cuenta {

    @Id
    private Long idCuenta;
    private Cliente cliente;

    private BigDecimal saldo;
    private BigDecimal deuda;
    private BigDecimal limiteCredito;

    private Boolean activo;
}
