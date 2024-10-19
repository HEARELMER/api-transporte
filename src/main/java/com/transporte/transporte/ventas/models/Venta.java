package com.transporte.transporte.ventas.models;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "ventas")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID codigoVenta;

    @Column(name = "salida_id", nullable = false)
    private UUID salidaId;

    @Column(name = "cliente_id", nullable = false)
    private UUID clienteId;

    @Column(name = "servicio_id", nullable = false)
    private UUID servicioId;

    @Column(nullable = false)
    private int asiento;

    public Venta() {}

    public Venta(UUID salidaId, UUID clienteId, UUID servicioId, int asiento) {
        this.salidaId = salidaId;
        this.clienteId = clienteId;
        this.servicioId = servicioId;
        this.asiento = asiento;
    }

    public UUID getSalidaId() {
        return salidaId;
    }

    public UUID getServicioId() {
        return servicioId;
    }

    public void setClienteId(UUID clienteId) {
        this.clienteId = clienteId;
    }

    public UUID getClienteId() {
        return clienteId;
    }

    public void setCodigoVenta(UUID codigoVenta) {
        this.codigoVenta = codigoVenta;
    }

    public UUID getCodigoVenta() {
        return codigoVenta;
    }

    public int getAsiento() {
        return asiento;
    }
}