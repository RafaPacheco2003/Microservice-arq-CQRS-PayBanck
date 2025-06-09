package com.client_service.client.service.service;

import com.client_service.client.service.dto.request.CuentaRequest;
import com.client_service.client.service.dto.response.CuentaResponse;

public interface CuentaService {


    CuentaResponse actualizarCuenta(Long idCuenta, CuentaRequest cuentaRequest);
    Boolean bajaCuenta(Long idCuenta);
}
