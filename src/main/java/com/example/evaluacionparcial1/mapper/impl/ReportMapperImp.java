package com.example.evaluacionparcial1.mapper.impl;

import com.example.evaluacionparcial1.mapper.ReportMapperInterface;
import com.example.evaluacionparcial1.model.Enums.Estado;
import com.example.evaluacionparcial1.model.Enums.Prioridad;
import com.example.evaluacionparcial1.model.Report;
import com.example.evaluacionparcial1.model.dto.ReportRequest;
import com.example.evaluacionparcial1.model.dto.ReportResponse;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ReportMapperImp implements ReportMapperInterface {

    @Override
    public Report toEntity(ReportRequest request) {
        Report report = new Report();
        report.setTitle(request.title());
        report.setDescription(request.descripcion());
        report.setUsuarioReportante(request.usuarioReportante());
        report.setEstado(Estado.ABIERTA);
        report.setPrioridad(Prioridad.ALTA);
        report.setFechaRegistro(LocalDateTime.now());
        return report;
    }

    @Override
    public ReportResponse toReportResponse(Report report) {
        return new ReportResponse(
                report.getId(),
                report.getTitle(),
                report.getDescription(),
                report.getEstado(),
                report.getPrioridad(),
                report.getUsuarioReportante(),
                report.getFechaRegistro()
        );
    }
}