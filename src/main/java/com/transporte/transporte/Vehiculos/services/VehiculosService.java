package com.transporte.transporte.Vehiculos.services;

import com.transporte.transporte.Vehiculos.models.Vehiculo;
import com.transporte.transporte.Vehiculos.repositories.VehiculoRepository;
import com.transporte.transporte.users.models.Conductor;
import com.transporte.transporte.users.repositories.ConductorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class VehiculosService {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Autowired
    private ConductorRepository conductorRepository;

    public List<Vehiculo> findAll() {
        List<Vehiculo> vehiculos = vehiculoRepository.findAll();
        for (Vehiculo vehiculo : vehiculos) {
            Optional<Conductor> conductor = conductorRepository.findById(vehiculo.getConductorId());
            conductor.ifPresent(vehiculo::setConductor);
        }
        return vehiculos;
    }

    public Optional<Vehiculo> findById(UUID id) {
        Optional<Vehiculo> vehiculo = vehiculoRepository.findById(id);
        vehiculo.ifPresent(v -> {
            Optional<Conductor> conductor = conductorRepository.findById(v.getConductorId());
            conductor.ifPresent(v::setConductor);
        });
        return vehiculo;
    }

    public void deleteById(UUID id) {
        vehiculoRepository.deleteById(id);
    }

    public Vehiculo save(Vehiculo vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }
}