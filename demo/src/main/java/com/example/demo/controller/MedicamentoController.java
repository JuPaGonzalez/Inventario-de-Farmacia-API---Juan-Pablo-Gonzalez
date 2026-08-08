package com.example.demo.controller;

import com.example.demo.entity.Medicamento;
import com.example.demo.service.MedicamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicamentos")
public class MedicamentoController {

    private final MedicamentoService service;

    public MedicamentoController(MedicamentoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Medicamento> crearMedicamento(@RequestBody Medicamento medicamento) {

        Medicamento guardado = service.guardar(medicamento);

        return ResponseEntity.status(HttpStatus.CREATED).body(guardado);
    }

    @GetMapping
    public ResponseEntity<List<Medicamento>> listarMedicamentos() {

        return ResponseEntity.ok(service.listarTodos());
    }
}