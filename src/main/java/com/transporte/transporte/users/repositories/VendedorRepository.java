package com.transporte.transporte.users.repositories;

import com.transporte.transporte.users.models.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface VendedorRepository extends JpaRepository<Vendedor, UUID> {
    Optional<Vendedor> findByDni(String dni);
}