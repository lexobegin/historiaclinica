package com.historiaclinica.historiaclinica.controller;

import com.historiaclinica.historiaclinica.dto.ReqRes;
import com.historiaclinica.historiaclinica.dto.UsuarioRequest;
import com.historiaclinica.historiaclinica.entity.Usuario;
import com.historiaclinica.historiaclinica.repository.UsuarioRepo;
import com.historiaclinica.historiaclinica.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class PacientesController {

    @Autowired
    private UsuarioService usersManagementService;

    @Autowired
    private UsuarioRepo usuarioRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("get-all")
    public ResponseEntity<ReqRes> getAllUsers(){
        return ResponseEntity.ok(usersManagementService.getAllUsers());

    }

    @GetMapping("/get-all-paciente")
    public ResponseEntity<List<Usuario>> getAllPaciente() {
        List<Usuario> User = usersManagementService.getAllPaciente();
        return ResponseEntity.ok(User);
    }


//    @GetMapping("/admin/get-all-usersV2")
//    public ResponseEntity<List<Usuario>> getAllUsersV2() {
//        List<Usuario> User = usersManagementService.getAllUsersV2();
//        return ResponseEntity.ok(User);
//    }

    @GetMapping("/{pacienteId}") // getUser(id)
    public ResponseEntity<ReqRes> getUSerByID(@PathVariable Integer pacienteId){
        return ResponseEntity.ok(usersManagementService.getUsersById(pacienteId));

    }

    @PutMapping("/{pacienteId}")   //update
    public ResponseEntity<ReqRes> updateUser(@PathVariable Integer pacienteId, @RequestBody Usuario reqres){
        return ResponseEntity.ok(usersManagementService.updateUser(pacienteId, reqres));
    }

    @PostMapping("/paciente/create")
    public ResponseEntity<?> createPaciente(@RequestBody UsuarioRequest createPacienteRequest) {
        try {

            // Crear paciente
            Usuario usuario = new Usuario();
            usuario.setNombre(createPacienteRequest.getNombre());
            usuario.setDireccion(createPacienteRequest.getDireccion());
            usuario.setTelefono(createPacienteRequest.getTelefono());
            usuario.setEdad(createPacienteRequest.getEdad());
            usuario.setRole("PACIENTE");
            usuario.setSexo(createPacienteRequest.isSexo());
            usuario.setEstadoPaciente(true);

            usuario.setEmail(createPacienteRequest.getEmail());
            usuario.setPassword(passwordEncoder.encode(createPacienteRequest.getPassword()));

            usuarioRepo.save(usuario);

            return ResponseEntity.ok(usuario);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al crear el paciente: " + e.getMessage());
        }
    }

    @GetMapping("/paciente/{pacienteId}") // getUser(id)
    public ResponseEntity<ReqRes> getPacienteByID(@PathVariable Integer pacienteId){
        return ResponseEntity.ok(usersManagementService.getUsersById(pacienteId));
    }

    @PutMapping("/paciente/{pacienteId}")   //update
    public ResponseEntity<ReqRes> updatePaciente(@PathVariable Integer pacienteId, @RequestBody Usuario reqres){
        return ResponseEntity.ok(usersManagementService.updateUser(pacienteId, reqres));
    }

    @DeleteMapping("/paciente/{pacienteId}")
    public ResponseEntity<ReqRes> deletePaciente(@PathVariable Integer userId){
        return ResponseEntity.ok(usersManagementService.deleteUser(userId));
    }

//    @GetMapping("/adminuser/get-profile")
//    public ResponseEntity<ReqRes> getMyProfile(){
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String email = authentication.getName();
//
//        ReqRes response = usersManagementService.getMyInfo(email);
//        return  ResponseEntity.status(response.getStatusCode()).body(response);
//    }
//
//    @GetMapping("/adminuser/get-userToken")
//    public ResponseEntity<UserProfileMovil> getUserToken() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String email = authentication.getName();
//
//        ReqRes response = usersManagementService.getMyInfo(email);
//        Usuario user = response.getUsuarios();
//
//        UserProfileMovil userProfileDto = new UserProfileMovil();
//        userProfileDto.setId(user.getId());
//        userProfileDto.setEmail(user.getEmail());
//        userProfileDto.setNombre(user.getNombre());
//        userProfileDto.setPassword(user.getPassword());
//        userProfileDto.setRole(user.getRole());
//
//        return ResponseEntity.ok(userProfileDto);
//    }
//
//    @DeleteMapping("/admin/user/{userId}")
//    public ResponseEntity<ReqRes> deleteUSer(@PathVariable Integer userId){
//        return ResponseEntity.ok(usersManagementService.deleteUser(userId));
//    }

}
