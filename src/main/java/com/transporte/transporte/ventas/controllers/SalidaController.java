package com.transporte.transporte.ventas.controllers;

import com.transporte.transporte.ventas.models.Salida;
import com.transporte.transporte.ventas.services.SalidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/salidas")
public class SalidaController {

    @Autowired
    private SalidaService salidaService;

    @GetMapping
    public List<Salida> getAllSalidas() {
        return salidaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Salida> getSalidaById(@PathVariable UUID id) {
        Optional<Salida> salida = salidaService.findById(id);
        return salida.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Salida createSalida(@RequestBody Salida salida) {
        return salidaService.save(salida);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSalida(@PathVariable UUID id) {
        Optional<Salida> salida = salidaService.findById(id);
        if (salida.isPresent()) {
            salidaService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}