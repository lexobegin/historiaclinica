package com.historiaclinica.historiaclinica.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.historiaclinica.historiaclinica.entity.Usuario;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsuarioRequest {
    private int statusCode;
    private String error;
    private String message;
    private String token;
    private String refreshToken;
    private String expirationTime;
    private String nombre;
    private String direccion;
    private String telefono;
    private String edad;
    private String nroLicencia;
    private String email;
    private String role;
    private String password;
    private boolean sexo;
    private Boolean estadoPaciente;
    //private List<Product> products;
    //@JsonBackReference
    private Usuario usuarios;

    //@JsonManagedReference
    private List<Usuario> usuariosList;

}
