package com.historiaclinica.historiaclinica.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "antecedentemedico")
public class AntecedenteMedico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Usuario paciente;  // Relación directa a Usuario con rol Paciente

    private String enfermedadesCronicas;
    private String medicamentosActuales;
    private String alergias;
    private String antecedentesQuirurgicos;

}
