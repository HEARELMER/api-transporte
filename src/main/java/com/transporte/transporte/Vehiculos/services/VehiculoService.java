package com.transporte.transporte.Vehiculos.services;
import com.transporte.transporte.Vehiculos.models.Vehiculo;
import com.transporte.transporte.Vehiculos.repositories.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class VehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;
    public List<Vehiculo> findAll() {
        return vehiculoRepository.findAll();
    }

    // Buscar un vehículo por su ID
    public Optional<Vehiculo> findById(UUID id) {
        return vehiculoRepository.findById(id);
    }

    // Eliminar un vehículo por su ID
    public void deleteById(UUID id) {
        vehiculoRepository.deleteById(id);
    }
}
