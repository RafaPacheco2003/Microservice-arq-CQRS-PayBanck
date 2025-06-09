package com.qryservice.query.service.repository;

import com.qryservice.query.service.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

    Cliente findByidCliente(Long idCliente);
}
