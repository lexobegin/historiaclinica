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
    private String edad;
    private String peso;
    private String altura;

    // Atributos específicos de Medico
    private String estadoMedico = "Activo"; //Activo, En licencia, etc
    private String nroLicencia;

    @OneToMany(mappedBy = "medico", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Especialidad> especialidades; // Relación Uno a Muchos con Especialidad

    @OneToMany(mappedBy = "usuario")
    private List<DiaAtencion> diasAtencion; // Relación con Día de Atención

    @OneToMany(mappedBy = "medico")
    private List<FichaAtencion> fichasAtencionm; // Relación con Ficha de Atención




    // Atributos específicos de Paciente
    private boolean sexo; //true=Masculino, false=Femenino
    private Boolean estadoPaciente = true;

    @OneToOne(mappedBy = "paciente", cascade = CascadeType.ALL)
    private AntecedenteMedico antecedenteMedico;  // Relación con AntecedenteMedico

    @OneToMany(mappedBy = "paciente")
    private List<FichaAtencion> fichasAtencionp; // Relación con Ficha de Atención


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
