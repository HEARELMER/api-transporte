package com.transporte.transporte.ventas.services;

import com.transporte.transporte.ventas.models.Ruta;
import com.transporte.transporte.ventas.models.Servicio;
import com.transporte.transporte.ventas.repositories.RutaRepository;
import com.transporte.transporte.ventas.repositories.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ServicioService {

    @Autowired
    private ServicioRepository servicioRepository;
    @Autowired
    private RutaRepository rutaRepository;
    public Servicio createServicio(Servicio servicio) {
        return servicioRepository.save(servicio);
    }

    public List<Servicio> getAllServicios() {
        return servicioRepository.findAll();
    }
    public Ruta createRuta(Ruta ruta) {
        return rutaRepository.save(ruta);
    }

    public List<Ruta> getAllRutas() {
        return rutaRepository.findAll();
    }

}