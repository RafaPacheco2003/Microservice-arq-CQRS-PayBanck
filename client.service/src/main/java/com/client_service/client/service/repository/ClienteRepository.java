package com.client_service.client.service.repository;

import com.client_service.client.service.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository  extends JpaRepository<Cliente,Long> {
}
