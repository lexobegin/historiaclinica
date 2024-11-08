package com.historiaclinica.historiaclinica.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "diaatencion")
public class DiaAtencion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String dia; // Ejemplo: "Lunes", "Martes", etc.

    @ManyToOne
    @JoinColumn(name = "medico_id", nullable = false)
    private Usuario usuario; // Relación con Médico

    @ManyToMany
    @JoinTable(
            name = "dia_horario",
            joinColumns = @JoinColumn(name = "diaatencion_id"),
            inverseJoinColumns = @JoinColumn(name = "horarioatencion_id")
    )
    private List<HorarioAtencion> horariosAtencion; // Relación con Horario de Atención
}
