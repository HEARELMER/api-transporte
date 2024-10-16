package com.transporte.transporte.users.models;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import java.time.LocalDate;
import java.util.UUID;

@MappedSuperclass
@Data
public abstract class Usuario {
    @Id
    protected UUID idUsuario;

    @Column(nullable = false)
    protected String nombre;

    @Column(nullable = false)
    protected LocalDate fechaNacimiento;

    @Column(nullable = false)
    protected String primerApellido;

    @Column(nullable = false)
    protected String segundoApellido;

    @Column(nullable = false)
    protected String telefono;

    @Column(nullable = false, unique = true)
    protected String dni;

    public Usuario(String nombre, LocalDate fechaNacimiento, String primerApellido, String segundoApellido, String telefono, String dni) {
        this.idUsuario = UUID.randomUUID();
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.telefono = telefono;
        this.dni = dni;
    }

    public Usuario() {
    }

    public UUID getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(UUID idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}