package com.example.evaluacionparcial1.model;

import com.example.evaluacionparcial1.model.Enums.Estado;
import com.example.evaluacionparcial1.model.Enums.Prioridad;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Setter @Getter
@Table(name="incidencias")
@AllArgsConstructor
@NoArgsConstructor
public class Incidencia {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotBlank(message = "El titulo no puede estar vacio")
    private String title;
    @NotBlank(message = "La descripcion no puede estar vacia")
    private String description;
    @Enumerated(EnumType.STRING)
    private Estado estado;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Prioridad prioridad;
    @NotBlank(message = "Se necesita un reporte por parte del usuario")
    private String usuarioReportante; // nombre del usuario que reporta el problema
    @NotNull
    private LocalDateTime fechaRegistro;
}
