package com.transporte.transporte.Vehiculos.models;

import com.transporte.transporte.users.models.Cliente;
import com.transporte.transporte.users.models.Conductor;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "vehiculos")
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String identificador;

    @Column(name = "conductor_id", nullable = false)
    private UUID conductorId;

    @Transient
    private Conductor conductor;

    @Column(nullable = false)
    private int capacidad;

    @ManyToMany
    @JoinTable(
            name = "vehiculo_asientos",
            joinColumns = @JoinColumn(name = "vehiculo_id"),
            inverseJoinColumns = @JoinColumn(name = "idUsuario")
    )
    private List<Cliente> asientos = new ArrayList<>();

    @Column(nullable = false)
    private int asientosOcupados;

    public Vehiculo() {}

    public Vehiculo(String identificador, UUID conductorId, int capacidad) {
        this.identificador = identificador;
        this.conductorId = conductorId;
        this.capacidad = capacidad;
        this.asientosOcupados = 0;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public UUID getConductorId() {
        return conductorId;
    }

    public void setConductorId(UUID conductorId) {
        this.conductorId = conductorId;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public List<Cliente> getAsientos() {
        return asientos;
    }

    public void setAsientos(List<Cliente> asientos) {
        this.asientos = asientos;
    }

    public int getAsientosOcupados() {
        return asientosOcupados;
    }

    public void setAsientosOcupados(int asientosOcupados) {
        this.asientosOcupados = asientosOcupados;
    }

    public boolean asignarPasajero(Cliente pasajero) {
        if (asientosOcupados < capacidad) {
            this.asientos.add(pasajero);
            asientosOcupados++;
            return true;
        } else {
            return false;
        }
    }

    public boolean eliminarPasajero(String dni) {
        for (int i = 0; i < asientos.size(); i++) {
            if (asientos.get(i).getDni().equals(dni)) {
                asientos.remove(i);
                asientosOcupados--;
                return true;
            }
        }
        return false;
    }
}