package com.qryservice.query.service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.Date;
import java.util.List;

@RedisHash
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @Id
    private Long idCliente;

    private String nombre;
    private String apellido;
    private byte genero;
    private String direccion;
    private String telefono;
    private Date registro;
    //@OneToMany(mappedBy = "cliente")
    // private List<Cuenta> cuentas;
}
