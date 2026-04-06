package com.example.evaluacionparcial1.model.dto;

public record ReportRequest(
        String title,
        String descripcion,
        String usuarioReportante
) {

}
