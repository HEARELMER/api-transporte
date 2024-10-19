package com.transporte.transporte.users.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "clientes")
@Data
@EqualsAndHashCode(callSuper = true)
public class Cliente extends Usuario {


    public Cliente() {
        super();
    }

    public Cliente(String nombre, LocalDate fechaNacimiento, String primerApellido, String segundoApellido, String telefono, String dni) {
        super(nombre, fechaNacimiento, primerApellido, segundoApellido, telefono, dni);
    }



    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", primerApellido='" + primerApellido + '\'' +
                ", segundoApellido='" + segundoApellido + '\'' +
                ", telefono='" + telefono + '\'' +
                ", dni='" + dni + '\'' +
                '}';
    }
}