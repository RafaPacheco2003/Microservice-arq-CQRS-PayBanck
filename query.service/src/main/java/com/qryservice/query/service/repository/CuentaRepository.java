package com.qryservice.query.service.repository;

import com.qryservice.query.service.entity.Cuenta;
import org.springframework.data.repository.CrudRepository;

public interface CuentaRepository extends CrudRepository<Cuenta,Long> {

    Cuenta findByidCuenta(Long idCuenta);
}
