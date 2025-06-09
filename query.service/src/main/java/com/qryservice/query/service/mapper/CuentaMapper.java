package com.qryservice.query.service.mapper;

import com.qryservice.query.service.entity.Cuenta;
import org.springframework.stereotype.Service;

@Service
public class CuentaMapper {

    public static Cuenta updateCuenta(Cuenta cuentaExistente, Cuenta nuevaCuenta) {
        cuentaExistente.setCliente(nuevaCuenta.getCliente());
        cuentaExistente.setSaldo(nuevaCuenta.getSaldo());
        cuentaExistente.setDeuda(nuevaCuenta.getDeuda());
        cuentaExistente.setLimiteCredito(nuevaCuenta.getLimiteCredito());
        cuentaExistente.setActivo(nuevaCuenta.getActivo());
        return cuentaExistente;
    }
}
