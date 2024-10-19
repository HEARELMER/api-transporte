package com.transporte.transporte.ventas.repositories;

import com.transporte.transporte.ventas.models.Salida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SalidaRepository extends JpaRepository<Salida, UUID> {
}