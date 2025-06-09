package com.qryservice.query.service.mapper;

import com.qryservice.query.service.dto.ClienteEvent;
import com.qryservice.query.service.dto.ClienteResponse;
import com.qryservice.query.service.entity.Cliente;
import org.springframework.stereotype.Service;

@Service
public class ClienteMapper {

    public static Cliente updateCliente(Cliente clienteExistente, Cliente nuevoCliente) {
        clienteExistente.setNombre(nuevoCliente.getNombre());
        clienteExistente.setApellido(nuevoCliente.getApellido());
        clienteExistente.setGenero(nuevoCliente.getGenero());
        clienteExistente.setDireccion(nuevoCliente.getDireccion());
        clienteExistente.setTelefono(nuevoCliente.getTelefono());
        clienteExistente.setRegistro(nuevoCliente.getRegistro());
        return clienteExistente;
    }
    public Cliente toClienteEntity(ClienteResponse clienteResponse) {
        Cliente cliente = new Cliente();
        cliente.setIdCliente(clienteResponse.getIdCliente());
        cliente.setNombre(clienteResponse.getNombre());
        cliente.setApellido(clienteResponse.getApellido());
        cliente.setGenero(clienteResponse.getGenero());
        cliente.setDireccion(clienteResponse.getDireccion());
        cliente.setTelefono(clienteResponse.getTelefono());
        cliente.setRegistro(clienteResponse.getRegistro());
        return cliente;
    }
}
