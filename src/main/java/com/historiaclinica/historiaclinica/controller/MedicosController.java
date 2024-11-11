package com.historiaclinica.historiaclinica.controller;

import com.historiaclinica.historiaclinica.dto.ReqRes;
import com.historiaclinica.historiaclinica.entity.Especialidad;
import com.historiaclinica.historiaclinica.entity.Usuario;
import com.historiaclinica.historiaclinica.repository.EspecialidadRepository;
import com.historiaclinica.historiaclinica.repository.UsuarioRepo;
import com.historiaclinica.historiaclinica.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/admin")
public class MedicosController {

    @Autowired
    private UsuarioService usersManagementService;

    @Autowired
    private UsuarioRepo usuarioRepo;

    @Autowired
    private EspecialidadRepository especialidadRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/medico/create")
    public ResponseEntity<ReqRes> createMedico(@RequestBody ReqRes registrationRequest){
        return ResponseEntity.ok(usersManagementService.createMedico(registrationRequest));
    }

//    @PostMapping("/medico-create")
//    public ResponseEntity<?> createMedicoE(@RequestBody ReqRes createMedicoERequest) {
//        try {
//            // Buscar las especialidades por sus IDs
//            List<Especialidad> especialidads = createMedicoERequest.getEspecialidades().stream()
//                    .map(especialidadId -> especialidadRepository.findById(especialidadId))
//                    .filter(Optional::isPresent)
//                    .map(Optional::get)
//                    .collect(Collectors.toList());
//
//            if (especialidads.isEmpty()) {
//                return ResponseEntity.badRequest().body("No se encontraron especialidades con los IDs proporcionados");
//            }
//
//            // Crear medico y sus especialidades
//            Usuario usuario = new Usuario();
//            usuario.setNombre(createMedicoERequest.getNombre());
//            usuario.setDireccion(createMedicoERequest.getDireccion());
//            usuario.setTelefono(createMedicoERequest.getTelefono());
//            usuario.setEdad(createMedicoERequest.getEdad());
//            usuario.setNroLicencia(createMedicoERequest.getNroLicencia());
//
//            usuario.setEmail(createMedicoERequest.getEmail());
//            usuario.setPassword(passwordEncoder.encode(createMedicoERequest.getPassword()));
//
//            usuario.setEspecialidades(especialidads);
//
//            // Guardar el rol en el repositorio
//            usuarioRepo.save(usuario);
//
//            return ResponseEntity.ok(usuario);
//        } catch (Exception e) {
//            return ResponseEntity.status(500).body("Error al crear el medico: " + e.getMessage());
//        }
//    }

    @PostMapping("/medico/createm")
    public ResponseEntity<?> createMedicoE(@RequestBody ReqRes createMedicoERequest) {
        try {
            // Buscar las especialidades por sus IDs
            List<Especialidad> especialidads = createMedicoERequest.getEspecialidades().stream()
                    .map(especialidadId -> especialidadRepository.findById(especialidadId))
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(Collectors.toList());

            if (especialidads.isEmpty()) {
                return ResponseEntity.badRequest().body("No se encontraron especialidades con los IDs proporcionados");
            }

            // Crear medico y sus especialidades
            Usuario usuario = new Usuario();
            usuario.setNombre(createMedicoERequest.getNombre());
            usuario.setDireccion(createMedicoERequest.getDireccion());
            usuario.setTelefono(createMedicoERequest.getTelefono());
            usuario.setEdad(createMedicoERequest.getEdad());
            usuario.setNroLicencia(createMedicoERequest.getNroLicencia());
            usuario.setRole("MEDICO");

            usuario.setEmail(createMedicoERequest.getEmail());
            usuario.setPassword(passwordEncoder.encode(createMedicoERequest.getPassword()));

            usuario.setEspecialidades(especialidads);


            usuarioRepo.save(usuario);

            return ResponseEntity.ok(usuario);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al crear el medico: " + e.getMessage());
        }
    }

    @PutMapping("/medico/update-medicoe/{id}")
    public ResponseEntity<?> updateRol(@PathVariable("id") Integer id, @RequestBody ReqRes medicoEUpdateRequest) {
        Optional<Usuario> existingMedico = usuarioRepo.findById(id);

        if (!existingMedico.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Usuario medicoEToUpdate = existingMedico.get();
        medicoEToUpdate.setNombre(medicoEUpdateRequest.getNombre());
        medicoEToUpdate.setDireccion(medicoEUpdateRequest.getDireccion());
        medicoEToUpdate.setTelefono(medicoEUpdateRequest.getTelefono());
        medicoEToUpdate.setEdad(medicoEUpdateRequest.getEdad());
        medicoEToUpdate.setNroLicencia(medicoEUpdateRequest.getNroLicencia());

        List<Especialidad> especialidads = especialidadRepository.findAllById(medicoEUpdateRequest.getEspecialidades());
        if (especialidads.size() != medicoEUpdateRequest.getEspecialidades().size()) {
            return ResponseEntity.badRequest().body("Algunos permisos no encontrados");
        }

        medicoEToUpdate.setEspecialidades(especialidads);

        usuarioRepo.save(medicoEToUpdate);

        return ResponseEntity.ok(medicoEToUpdate);
    }


    @GetMapping("get-all-med")
    public ResponseEntity<ReqRes> getAllUsers(){
        return ResponseEntity.ok(usersManagementService.getAllUsers());

    }

    @GetMapping("/medico/get-all-medico")
    public ResponseEntity<List<Usuario>> getAllMedico() {
        List<Usuario> User = usersManagementService.getAllMedico();
        return ResponseEntity.ok(User);
    }

    @GetMapping("/medico/{medicoId}") // getUser(id)
    public ResponseEntity<ReqRes> getUSerByID(@PathVariable Integer pacienteId){
        return ResponseEntity.ok(usersManagementService.getUsersById(pacienteId));

    }

    @PutMapping("/medico/{medicoId}")   //update
    public ResponseEntity<ReqRes> updateUser(@PathVariable Integer pacienteId, @RequestBody Usuario reqres){
        return ResponseEntity.ok(usersManagementService.updateUser(pacienteId, reqres));
    }

    @PostMapping("/medico/{usuarioId}/especialidades/{especialidadId}")
    public ResponseEntity<String> asignarEspecialidad(
            @PathVariable Integer usuarioId,
            @PathVariable Integer especialidadId) {

        usersManagementService.asignarEspecialidadAMedico(usuarioId, especialidadId);
        return ResponseEntity.ok("Especialidad asignada correctamente");
    }

}
