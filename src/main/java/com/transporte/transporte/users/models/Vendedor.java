package com.transporte.transporte.users.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Entity
@Table(name = "vendedores")
@Data
@EqualsAndHashCode(callSuper = true)
public class Vendedor extends Usuario {

    @Column(name = "contrasena")
    private String contrasena;

    // Default constructor
    public Vendedor() {
        super();
    }

    public Vendedor(String nombre, LocalDate fechaNacimiento, String primerApellido, String segundoApellido, String telefono, String dni, String contrasena) {
        super(nombre, fechaNacimiento, primerApellido, segundoApellido, telefono, dni);
        this.contrasena = contrasena;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}