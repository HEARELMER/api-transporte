package com.transporte.transporte.ventas.repositories;

import com.transporte.transporte.ventas.models.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface VentaRepository extends JpaRepository<Venta, UUID> {
}