package com.transporte.transporte.Vehiculos.repositories;

import com.transporte.transporte.Vehiculos.models.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, UUID> {
}