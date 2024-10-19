package com.transporte.transporte.Vehiculos.controllers;

import com.transporte.transporte.Vehiculos.models.Vehiculo;
import com.transporte.transporte.Vehiculos.services.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;

    @GetMapping
    public List<Vehiculo> getAllVehiculos() {
        return vehiculoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehiculo> getVehiculoById(@PathVariable UUID id) {
        Optional<Vehiculo> vehiculo = vehiculoService.findById(id);
        return vehiculo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }




}