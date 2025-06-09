package com.client_service.client.service.controller;

import com.client_service.client.service.dto.request.ClienteRequest;
import com.client_service.client.service.dto.response.ClienteResponse;
import com.client_service.client.service.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // GET: Obtener un cliente por ID
    @GetMapping("/{idCliente}")
    public ResponseEntity<ClienteResponse> getCliente(@PathVariable Long idCliente) {
        ClienteResponse cliente = clienteService.getCliente(idCliente);
        return ResponseEntity.ok(cliente);
    }

    // POST: Crear un nuevo cliente
    @PostMapping("/agregarCliente")
    public ResponseEntity<ClienteResponse> agregarCliente(@RequestBody ClienteRequest clienteRequest) {
        ClienteResponse nuevoCliente = clienteService.agregarCliente(clienteRequest);
        return ResponseEntity.ok(nuevoCliente);
    }

    // PUT: Actualizar cliente existente
    @PutMapping("/actualizarCliente/{idCliente}")
    public ResponseEntity<ClienteResponse> actualizarCliente(
            @PathVariable Long idCliente,
            @RequestBody ClienteRequest clienteRequest) {
        ClienteResponse clienteActualizado = clienteService.actualizarCliente(idCliente, clienteRequest);
        return ResponseEntity.ok(clienteActualizado);
    }

    // DELETE: Dar de baja (eliminar) cliente
    @DeleteMapping("/bajaCliente/{idCliente}")
    public ResponseEntity<Boolean> bajaCliente(@PathVariable Long idCliente) {
        Boolean eliminado = clienteService.eliminarCliente(idCliente);
        return ResponseEntity.ok(eliminado);
    }
}
