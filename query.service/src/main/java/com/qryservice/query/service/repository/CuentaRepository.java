package com.qryservice.query.service.repository;

import com.qryservice.query.service.entity.Cuenta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaRepository extends CrudRepository<Cuenta,Long> {

    Cuenta findByidCuenta(Long idCuenta);
}
