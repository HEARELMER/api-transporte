package com.transporte.transporte.ventas.controllers;

import com.transporte.transporte.ventas.models.Ruta;
import com.transporte.transporte.ventas.models.Servicio;

import com.transporte.transporte.ventas.services.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicios")
public class ServicioController {

    @Autowired
    private ServicioService servicioService;

    @PostMapping
    public Servicio createServicio(@RequestBody Servicio servicio) {
        return servicioService.createServicio(servicio);
    }

    @GetMapping
    public List<Servicio> getAllServicios() {
        return servicioService.getAllServicios();
    }

    @PostMapping("/rutas")
    public Ruta createRuta(@RequestBody Ruta ruta) {
        return servicioService.createRuta(ruta);
    }

    @GetMapping("/rutas")
    public List<Ruta> getAllRutas() {
        return servicioService.getAllRutas();
    }
}