package com.historiaclinica.historiaclinica.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "rol_usuario")
public class RolUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario_id;

    @ManyToOne
    @JoinColumn(name = "rol_id", nullable = false)
    private Rol rol_id;
}
