package com.historiaclinica.historiaclinica.service;

import com.historiaclinica.historiaclinica.dto.RolUsuarioRequest;
import com.historiaclinica.historiaclinica.entity.Rol;
import com.historiaclinica.historiaclinica.entity.RolUsuario;
import com.historiaclinica.historiaclinica.entity.Usuario;
import com.historiaclinica.historiaclinica.repository.RolRepository;
import com.historiaclinica.historiaclinica.repository.RolUsuarioRepository;
import com.historiaclinica.historiaclinica.repository.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolUsuarioService {

    @Autowired
    private RolUsuarioRepository rolUserRepository;

    @Autowired
    private UsuarioRepo ourUsersRepository;

    @Autowired
    private RolRepository rolesRepository;

    public List<RolUsuario> getAllRolUsers() {
        return rolUserRepository.findAll();
    }

    public RolUsuario createRolUser(RolUsuarioRequest request) {
        Usuario user = ourUsersRepository.findById(request.getUsuario_id())
                .orElseThrow(() -> new RuntimeException("User not found with id " + request.getUsuario_id()));
        Rol rol = rolesRepository.findById(request.getRol_id())
                .orElseThrow(() -> new RuntimeException("Role not found with id " + request.getRol_id()));

        RolUsuario rolUser = new RolUsuario();
        rolUser.setUsuario_id(user);
        rolUser.setRol_id(rol);

        return rolUserRepository.save(rolUser);
    }

    public void deleteRolUser(Integer id) {
        RolUsuario rolUser = rolUserRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("RolUser not found with id " + id));
        rolUserRepository.delete(rolUser);
    }

    public RolUsuario getRolUserById(Integer id) {
        return rolUserRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("RolUser not found with id " + id));
    }

}
