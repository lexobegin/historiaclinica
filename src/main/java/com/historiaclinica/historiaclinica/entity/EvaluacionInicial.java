package com.historiaclinica.historiaclinica.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "evaluacioninicial")
public class EvaluacionInicial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fechaEvaluacion;
    private String motivoConsulta;
    private int nivelDolor;  // Del 1 al 10
    private String descripcionSintomas;
    private String tiempoEvolucion;

    @OneToOne
    @JoinColumn(name = "fichaatencion_id", nullable = false)
    private FichaAtencion fichaAtencion;  // Relación con FichaAtencion

    @OneToOne(mappedBy = "evaluacionInicial", cascade = CascadeType.ALL)
    private SignosVitales signosVitales;
}
