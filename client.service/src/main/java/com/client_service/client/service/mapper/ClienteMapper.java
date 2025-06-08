package com.client_service.client.service.mapper;

import com.client_service.client.service.dto.request.ClienteRequest;
import com.client_service.client.service.dto.response.ClienteResponse;
import com.client_service.client.service.entity.Cliente;
import org.modelmapper.ModelMapper;

public class ClienteMapper {

    private final ModelMapper modelMapper = new ModelMapper(); // Instancia local

    public Cliente toCliente(ClienteRequest clienteRequest) {

        return modelMapper.map(clienteRequest, Cliente.class);
    }



    public ClienteResponse toClienteResponse(Cliente cliente) {
        return modelMapper.map(cliente, ClienteResponse.class);
    }

    public ClienteResponse updateCliente(ClienteRequest clienteRequest, Cliente cliente) {
        modelMapper.map(clienteRequest, cliente);
        return toClienteResponse(cliente); // Convertir el cliente actualizado a ClienteResponse
    }
}
