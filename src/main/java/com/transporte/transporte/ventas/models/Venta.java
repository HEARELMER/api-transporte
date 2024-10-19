package com.transporte.transporte.ventas.models;

import com.transporte.transporte.users.models.Cliente;
import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "ventas")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID codigoVenta;

    @ManyToOne
    @JoinColumn(name = "salida_id", nullable = false)
    private Salida salida;

    @ManyToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "idUsuario", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "servicio_id", nullable = false)
    private Servicio servicio;

    @Column(nullable = false)
    private int asiento;

    public Venta() {}

    // Getters and Setters
}