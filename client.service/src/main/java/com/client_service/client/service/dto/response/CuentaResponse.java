package com.client_service.client.service.dto.response;

import com.client_service.client.service.entity.Cliente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CuentaResponse {

    private Long idCuenta;
    private Cliente cliente;
    private BigDecimal saldo;
    private BigDecimal  deuda;
    private BigDecimal limiteCredito;
    private Boolean activo;

    public CuentaResponse(Long idCuenta){
        this.idCuenta = idCuenta;
    }
}
