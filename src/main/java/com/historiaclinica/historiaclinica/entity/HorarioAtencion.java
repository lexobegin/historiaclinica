package com.historiaclinica.historiaclinica.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "horarioatencion")
public class HorarioAtencion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String horaInicio;
    private String horaFin;
    private String hora;

    @ManyToMany(mappedBy = "horariosAtencion")
    private List<DiaAtencion> diasAtencion; // Relación con Día de Atención

}
