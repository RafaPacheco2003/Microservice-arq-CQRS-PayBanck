package com.client_service.client.service.service;

import com.client_service.client.service.dto.request.ClienteRequest;
import com.client_service.client.service.dto.response.ClienteResponse;

public interface ClienteService {

    ClienteResponse getCliente(Long idCliente);

    ClienteResponse agregarCliente(ClienteRequest clienteRequest);
    ClienteResponse actualizarCliente(Long idCliente, ClienteRequest clienteRequest);

    Boolean eliminarCliente(Long idCliente);



}
