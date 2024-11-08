package com.historiaclinica.historiaclinica.dto;

import lombok.Data;

@Data
public class EspecialidadRequest {

    private String nombre;
    private String descripcion;
    private String condicionestratadas;
    private boolean estado;
    //private Integer medico_id;

}
