package com.example.evaluacionparcial1.model.dto;

import com.example.evaluacionparcial1.model.Enums.Estado;
import com.example.evaluacionparcial1.model.Enums.Prioridad;
import java.time.LocalDateTime;
import java.util.UUID;

public record ReportResponse(
        UUID id,
        String title,
        String description,
        Estado estado,
        Prioridad prioridad,
        String usuarioReportante,
        LocalDateTime fechaRegistro

) {
}
