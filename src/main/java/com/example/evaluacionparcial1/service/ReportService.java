package com.example.evaluacionparcial1.service;

import com.example.evaluacionparcial1.mapper.ReportMapperInterface;
import com.example.evaluacionparcial1.model.Enums.Estado;
import com.example.evaluacionparcial1.model.Report;
import com.example.evaluacionparcial1.model.dto.ReportRequest;
import com.example.evaluacionparcial1.model.dto.ReportResponse;
import com.example.evaluacionparcial1.repository.ReportRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ReportService {

    private final ReportRepository repository;
    private final ReportMapperInterface mapper;

    public ReportResponse createReport(ReportRequest request) {
        Report report = mapper.toEntity(request);
        Report savedReport = repository.save(report);
        return mapper.toReportResponse(savedReport);
    }

    public ReportResponse updateReportById(ReportRequest request, UUID id) {
        return repository.findById(id).map(reportExistente -> {
            reportExistente.setTitle(request.title());
            reportExistente.setDescription(request.descripcion());
            reportExistente.setUsuarioReportante(request.usuarioReportante());

            Report updated = repository.save(reportExistente);
            return mapper.toReportResponse(updated);
        }).orElseThrow(() -> new RuntimeException("Report not found"));
    }

    public List<ReportResponse> getReports() {
        return repository.findAll().stream()
                .map(mapper::toReportResponse)
                .toList();
    }

    public ReportResponse getReportById(UUID id) {
        Report report = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Report not found"));
        return mapper.toReportResponse(report);
    }

    public void deleteReportById(UUID id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Report not found");
        }
        repository.deleteById(id);
    }

    public List<ReportResponse> getReportsByEstado(String requestEstado){
        Estado estado = Estado.valueOf(requestEstado.toUpperCase());
        return repository.findByEstado(estado).stream().map(mapper::toReportResponse).toList();
    }
}