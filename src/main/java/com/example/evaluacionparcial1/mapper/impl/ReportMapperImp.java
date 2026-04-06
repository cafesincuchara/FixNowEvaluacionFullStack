package com.example.evaluacionparcial1.mapper.impl;

import com.example.evaluacionparcial1.mapper.ReportMapperInterface;
import com.example.evaluacionparcial1.model.Enums.Estado;
import com.example.evaluacionparcial1.model.Enums.Prioridad;
import com.example.evaluacionparcial1.model.dto.ReportRequest;
import com.example.evaluacionparcial1.model.dto.ReportResponse;

import java.time.LocalDateTime;

public class ReportMapperImp implements ReportMapperInterface {

    @Override
    public ReportResponse toRportResponse(ReportRequest request) {
        ReportResponse response = new ReportResponse(
                request.title(),
                request.descripcion(),
                Estado.ABIERTA,
                Prioridad.ALTA,
                request.usuarioReportante(),
                LocalDateTime.now()
        );
        return response;
    }

    @Override
    public ReportRequest toReportRequest(ReportResponse response) {

        ReportRequest request = new ReportRequest(
                response.title(),
                response.description(),
                response.usuarioReportante()
        );
        return request;
    }
}
