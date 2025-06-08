package com.client_service.client.service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteResponse {
    private Long idCliente;

    private String nombre;
    private String apellido;
    private byte genero;
    private String direccion;
    private String telefono;
    private Date registro;


    public ClienteResponse(Long idCliente) {
        this.idCliente = idCliente;
    }

}
