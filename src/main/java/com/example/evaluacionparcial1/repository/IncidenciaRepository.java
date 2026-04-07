package com.example.evaluacionparcial1.repository;

import com.example.evaluacionparcial1.model.Enums.Estado;
import com.example.evaluacionparcial1.model.Incidencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IncidenciaRepository extends JpaRepository<Incidencia, UUID> {
    List<Incidencia> findByEstado(Estado estado);
}
