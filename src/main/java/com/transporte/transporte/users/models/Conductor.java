package com.transporte.transporte.users.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Entity
@Table(name = "conductores")
@Data
@EqualsAndHashCode(callSuper = true)
public class Conductor extends Usuario {

    // Default constructor
    public Conductor() {
        super();
    }

    public Conductor(String nombre, LocalDate fechaNacimiento, String primerApellido, String segundoApellido, String telefono, String dni) {
        super(nombre, fechaNacimiento, primerApellido, segundoApellido, telefono, dni);
    }

    @Override
    public String toString() {
        return "Conductor{" +
                "nombre='" + nombre + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", primerApellido='" + primerApellido + '\'' +
                ", segundoApellido='" + segundoApellido + '\'' +
                ", telefono='" + telefono + '\'' +
                ", dni='" + dni + '\'' +
                '}';
    }
}