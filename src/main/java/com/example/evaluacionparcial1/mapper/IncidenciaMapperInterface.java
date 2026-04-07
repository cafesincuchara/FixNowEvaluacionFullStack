package com.example.evaluacionparcial1.mapper;

import com.example.evaluacionparcial1.model.Incidencia;
import com.example.evaluacionparcial1.model.dto.IncidenciaRequest;
import com.example.evaluacionparcial1.model.dto.IncidenciaResponse;

public interface IncidenciaMapperInterface {
   Incidencia toEntity(IncidenciaRequest request);
   IncidenciaResponse toIncidenciaResponse(Incidencia incidencia);
}