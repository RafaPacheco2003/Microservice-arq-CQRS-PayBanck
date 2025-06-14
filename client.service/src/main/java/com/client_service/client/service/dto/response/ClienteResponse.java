package com.client_service.client.service.dto.response;

import com.client_service.client.service.entity.Cuenta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


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
