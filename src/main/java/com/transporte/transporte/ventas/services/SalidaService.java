package com.transporte.transporte.ventas.services;

import com.transporte.transporte.ventas.models.Salida;
import com.transporte.transporte.ventas.repositories.SalidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SalidaService {

    @Autowired
    private SalidaRepository salidaRepository;

    public List<Salida> findAll() {
        return salidaRepository.findAll();
    }

    public Optional<Salida> findById(UUID id) {
        return salidaRepository.findById(id);
    }

    public Salida save(Salida salida) {
        return salidaRepository.save(salida);
    }

    public void deleteById(UUID id) {
        salidaRepository.deleteById(id);
    }
}