package com.transporte.transporte.ventas.services;

import com.transporte.transporte.ventas.dtos.VentaDetailsDto;
import com.transporte.transporte.ventas.models.Venta;
import com.transporte.transporte.ventas.repositories.VentaRepository;
import com.transporte.transporte.users.models.Cliente;
import com.transporte.transporte.users.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public Venta createVenta(Venta venta, Cliente cliente) {
        if (cliente.getIdUsuario() == null) {
            cliente.setIdUsuario(UUID.randomUUID());
        }
        cliente = clienteRepository.save(cliente);
        venta.setClienteId(cliente.getIdUsuario()); // Set the clienteId in venta

        if (venta.getSalidaId() == null) {
            throw new IllegalArgumentException("SalidaId cannot be null");
        }

        if (venta.getServicioId() == null) {
            throw new IllegalArgumentException("ServicioId cannot be null");
        }

        return ventaRepository.save(venta);
    }
    public List<Venta> getAllVentas() {
        return ventaRepository.findAll();
    }
    public List<VentaDetailsDto> getAllVentaDetails() {
        List<Venta> ventas = ventaRepository.findAll();
        return ventas.stream().map(venta -> {
            Optional<Cliente> clienteOpt = clienteRepository.findById(venta.getClienteId());
            if (!clienteOpt.isPresent()) {
                throw new IllegalArgumentException("Cliente not found for venta: " + venta.getCodigoVenta());
            }
            Cliente cliente = clienteOpt.get();
            VentaDetailsDto detailsDto = new VentaDetailsDto();
            detailsDto.setCodigoVenta(venta.getCodigoVenta());
            detailsDto.setSalidaId(venta.getSalidaId());
            detailsDto.setServicioId(venta.getServicioId());
            detailsDto.setAsiento(venta.getAsiento());
            detailsDto.setClienteNombre(cliente.getNombre());
            detailsDto.setClienteFechaNacimiento(cliente.getFechaNacimiento());
            detailsDto.setClientePrimerApellido(cliente.getPrimerApellido());
            detailsDto.setClienteSegundoApellido(cliente.getSegundoApellido());
            detailsDto.setClienteTelefono(cliente.getTelefono());
            detailsDto.setClienteDni(cliente.getDni());
            return detailsDto;
        }).collect(Collectors.toList());
    }
}