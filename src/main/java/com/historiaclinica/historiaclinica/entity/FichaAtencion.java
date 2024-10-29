package com.historiaclinica.historiaclinica.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "fichaatencion")
public class FichaAtencion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fechaAtencion;
    private String estado = "Pendiente"; //"Pendiente", "Completada", "Cancelada".

    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Usuario medico; // Relación con Médico

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Usuario paciente; // Relación con Paciente
}
