package com.example.evaluacionparcial1.service;

import com.example.evaluacionparcial1.mapper.IncidenciaMapperInterface;
import com.example.evaluacionparcial1.model.Enums.Estado;
import com.example.evaluacionparcial1.model.Incidencia;
import com.example.evaluacionparcial1.model.dto.IncidenciaRequest;
import com.example.evaluacionparcial1.model.dto.IncidenciaResponse;
import com.example.evaluacionparcial1.repository.IncidenciaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class IncidenciaService {

    private final IncidenciaRepository repository;
    private final IncidenciaMapperInterface mapper;

    public IncidenciaResponse createReport(IncidenciaRequest request) {
        Incidencia incidencia = mapper.toEntity(request);
        Incidencia savedIncidencia = repository.save(incidencia);
        return mapper.toReportResponse(savedIncidencia);
    }

    public IncidenciaResponse updateReportById(IncidenciaRequest request, UUID id) {
        repository.findById(id).orElseThrow(() -> new RuntimeException("ID del reporte no encontrado"));

        IncidenciaRequest reportSave = new IncidenciaRequest(
                request.title(),
                request.descripcion(),
                request.usuarioReportante()
        );
        return mapper.toReportResponse(repository.save(mapper.toEntity(reportSave)));
    }

    public List<IncidenciaResponse> getReports() {
        return repository.findAll().stream().map(mapper::toReportResponse).toList();
    }

    public IncidenciaResponse getReportById(UUID id) {
        Incidencia incidencia = repository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el ID del reporte"));
        return mapper.toReportResponse(incidencia);
    }

    public void deleteReportById(UUID id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Reporte no existe");
        }
        repository.deleteById(id);
    }

    public List<IncidenciaResponse> getReportsByEstado(String requestEstado){
        Estado estado = Estado.valueOf(requestEstado.toUpperCase());
        return repository.findByEstado(estado).stream().map(mapper::toReportResponse).toList();
    }
}