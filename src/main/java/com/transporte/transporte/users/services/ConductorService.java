package com.transporte.transporte.users.services;

import com.transporte.transporte.users.models.Conductor;
import com.transporte.transporte.users.repositories.ConductorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ConductorService {

    @Autowired
    private ConductorRepository conductorRepository;

    public List<Conductor> findAll() {
        return conductorRepository.findAll();
    }

    public Optional<Conductor> findById(UUID id) {
        return conductorRepository.findById(id);
    }

    public Optional<Conductor> findByDni(String dni) {
        return conductorRepository.findByDni(dni);
    }

    public Conductor save(Conductor conductor) {
        if (conductor.getIdUsuario() == null) {
            conductor.setIdUsuario(UUID.randomUUID());
        }
        return conductorRepository.save(conductor);
    }

    public void deleteById(UUID id) {
        conductorRepository.deleteById(id);
    }
}