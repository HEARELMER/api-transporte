package com.transporte.transporte.users.controllers;

import com.transporte.transporte.users.models.Conductor;
import com.transporte.transporte.users.services.ConductorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("conductores")
public class ConductorController {

    @Autowired
    private ConductorService conductorService;

    @GetMapping
    public List<Conductor> getAllConductores() {
        return conductorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conductor> getConductorById(@PathVariable UUID id) {
        Optional<Conductor> conductor = conductorService.findById(id);
        return conductor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/dni/{dni}")
    public ResponseEntity<Conductor> getConductorByDni(@PathVariable String dni) {
        Optional<Conductor> conductor = conductorService.findByDni(dni);
        return conductor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Conductor createConductor(@RequestBody Conductor conductor) {
        return conductorService.save(conductor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConductor(@PathVariable UUID id) {
        Optional<Conductor> conductor = conductorService.findById(id);
        if (conductor.isPresent()) {
            conductorService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}