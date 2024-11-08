package com.historiaclinica.historiaclinica.controller;

import com.historiaclinica.historiaclinica.dto.PermisoRequest;
import com.historiaclinica.historiaclinica.entity.Permiso;
import com.historiaclinica.historiaclinica.service.PermisoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class PermisosController {

    @Autowired
    private PermisoService permisosService;

    @GetMapping("/get-all-permisos")
    public ResponseEntity<List<Permiso>> getAllPermisos() {
        List<Permiso> permisos = permisosService.getAllPermisos();
        return ResponseEntity.ok(permisos);
    }

    @PostMapping("/permiso")//create
    public ResponseEntity<Permiso> createPermiso(@RequestBody PermisoRequest permisoRequest) {
        Permiso permiso = permisosService.createPermiso(permisoRequest);
        return ResponseEntity.ok(permiso);
    }

    @PutMapping("/permiso/{id}")//update
    public ResponseEntity<Permiso> updatePermiso(@PathVariable Integer id, @RequestBody PermisoRequest permisoRequest) {
        Permiso updatedPermiso = permisosService.updatePermiso(id, permisoRequest);
        return ResponseEntity.ok(updatedPermiso);
    }

    @DeleteMapping("/permiso/{id}")
    public ResponseEntity<Void> deletePermiso(@PathVariable Integer id) {
        permisosService.deletePermiso(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/permiso/{id}")//get
    public ResponseEntity<Permiso> getPermisoById(@PathVariable Integer id) {
        Permiso permiso = permisosService.getPermisoById(id);
        return ResponseEntity.ok(permiso);
    }

}
