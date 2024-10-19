package com.transporte.transporte.Vehiculos.controllers;

import com.transporte.transporte.Vehiculos.models.Vehiculo;
import com.transporte.transporte.Vehiculos.services.VehiculosService;
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
    private VehiculosService vehiculoService;

    public VehiculoController(VehiculosService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    @GetMapping
    public List<Vehiculo> getAllVehiculos() {
        return vehiculoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehiculo> getVehiculoById(@PathVariable UUID id) {
        Optional<Vehiculo> vehiculo = vehiculoService.findById(id);
        return vehiculo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new Vehiculo
    @PostMapping
    public ResponseEntity<Vehiculo> createVehiculo(@RequestBody Vehiculo vehiculo) {
        Vehiculo savedVehiculo = vehiculoService.save(vehiculo);
        return ResponseEntity.ok(savedVehiculo);
    }
}