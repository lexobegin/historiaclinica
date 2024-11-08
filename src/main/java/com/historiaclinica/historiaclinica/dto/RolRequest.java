package com.historiaclinica.historiaclinica.dto;

import lombok.Data;

import java.util.List;

@Data
public class RolRequest {

    private String nombre;
    private boolean estado;
    private List<Integer> permissions;

}
