package com.example.evaluacionparcial1.mapper.impl;

import com.example.evaluacionparcial1.mapper.IncidenciaMapperInterface;
import com.example.evaluacionparcial1.model.Enums.Estado;
import com.example.evaluacionparcial1.model.Enums.Prioridad;
import com.example.evaluacionparcial1.model.Incidencia;
import com.example.evaluacionparcial1.model.dto.IncidenciaRequest;
import com.example.evaluacionparcial1.model.dto.IncidenciaResponse;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class IncidenciaMapperImp implements IncidenciaMapperInterface {

    @Override
    public Incidencia toEntity(IncidenciaRequest request) {
        Incidencia incidencia = new Incidencia();
        incidencia.setTitle(request.title());
        incidencia.setDescription(request.descripcion());
        incidencia.setUsuarioReportante(request.usuarioReportante());
        incidencia.setEstado(Estado.ABIERTA);
        incidencia.setPrioridad(Prioridad.ALTA);
        incidencia.setFechaRegistro(LocalDateTime.now());
        return incidencia;
    }

    @Override
    public IncidenciaResponse toReportResponse(Incidencia incidencia) {
        return new IncidenciaResponse(
                incidencia.getId(),
                incidencia.getTitle(),
                incidencia.getDescription(),
                incidencia.getEstado(),
                incidencia.getPrioridad(),
                incidencia.getUsuarioReportante(),
                incidencia.getFechaRegistro()
        );
    }
}