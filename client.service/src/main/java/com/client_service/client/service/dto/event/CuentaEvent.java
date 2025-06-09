package com.client_service.client.service.dto.event;

import com.client_service.client.service.dto.response.ClienteResponse;
import com.client_service.client.service.dto.response.CuentaResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CuentaEvent {

    private String eventType;
    private CuentaResponse cuentaResponse;
}
