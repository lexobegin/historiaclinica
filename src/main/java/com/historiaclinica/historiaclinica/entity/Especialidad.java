package com.historiaclinica.historiaclinica.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "especialidades")
public class Especialidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column(nullable = false)
    private String nombre;
    private boolean estado = true;

    @ManyToOne
    @JoinColumn(name = "medico_id", nullable = false)
    private Usuario medico; // Relación con el usuario de tipo médico

}
