package com.example.demo.service;

import com.example.demo.entity.Medicamento;
import com.example.demo.repository.MedicamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicamentoService {

    private final MedicamentoRepository repository;

    public MedicamentoService(MedicamentoRepository repository) {
        this.repository = repository;
    }

    public Medicamento guardar(Medicamento medicamento) {

        if (medicamento.getPrecio() <= 0) {
            throw new IllegalArgumentException("El precio del medicamento debe ser mayor a cero.");
        }

        if (medicamento.getCantidadInventario() < 0) {
            throw new IllegalArgumentException("La cantidad en inventario no puede ser negativa.");
        }

        return repository.save(medicamento);
    }

    public List<Medicamento> listarTodos() {
        return repository.findAll();
    }
}