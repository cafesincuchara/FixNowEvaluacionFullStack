package com.example.evaluacionparcial1.model.dto;

import jakarta.validation.constraints.NotBlank;

public record ReportRequest(
        @NotBlank(message = "El título no puede estar vacío")
        String title,
        @NotBlank(message = "La descripción es obligatoria")
        String descripcion,
        @NotBlank(message = "El usuario reportante es obligatorio")
        String usuarioReportante
) {
}