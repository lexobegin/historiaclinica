package com.historiaclinica.historiaclinica.controller;

import com.historiaclinica.historiaclinica.entity.Especialidad;
import com.historiaclinica.historiaclinica.service.EspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class EspecialidadController {

    @Autowired
    private EspecialidadService especialidadService;

    @GetMapping("/especialidad/get-all")
    public ResponseEntity<List<Especialidad>> getAllEspecialidades() {
        List<Especialidad> especialidades = especialidadService.getAllEspecialidades();
        return ResponseEntity.ok(especialidades);
    }
    /*
    @PostMapping("/create-aula")
    public ResponseEntity<Aulas> createAula(@RequestBody AulasRequest aulasRequest) {
        Aulas createdAula = aulasService.createAula(aulasRequest);
        return ResponseEntity.ok(createdAula);
    }

    @PutMapping("/update-aula/{id}")
    public ResponseEntity<Aulas> updateAula(@PathVariable Integer id, @RequestBody AulasRequest aulasRequest) {
        Aulas updatedAula = aulasService.updateAula(id, aulasRequest);
        return ResponseEntity.ok(updatedAula);
    }

    @DeleteMapping("/delete-aula/{id}")
    public ResponseEntity<Void> deleteAula(@PathVariable Integer id) {
        aulasService.deleteAula(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/get-aula/{id}")
    public Aulas getAulaById(@PathVariable Integer id) {
        return aulasService.getAulaById(id);
    }
    */
}
