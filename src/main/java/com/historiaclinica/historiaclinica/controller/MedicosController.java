package com.historiaclinica.historiaclinica.controller;

import com.historiaclinica.historiaclinica.dto.ReqRes;
import com.historiaclinica.historiaclinica.entity.Usuario;
import com.historiaclinica.historiaclinica.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class MedicosController {

    @Autowired
    private UsuarioService usersManagementService;

    @GetMapping("get-all-med")
    public ResponseEntity<ReqRes> getAllUsers(){
        return ResponseEntity.ok(usersManagementService.getAllUsers());

    }

    @GetMapping("/get-all-medico")
    public ResponseEntity<List<Usuario>> getAllMedico() {
        List<Usuario> User = usersManagementService.getAllMedico();
        return ResponseEntity.ok(User);
    }

    @GetMapping("/{medicoId}") // getUser(id)
    public ResponseEntity<ReqRes> getUSerByID(@PathVariable Integer pacienteId){
        return ResponseEntity.ok(usersManagementService.getUsersById(pacienteId));

    }

    @PutMapping("/{medicoId}")   //update
    public ResponseEntity<ReqRes> updateUser(@PathVariable Integer pacienteId, @RequestBody Usuario reqres){
        return ResponseEntity.ok(usersManagementService.updateUser(pacienteId, reqres));
    }

    @PostMapping("/{usuarioId}/especialidades/{especialidadId}")
    public ResponseEntity<String> asignarEspecialidad(
            @PathVariable Integer usuarioId,
            @PathVariable Integer especialidadId) {

        usersManagementService.asignarEspecialidadAMedico(usuarioId, especialidadId);
        return ResponseEntity.ok("Especialidad asignada correctamente");
    }

}
