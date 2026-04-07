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
    public ResponseEntity<List<IncidenciaResponse>> getincidencias() {
        return ResponseEntity.ok(service.getIncidencia());
    }

    @GetMapping("/{id}")
    public ResponseEntity<IncidenciaResponse> getReport(@Valid @PathVariable UUID id) {
        return ResponseEntity.ok(service.getIncidenciaById(id));
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<IncidenciaResponse>> getReportsByEstado(@PathVariable String estado) {
        return ResponseEntity.ok(service.getIncidenciaByEstado(estado));
    }

    @PostMapping
    public ResponseEntity<IncidenciaResponse> createReport(@Valid @RequestBody IncidenciaRequest incidenciaRequest) {
        return ResponseEntity.ok().body(service.createIncidencia(incidenciaRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<IncidenciaResponse> updateReport(@Valid @RequestBody IncidenciaRequest incidenciaRequest, @PathVariable UUID id) {
        return ResponseEntity.ok(service.updateIncidenciaById(incidenciaRequest, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReport(@PathVariable UUID id) {
        service.deleteIncidenciaById(id);
        return ResponseEntity.noContent().build();
    }
}