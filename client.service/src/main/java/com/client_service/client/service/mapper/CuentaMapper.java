package com.client_service.client.service.mapper;

import com.client_service.client.service.dto.request.CuentaRequest;
import com.client_service.client.service.dto.response.CuentaResponse;
import com.client_service.client.service.entity.Cuenta;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CuentaMapper {

    private final ModelMapper modelMapper = new ModelMapper(); // Instancia local


    public Cuenta toCuenta(CuentaRequest cuentaRequest) {
    return   modelMapper.map(cuentaRequest, Cuenta.class);
    }

    public CuentaResponse toCuentaResponse(Cuenta cuenta) {
        return   modelMapper.map(cuenta, CuentaResponse.class);
    }

    public void updateCuenta(CuentaRequest cuentaRequest, Cuenta cuenta) {
        modelMapper.map(cuentaRequest, cuenta);

    }
}
