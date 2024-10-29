package com.historiaclinica.historiaclinica.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "permisos")
public class Permiso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private boolean estado = true;
}
