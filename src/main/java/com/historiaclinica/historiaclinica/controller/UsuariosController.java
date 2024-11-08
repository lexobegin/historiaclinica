package com.historiaclinica.historiaclinica.controller;


import com.historiaclinica.historiaclinica.dto.ReqRes;
import com.historiaclinica.historiaclinica.dto.UserProfileMovil;
import com.historiaclinica.historiaclinica.entity.Usuario;
import com.historiaclinica.historiaclinica.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuariosController {

    @Autowired
    private UsuarioService usersManagementService;

    @GetMapping("/admin/get-all-users")
    public ResponseEntity<ReqRes> getAllUsers(){
        return ResponseEntity.ok(usersManagementService.getAllUsers());

    }

    @GetMapping("/admin/get-all-usersV2")
    public ResponseEntity<List<Usuario>> getAllUsersV2() {
        List<Usuario> User = usersManagementService.getAllUsersV2();
        return ResponseEntity.ok(User);
    }

    @GetMapping("/admin/user/{userId}") // getUser(id)
    public ResponseEntity<ReqRes> getUSerByID(@PathVariable Integer userId){
        return ResponseEntity.ok(usersManagementService.getUsersById(userId));

    }

    @PutMapping("/admin/user/{userId}")   //update
    public ResponseEntity<ReqRes> updateUser(@PathVariable Integer userId, @RequestBody Usuario reqres){
        return ResponseEntity.ok(usersManagementService.updateUser(userId, reqres));
    }

    @GetMapping("/adminuser/get-profile")
    public ResponseEntity<ReqRes> getMyProfile(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();

        ReqRes response = usersManagementService.getMyInfo(email);
        return  ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @GetMapping("/adminuser/get-userToken")
    public ResponseEntity<UserProfileMovil> getUserToken() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();

        ReqRes response = usersManagementService.getMyInfo(email);
        Usuario user = response.getUsuarios();

        UserProfileMovil userProfileDto = new UserProfileMovil();
        userProfileDto.setId(user.getId());
        userProfileDto.setEmail(user.getEmail());
        userProfileDto.setNombre(user.getNombre());
        userProfileDto.setPassword(user.getPassword());
        userProfileDto.setRole(user.getRole());

        return ResponseEntity.ok(userProfileDto);
    }

    @DeleteMapping("/admin/user/{userId}")
    public ResponseEntity<ReqRes> deleteUSer(@PathVariable Integer userId){
        return ResponseEntity.ok(usersManagementService.deleteUser(userId));
    }


}
