package com.historiaclinica.historiaclinica.controller;

import com.historiaclinica.historiaclinica.dto.EspecialidadRequest;
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

    @PostMapping("/especialidad/create")
    public ResponseEntity<Especialidad> createEspecialidad(@RequestBody EspecialidadRequest especialidadRequest) {
        Especialidad createdEspecialidad = especialidadService.createEspecialidad(especialidadRequest);
        return ResponseEntity.ok(createdEspecialidad);
    }

    @PutMapping("/especialidad/update/{id}")
    public ResponseEntity<Especialidad> updateEspecialidad(@PathVariable Integer id, @RequestBody EspecialidadRequest especialidadRequest) {
        Especialidad updatedEspecialidad = especialidadService.updateEspecialidad(id, especialidadRequest);
        return ResponseEntity.ok(updatedEspecialidad);
    }

    @DeleteMapping("/especialidad/delete/{id}")
    public ResponseEntity<Void> deleteEspecialidad(@PathVariable Integer id) {
        especialidadService.deleteEspecialidad(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/especialidad/get/{id}")
    public Especialidad getEspecialidadById(@PathVariable Integer id) {
        return especialidadService.getEspecialidadById(id);
    }

}
