package com.historiaclinica.historiaclinica.controller;

import com.historiaclinica.historiaclinica.dto.RolPermisoRequest;
import com.historiaclinica.historiaclinica.entity.RolesPermisos;
import com.historiaclinica.historiaclinica.service.RolPermisoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class RolesPermisosController {

    @Autowired
    private RolPermisoService rolesPermisosService;

    @GetMapping("/get-all-roles-permisos")
    public ResponseEntity<List<RolesPermisos>> getAllRolesPermisos() {
        List<RolesPermisos> rolesPermisos = rolesPermisosService.getAllRolesPermisos();
        return ResponseEntity.ok(rolesPermisos);
    }

    @PostMapping("/roles-permisos")//create
    public ResponseEntity<RolesPermisos> createRolesPermisos(@RequestBody RolPermisoRequest request) {
        RolesPermisos rolesPermisos = rolesPermisosService.createRolesPermisos(request);
        return ResponseEntity.ok(rolesPermisos);
    }

    @PutMapping("/roles-permisos")//update
    public ResponseEntity<RolesPermisos> updateRolesPermisos(@RequestBody RolPermisoRequest request) {
        RolesPermisos updatedRolesPermisos = rolesPermisosService.updateRolesPermisos(request);
        return ResponseEntity.ok(updatedRolesPermisos);
    }

    @DeleteMapping("/roles-permisos")
    public ResponseEntity<Void> deleteRolesPermisos(@RequestParam Integer rolId, @RequestParam Integer permisoId) {
        rolesPermisosService.deleteRolesPermisos(rolId, permisoId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/roles-permisos")//get
    public ResponseEntity<RolesPermisos> getRolesPermisosById(@RequestParam Integer rolId, @RequestParam Integer permisoId) {
        RolesPermisos rolesPermisos = rolesPermisosService.getRolesPermisosById(rolId, permisoId);
        return ResponseEntity.ok(rolesPermisos);
    }

}
