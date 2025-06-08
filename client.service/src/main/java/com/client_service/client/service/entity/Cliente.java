package com.client_service.client.service.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCliente;

    private String nombre;
    private String apellido;
    private byte genero;
    private String direccion;
    private String telefono;
    private Date registro;
}
