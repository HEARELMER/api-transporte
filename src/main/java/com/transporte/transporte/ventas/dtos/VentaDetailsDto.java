package com.transporte.transporte.ventas.dtos;

import java.time.LocalDate;
import java.util.UUID;

public class VentaDetailsDto {
    private UUID codigoVenta;
    private UUID salidaId;
    private UUID servicioId;
    private int asiento;
    private String clienteNombre;
    private LocalDate clienteFechaNacimiento;
    private String clientePrimerApellido;
    private String clienteSegundoApellido;
    private String clienteTelefono;
    private String clienteDni;

    // Default constructor
    public VentaDetailsDto() {}

    // Getters and setters
    public void setCodigoVenta(UUID codigoVenta) {
        this.codigoVenta = codigoVenta;
    }

    public void setSalidaId(UUID salidaId) {
        this.salidaId = salidaId;
    }

    public void setServicioId(UUID servicioId) {
        this.servicioId = servicioId;
    }

    public void setAsiento(int asiento) {
        this.asiento = asiento;
    }

    public void setClienteNombre(String clienteNombre) {
        this.clienteNombre = clienteNombre;
    }

    public void setClienteFechaNacimiento(LocalDate clienteFechaNacimiento) {
        this.clienteFechaNacimiento = clienteFechaNacimiento;
    }

    public void setClientePrimerApellido(String clientePrimerApellido) {
        this.clientePrimerApellido = clientePrimerApellido;
    }

    public void setClienteSegundoApellido(String clienteSegundoApellido) {
        this.clienteSegundoApellido = clienteSegundoApellido;
    }

    public void setClienteTelefono(String clienteTelefono) {
        this.clienteTelefono = clienteTelefono;
    }

    public void setClienteDni(String clienteDni) {
        this.clienteDni = clienteDni;
    }

    // Getters
    public UUID getCodigoVenta() {
        return codigoVenta;
    }

    public UUID getSalidaId() {
        return salidaId;
    }

    public UUID getServicioId() {
        return servicioId;
    }

    public int getAsiento() {
        return asiento;
    }

    public String getClienteNombre() {
        return clienteNombre;
    }

    public LocalDate getClienteFechaNacimiento() {
        return clienteFechaNacimiento;
    }

    public String getClientePrimerApellido() {
        return clientePrimerApellido;
    }

    public String getClienteSegundoApellido() {
        return clienteSegundoApellido;
    }

    public String getClienteTelefono() {
        return clienteTelefono;
    }

    public String getClienteDni() {
        return clienteDni;
    }
}