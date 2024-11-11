package com.historiaclinica.historiaclinica.controller;

import com.historiaclinica.historiaclinica.dto.RolRequest;
import com.historiaclinica.historiaclinica.entity.Permiso;
import com.historiaclinica.historiaclinica.entity.Rol;
import com.historiaclinica.historiaclinica.repository.PermisoRepository;
import com.historiaclinica.historiaclinica.repository.RolRepository;
import com.historiaclinica.historiaclinica.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/admin")
public class RolesController {

    @Autowired
    private RolService rolesService;
    @Autowired
    private PermisoRepository permisosRepository;
    @Autowired
    private RolRepository rolesRepository;

    @GetMapping("/rol/get-all")
    public ResponseEntity<List<Rol>> getAllRoles() {
        List<Rol> roles = rolesService.getAllRoles();
        return ResponseEntity.ok(roles);
    }

    @PostMapping("/rol/create")
    public ResponseEntity<?> createRol(@RequestBody RolRequest createRoleRequest) {
        try {
            // Buscar los permisos por sus IDs
            List<Permiso> permisos = createRoleRequest.getPermissions().stream()
                    .map(permisoId -> permisosRepository.findById(permisoId))
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(Collectors.toList());

            if (permisos.isEmpty()) {
                return ResponseEntity.badRequest().body("No se encontraron permisos con los IDs proporcionados");
            }

            // Crear el nuevo rol y asignar los permisos
            Rol rol = new Rol();
            rol.setNombre(createRoleRequest.getNombre());
            rol.setPermissions(permisos);

            // Guardar el rol en el repositorio
            rolesRepository.save(rol);

            return ResponseEntity.ok(rol);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al crear el rol: " + e.getMessage());
        }
    }

    @PutMapping("/update-rol/{id}") //update
    public ResponseEntity<?> updateRol(@PathVariable("id") Integer id, @RequestBody RolRequest roleUpdateRequest) {
        Optional<Rol> existingRole = rolesRepository.findById(id);

        if (!existingRole.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Rol roleToUpdate = existingRole.get();
        roleToUpdate.setNombre(roleUpdateRequest.getNombre());

        List<Permiso> permisos = permisosRepository.findAllById(roleUpdateRequest.getPermissions());
        if (permisos.size() != roleUpdateRequest.getPermissions().size()) {
            return ResponseEntity.badRequest().body("Some permissions not found");
        }

        roleToUpdate.setPermissions(permisos);

        rolesRepository.save(roleToUpdate);

        return ResponseEntity.ok(roleToUpdate);
    }

    @DeleteMapping("/delete-rol/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable Integer id) {
        rolesService.deleteRole(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/get-rol/{id}")
    public ResponseEntity<Rol> getRoleById(@PathVariable Integer id) {
        Rol role = rolesService.getRoleById(id);
        return ResponseEntity.ok(role);
    }

}
