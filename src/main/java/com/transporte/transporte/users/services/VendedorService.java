package com.transporte.transporte.users.services;

import com.transporte.transporte.users.models.Vendedor;
import com.transporte.transporte.users.repositories.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class VendedorService {

    @Autowired
    private VendedorRepository vendedorRepository;
    public void dropNotNullConstraintFromRegion() {
        String sql = "ALTER TABLE vendedores ALTER COLUMN region DROP NOT NULL";

    }
    public List<Vendedor> findAll() {
        return vendedorRepository.findAll();
    }

    public Optional<Vendedor> findById(UUID id) {
        return vendedorRepository.findById(id);
    }

    public Optional<Vendedor> findByDni(String dni) {
        return vendedorRepository.findByDni(dni);
    }

    public Vendedor save(Vendedor vendedor) {
        if (vendedor.getIdUsuario() == null) {
            vendedor.setIdUsuario(UUID.randomUUID());
        }
        return vendedorRepository.save(vendedor);
    }

    public void deleteById(UUID id) {
        vendedorRepository.deleteById(id);
    }
}