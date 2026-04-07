package com.example.evaluacionparcial1.controller;

import com.example.evaluacionparcial1.model.dto.IncidenciaRequest;
import com.example.evaluacionparcial1.model.dto.IncidenciaResponse;
import com.example.evaluacionparcial1.service.IncidenciaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/incidencia")
public class IncidenciaController {

    private final IncidenciaService service;

    @GetMapping
    public ResponseEntity<List<IncidenciaResponse>> getReports() {
        return ResponseEntity.ok(service.getReports());
    }

    @GetMapping("/{id}")
    public ResponseEntity<IncidenciaResponse> getReport(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getReportById(id));
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<IncidenciaResponse>> getReportsByEstado(@Valid @PathVariable String estado) {
        return ResponseEntity.ok(service.getReportsByEstado(estado));
    }

    @PostMapping
    public ResponseEntity<IncidenciaResponse> createReport(@Valid @RequestBody IncidenciaRequest incidenciaRequest) {
        return ResponseEntity.status(201).body(service.createReport(incidenciaRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<IncidenciaResponse> updateReport(@Valid @RequestBody IncidenciaRequest incidenciaRequest, @PathVariable UUID id) {
        return ResponseEntity.ok(service.updateReportById(incidenciaRequest, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReport(@PathVariable UUID id) {
        service.deleteReportById(id);
        return ResponseEntity.noContent().build();
    }
}