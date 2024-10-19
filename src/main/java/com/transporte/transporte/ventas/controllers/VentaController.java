package com.transporte.transporte.ventas.controllers;
import com.transporte.transporte.ventas.dtos.VentaDetailsDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.transporte.transporte.ventas.models.Venta;
import com.transporte.transporte.ventas.services.VentaService;
import com.transporte.transporte.users.models.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.List;

@RestController
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping
    public ResponseEntity<Venta> createVenta(@RequestBody Map<String, Object> payload) {
        Venta venta = objectMapper.convertValue(payload.get("venta"), Venta.class);
        Cliente cliente = objectMapper.convertValue(payload.get("cliente"), Cliente.class);
        Venta nuevaVenta = ventaService.createVenta(venta, cliente);
        return ResponseEntity.ok(nuevaVenta);
    }

    @GetMapping
    public ResponseEntity<List<Venta>> getAllVentas() {
        List<Venta> ventas = ventaService.getAllVentas();
        return ResponseEntity.ok(ventas);
    }


    @GetMapping("/details")
    public ResponseEntity<List<VentaDetailsDto>> getAllVentaDetails() {
        List<VentaDetailsDto> ventas = ventaService.getAllVentaDetails();
        return ResponseEntity.ok(ventas);
    }
}