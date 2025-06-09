package com.client_service.client.service.dto.request;

import com.client_service.client.service.entity.Cliente;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CuentaRequest {

    private Cliente cliente;
    private BigDecimal saldo;
    private BigDecimal  deuda;
    private BigDecimal limiteCredito;

}
