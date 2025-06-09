package com.qryservice.query.service.controller;


import com.qryservice.query.service.entity.Cliente;
import com.qryservice.query.service.entity.Cuenta;
import com.qryservice.query.service.service.ClienteService;
import com.qryservice.query.service.service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private CuentaService cuentaService;

    @GetMapping("/clientes/{id}")
    public Cliente obtenerClientePorId(@PathVariable Long id) {
        return clienteService.findByidCliente(id);
    }

    @GetMapping("/cuentas/{id}")
    public Cuenta obtenerCuentaPorId(@PathVariable Long id) {
        return cuentaService.findByidCliente(id);
    }
}
