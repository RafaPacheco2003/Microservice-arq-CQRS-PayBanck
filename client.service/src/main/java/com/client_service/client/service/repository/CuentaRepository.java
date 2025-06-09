package com.client_service.client.service.repository;

import com.client_service.client.service.entity.Cuenta;
import org.springframework.data.repository.CrudRepository;

public interface CuentaRepository extends CrudRepository<Cuenta,Long> {
}
