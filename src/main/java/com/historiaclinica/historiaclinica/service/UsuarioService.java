package com.historiaclinica.historiaclinica.service;

import com.historiaclinica.historiaclinica.dto.ReqRes;
import com.historiaclinica.historiaclinica.entity.Especialidad;
import com.historiaclinica.historiaclinica.entity.Usuario;
import com.historiaclinica.historiaclinica.repository.EspecialidadRepository;
import com.historiaclinica.historiaclinica.repository.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepo usuarioRepo;

    @Autowired
    private EspecialidadRepository especialidadRepository;

    @Autowired
    private JWTUtils jwtUtils;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder passwordEncoder;


    public ReqRes register(ReqRes registrationRequest){
        ReqRes resp = new ReqRes();

        try {
            Usuario ourUser = new Usuario();
            ourUser.setEmail(registrationRequest.getEmail());

            ourUser.setRole(registrationRequest.getRole());
            ourUser.setNombre(registrationRequest.getNombre());
            ourUser.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
            Usuario ourUsersResult = usuarioRepo.save(ourUser);
            if (ourUsersResult.getId()>0) {
                resp.setUsuarios(ourUsersResult);
                resp.setMessage("User Saved Successfully");
                resp.setStatusCode(200);
            }

        }catch (Exception e){
            resp.setStatusCode(500);
            resp.setError(e.getMessage());
        }
        return resp;
    }


    public ReqRes login(ReqRes loginRequest){
        ReqRes response = new ReqRes();
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
                    loginRequest.getPassword()));
            var user = usuarioRepo.findByEmail(loginRequest.getEmail()).orElseThrow();
            var jwt = jwtUtils.generateToken(user);
            var refreshToken = jwtUtils.generateRefreshToken(new HashMap<>(), user);
            response.setStatusCode(200);
            response.setToken(jwt);
            response.setRole(user.getRole());
            response.setRefreshToken(refreshToken);
            response.setExpirationTime("24Hrs");
            response.setMessage("Successfully Logged In");

        }catch (Exception e){
            response.setStatusCode(500);
            response.setMessage(e.getMessage());
        }
        return response;
    }





    public ReqRes refreshToken(ReqRes refreshTokenReqiest){
        ReqRes response = new ReqRes();
        try{
            String ourEmail = jwtUtils.extractUsername(refreshTokenReqiest.getToken());
            Usuario users = usuarioRepo.findByEmail(ourEmail).orElseThrow();
            if (jwtUtils.isTokenValid(refreshTokenReqiest.getToken(), users)) {
                var jwt = jwtUtils.generateToken(users);
                response.setStatusCode(200);
                response.setToken(jwt);
                response.setRefreshToken(refreshTokenReqiest.getToken());
                response.setExpirationTime("24Hr");
                response.setMessage("Successfully Refreshed Token");
            }
            response.setStatusCode(200);
            return response;

        }catch (Exception e){
            response.setStatusCode(500);
            response.setMessage(e.getMessage());
            return response;
        }
    }


    public ReqRes getAllUsers() {
        ReqRes reqRes = new ReqRes();

        try {
            List<Usuario> result = usuarioRepo.findAll();
            if (!result.isEmpty()) {
                reqRes.setUsuariosList(result);
                reqRes.setStatusCode(200);
                reqRes.setMessage("Successful");
            } else {
                reqRes.setStatusCode(404);
                reqRes.setMessage("No users found");
            }
            return reqRes;
        } catch (Exception e) {
            reqRes.setStatusCode(500);
            reqRes.setMessage("Error occurred: " + e.getMessage());
            return reqRes;
        }
    }

    public List<Usuario> getAllUsersV2() {
        //return usuarioRepo.findAll();findAllOrderedByIdDesc
        return usuarioRepo.findAllOrderedByIdDesc();
    }

    public List<Usuario> getAllPaciente() {

        //return usuarioRepo.findByRole("PACIENTE");
        return usuarioRepo.findByRoleOrderedByIdDesc("PACIENTE");
//        return usuarioRepo.findAll().stream()
//                .filter(usuario -> "PACIENTE".equals(usuario.getRole())) // Filtra por rol
//                .map(usuario -> {
//                    // Si solo necesitas ciertos atributos, puedes crear un nuevo objeto o simplemente retornar el original
//                    Usuario paciente = new Usuario();
//                    paciente.setNombre(usuario.getNombre());
//                    paciente.setEmail(usuario.getEmail());
//                    paciente.setTelefono(usuario.getTelefono());
//                    paciente.setDireccion(usuario.getDireccion());
//                    paciente.setEdad(usuario.getEdad());
//                    paciente.setPeso(usuario.getPeso());
//                    paciente.setAltura(usuario.getAltura());
//                    paciente.setEstadoPaciente(usuario.getEstadoPaciente());
//
//                    return paciente;
//                })
//                .collect(Collectors.toList());
    }

    public List<Usuario> getAllMedico() {

        //return usuarioRepo.findByRole("MEDICO");
        return usuarioRepo.findByRoleOrderedByIdDesc("MEDICO");
    }

    public ReqRes getUsersById(Integer id) {
        ReqRes reqRes = new ReqRes();
        try {
            Usuario usersById = usuarioRepo.findById(id).orElseThrow(() -> new RuntimeException("User Not found"));
            reqRes.setUsuarios(usersById);
            reqRes.setStatusCode(200);
            reqRes.setMessage("Users with id '" + id + "' found successfully");
        } catch (Exception e) {
            reqRes.setStatusCode(500);
            reqRes.setMessage("Error occurred: " + e.getMessage());
        }
        return reqRes;
    }


    public ReqRes deleteUser(Integer userId) {
        ReqRes reqRes = new ReqRes();
        try {
            Optional<Usuario> userOptional = usuarioRepo.findById(userId);
            if (userOptional.isPresent()) {
                usuarioRepo.deleteById(userId);
                reqRes.setStatusCode(200);
                reqRes.setMessage("User deleted successfully");
            } else {
                reqRes.setStatusCode(404);
                reqRes.setMessage("User not found for deletion");
            }
        } catch (Exception e) {
            reqRes.setStatusCode(500);
            reqRes.setMessage("Error occurred while deleting user: " + e.getMessage());
        }
        return reqRes;
    }

    public ReqRes updateUser(Integer userId, Usuario updatedUser) {
        System.out.println("Entrooo");
        ReqRes reqRes = new ReqRes();
        try {
            Optional<Usuario> userOptional = usuarioRepo.findById(userId);
            if (userOptional.isPresent()) {
                Usuario existingUser = userOptional.get();
                existingUser.setEmail(updatedUser.getEmail());
                existingUser.setNombre(updatedUser.getNombre());
                existingUser.setRole(updatedUser.getRole());

                // Check if password is present in the request
                if (updatedUser.getPassword() != null && !updatedUser.getPassword().isEmpty()) {
                    // Encode the password and update it
                    existingUser.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
                }

                Usuario savedUser = usuarioRepo.save(existingUser);
                reqRes.setUsuarios(savedUser);
                reqRes.setStatusCode(200);
                reqRes.setMessage("User updated successfully");
            } else {
                reqRes.setStatusCode(404);
                reqRes.setMessage("User not found for update");
            }
        } catch (Exception e) {
            reqRes.setStatusCode(500);
            reqRes.setMessage("Error occurred while updating user: " + e.getMessage());
        }
        return reqRes;
    }


    public ReqRes getMyInfo(String email){
        ReqRes reqRes = new ReqRes();
        try {
            Optional<Usuario> userOptional = usuarioRepo.findByEmail(email);
            if (userOptional.isPresent()) {
                reqRes.setUsuarios(userOptional.get());
                reqRes.setStatusCode(200);
                reqRes.setMessage("successful");
            } else {
                reqRes.setStatusCode(404);
                reqRes.setMessage("User not found for update");
            }

        }catch (Exception e){
            reqRes.setStatusCode(500);
            reqRes.setMessage("Error occurred while getting user info: " + e.getMessage());
        }
        return reqRes;

    }

    //Especialidad

    public void asignarEspecialidadAMedico(Integer medicoId, Integer especialidadId) {
        Usuario usuario = usuarioRepo.findById(medicoId)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));

        if (!"MEDICO".equalsIgnoreCase(usuario.getRole())) {
            throw new IllegalStateException("Solo los usuarios con rol de 'medico' pueden tener especialidades");
        }

        Especialidad especialidad = especialidadRepository.findById(especialidadId)
                .orElseThrow(() -> new IllegalArgumentException("Especialidad no encontrada"));

        usuario.getEspecialidades().add(especialidad);
        usuarioRepo.save(usuario);
    }


}
