package com.transporte.transporte.users.controllers;

import com.transporte.transporte.users.models.Conductor;
import com.transporte.transporte.users.models.Usuario;
import com.transporte.transporte.users.models.Vendedor;
import com.transporte.transporte.users.services.ConductorService;
import com.transporte.transporte.users.services.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    private ConductorService conductorService;

    @Autowired
    private VendedorService vendedorService;

    @GetMapping
    public Map<String, List<?>> mostrarUsuarios() {
        Map<String, List<?>> response = new HashMap<>();
        response.put("conductores", conductorService.findAll());
        response.put("vendedores", vendedorService.findAll());
        return response;
    }
}