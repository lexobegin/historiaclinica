package com.historiaclinica.historiaclinica.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "especialidades")
public class Especialidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //@Column(nullable = false)condicionestratadas
    private String nombre;
    private String descripcion;
    private String condicionestratadas;
    private boolean estado = true;

    /*@ManyToOne
    @JoinColumn(name = "medico_id", nullable = false)
    @JsonBackReference
    private Usuario medico;*/ // Relación con el usuario de tipo médico

    //NO//@ManyToMany(mappedBy = "especialidades")
    //@JsonBackReference
    //NO//private List<Usuario> usuarios; // Relación muchos a muchos con Usuario

}
