package com.client_service.client.service.controller;


import com.client_service.client.service.dto.request.CuentaRequest;
import com.client_service.client.service.dto.response.CuentaResponse;
import com.client_service.client.service.service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {


    @Autowired
    private CuentaService cuentaService;

    @PutMapping("actualizarCuenta/{idCuenta}")
    public CuentaResponse  actualizarCuenta(@PathVariable("idCuenta")Long idCuenta,
                                            @RequestBody CuentaRequest cuentaRequest){
        return cuentaService.actualizarCuenta(idCuenta, cuentaRequest);


    }

    @PutMapping("/bajaCuenta/{idCuenta}")
    public Boolean bajaCuenta(@PathVariable("idCuenta")Long idCuenta){


        return cuentaService.bajaCuenta(idCuenta);
    }




}
