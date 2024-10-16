package com.transporte.transporte.users.repositories;

import com.transporte.transporte.users.models.Conductor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ConductorRepository extends JpaRepository<Conductor, UUID> {
    Optional<Conductor> findByDni(String dni);
}