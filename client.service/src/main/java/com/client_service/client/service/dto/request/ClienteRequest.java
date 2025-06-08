package com.client_service.client.service.dto.request;


import lombok.Data;

import java.util.Date;

@Data
public class ClienteRequest {
    private String nombre;
    private String apellido;
    private byte genero;
    private String direccion;
    private String telefono;
    private Date registro;
}
