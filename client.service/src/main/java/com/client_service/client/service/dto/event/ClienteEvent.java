package com.client_service.client.service.dto.event;

import com.client_service.client.service.dto.request.ClienteRequest;
import com.client_service.client.service.dto.response.ClienteResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteEvent {

    private String eventType;
    private ClienteResponse clienteResponse;
}
