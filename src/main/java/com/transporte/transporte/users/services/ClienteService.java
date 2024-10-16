package com.transporte.transporte.users.services;

import com.transporte.transporte.users.models.Cliente;
import com.transporte.transporte.users.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> findById(UUID id) {
        return clienteRepository.findById(id);
    }

    public Optional<Cliente> findByDni(String dni) {
        return clienteRepository.findByDni(dni);
    }

    public Cliente save(Cliente cliente) {
        if (cliente.getIdUsuario() == null) {
            cliente.setIdUsuario(UUID.randomUUID());
        }
        return clienteRepository.save(cliente);
    }

    public void deleteById(UUID id) {
        clienteRepository.deleteById(id);
    }
}