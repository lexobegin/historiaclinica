package com.historiaclinica.historiaclinica.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "signosvitales")
public class SignosVitales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "evaluacioninicial_id", nullable = false)
    private EvaluacionInicial evaluacionInicial;

    private String presionArterial;  // Ejemplo: "120/80"
    private int frecuenciaCardiaca;
    private int frecuenciaRespiratoria;
    private double temperatura;
    private int saturacionOxigeno;
}
