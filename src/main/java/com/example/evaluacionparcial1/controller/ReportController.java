package com.example.evaluacionparcial1.controller;

import com.example.evaluacionparcial1.model.Report;
import com.example.evaluacionparcial1.model.dto.ReportRequest;
import com.example.evaluacionparcial1.model.dto.ReportResponse;
import com.example.evaluacionparcial1.service.ReportService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/resport")
public class ReportController {

    private final ReportService service;

    @GetMapping
    public ResponseEntity<List<Report>> getReports() {
        return ResponseEntity.ok(service.getReports());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Report> getReport(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getReportById(id));
    }

    @PostMapping
    public ResponseEntity<ReportResponse> createReport(@RequestBody ReportRequest reportRequest) {
        return ResponseEntity.ok(service.createReport(reportRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReportResponse> updateReport(@RequestBody ReportRequest reportRequest, @PathVariable UUID id) {
        return ResponseEntity.ok(service.updateReportById(reportRequest, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReport(@PathVariable UUID id) {
        service.deleteReportById(id);
        return ResponseEntity.ok().build();
    }

}
