package com.client_service.client.service.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCuenta;

    @ManyToOne
    @JoinColumn(name = "idCuenta", insertable = false, updatable = false)
    private Cliente cliente;

    private BigDecimal saldo;
    private BigDecimal  deuda;
    private BigDecimal limiteCredito;
    

}
