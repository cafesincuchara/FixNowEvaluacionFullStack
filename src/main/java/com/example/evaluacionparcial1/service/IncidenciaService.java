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

    public IncidenciaResponse createIncidencia(IncidenciaRequest request) { //creacion de incidencia
        Incidencia incidencia = mapper.toEntity(request);
        Incidencia savedIncidencia = repository.save(incidencia);
        return mapper.toIncidenciaResponse(savedIncidencia);
    }

    public IncidenciaResponse updateIncidenciaById(IncidenciaRequest request, UUID id) {

        return repository.findById(id).map(incidencia -> {
            incidencia.setTitle(request.title());
            incidencia.setDescription(request.descripcion());
            incidencia.setUsuarioReportante(request.usuarioReportante());

            Incidencia nuevoIncidencia = repository.save(incidencia);
            return mapper.toIncidenciaResponse(nuevoIncidencia);
        }).orElseThrow(() -> new RuntimeException("No se encontro el ID del Incidencia"));
    }

    public List<IncidenciaResponse> getIncidencia() {
        return repository.findAll().stream().map(mapper::toIncidenciaResponse).toList();
    }

    public IncidenciaResponse getIncidenciaById(UUID id) {
        Incidencia incidencia = repository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el ID del Incidencia"));
        return mapper.toIncidenciaResponse(incidencia);
    }

    public void deleteIncidenciaById(UUID id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Incidencia no existe");
        }
        repository.deleteById(id);
    }

    public List<IncidenciaResponse> getIncidenciaByEstado(String requestEstado){
        Estado estado = Estado.valueOf(requestEstado.toUpperCase());
        return repository.findByEstado(estado).stream().map(mapper::toIncidenciaResponse).toList();
    }

}