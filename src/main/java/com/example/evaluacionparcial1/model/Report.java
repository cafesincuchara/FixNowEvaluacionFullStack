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
@Table(name="repors")
@AllArgsConstructor
@NoArgsConstructor
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotBlank
    private String title;
    @NotBlank
    private String description;
    @Enumerated(EnumType.STRING)
    private Estado estado;
    @Enumerated(EnumType.STRING)
    private Prioridad prioridad;
    @NotBlank
    private String usuarioReportante; // nombre del usuario que reporta el problema
    @NotNull
    private LocalDateTime fechaRegistro;
}
