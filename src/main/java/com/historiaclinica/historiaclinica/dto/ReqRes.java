package com.historiaclinica.historiaclinica.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.historiaclinica.historiaclinica.entity.Usuario;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReqRes {

    private int statusCode;
    private String error;
    private String message;
    private String token;
    private String refreshToken;
    private String expirationTime;
    private String nombre;
    private String email;
    private String role;
    private String password;
    //private List<Product> products;
    private Usuario usuarios;
    private List<Usuario> usuariosList;

}
