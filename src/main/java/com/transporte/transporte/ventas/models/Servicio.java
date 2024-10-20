package com.transporte.transporte.ventas.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "servicios")
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "ruta_id", nullable = false)
    private UUID rutaId;
    private double tarifa;

    public Servicio() {}

    public Servicio(UUID rutaId, double tarifa) {
        this.rutaId = rutaId;
        this.tarifa = tarifa;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getRutaId() {
        return rutaId;
    }

    public void setRutaId(UUID rutaId) {
        this.rutaId = rutaId;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

}