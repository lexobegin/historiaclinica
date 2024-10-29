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

    @OneToMany(mappedBy = "especialidad")
    private List<Usuario> medicos; // Relación con Médicos

}
