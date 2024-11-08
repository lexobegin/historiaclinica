package com.historiaclinica.historiaclinica.controller;

import com.historiaclinica.historiaclinica.dto.RolUsuarioRequest;
import com.historiaclinica.historiaclinica.entity.RolUsuario;
import com.historiaclinica.historiaclinica.service.RolUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class RolUserController {

    @Autowired
    private RolUsuarioService rolUserService;

    @GetMapping("/get-all-rol-users")
    public ResponseEntity<List<RolUsuario>> getAllRolUsers() {
        List<RolUsuario> rolUsers = rolUserService.getAllRolUsers();
        return ResponseEntity.ok(rolUsers);
    }

    @PostMapping("-rol-user")//create
    public ResponseEntity<RolUsuario> createRolUser(@RequestBody RolUsuarioRequest request) {
        RolUsuario rolUser = rolUserService.createRolUser(request);
        return ResponseEntity.ok(rolUser);
    }

    @DeleteMapping("/rol-user/{id}")
    public ResponseEntity<Void> deleteRolUser(@PathVariable Integer id) {
        rolUserService.deleteRolUser(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/rol-user/{id}")//get
    public ResponseEntity<RolUsuario> getRolUserById(@PathVariable Integer id) {
        RolUsuario rolUser = rolUserService.getRolUserById(id);
        return ResponseEntity.ok(rolUser);
    }

}
