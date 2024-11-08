package com.historiaclinica.historiaclinica.service;

import com.historiaclinica.historiaclinica.dto.RolRequest;
import com.historiaclinica.historiaclinica.entity.Rol;
import com.historiaclinica.historiaclinica.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolService {

    @Autowired
    private RolRepository rolesRepository;

    public List<Rol> getAllRoles() {
        return rolesRepository.findAll();
    }

    public Rol createRole(RolRequest roleRequest) {
        Rol role = new Rol();
        role.setNombre(roleRequest.getNombre());
        return rolesRepository.save(role);
    }

    public Rol updateRole(Integer id, RolRequest roleRequest) {
        Rol role = rolesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found with id " + id));
        role.setNombre(roleRequest.getNombre());
        return rolesRepository.save(role);
    }

    public void deleteRole(Integer id) {
        Rol role = rolesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found with id " + id));
        rolesRepository.delete(role);
    }

    public Rol getRoleById(Integer id) {
        return rolesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found with id " + id));
    }

}
