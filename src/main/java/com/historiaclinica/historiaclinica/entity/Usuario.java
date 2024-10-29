package com.historiaclinica.historiaclinica.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name="usuarios")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String email;
    private String password;
    private String telefono;
    private String direccion;

    // Atributos específicos de Medico
    private String estadoMedico = "Activo"; //Activo, En licencia, etc
    private String nroLicencia;

    @ManyToOne
    @JoinColumn(name = "especialidad_id")
    private Especialidad especialidad;  // Relación con Especialidad

    @OneToMany(mappedBy = "usuario")
    private List<DiaAtencion> diasAtencion; // Relación con Día de Atención

    @OneToMany(mappedBy = "medico")
    private List<FichaAtencion> fichasAtencionm; // Relación con Ficha de Atención

    @OneToMany(mappedBy = "paciente")
    private List<FichaAtencion> fichasAtencionp; // Relación con Ficha de Atención


    // Atributos específicos de Paciente
    private String genero;
    private Boolean estadoPaciente = true;

    // Atributos específicos de Administrador
    private Boolean estadoAdmin = true;







    private String role;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role));
    }

    //@OneToMany(mappedBy = "docente")
    //private Set<DocenteMaterias> docenteMaterias;


    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
