package com.transporte.transporte.ventas.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "servicios")
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    public enum TipoServicio { VIP, EJECUTIVO, REAL, NORMAL }

    private TipoServicio tipo;
    private double tarifa;

    public Servicio() {}

    public Servicio(TipoServicio tipo, double tarifa) {
        this.tipo = tipo;
        this.tarifa = tarifa;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public TipoServicio getTipo() {
        return tipo;
    }

    public void setTipo(TipoServicio tipo) {
        this.tipo = tipo;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }
}