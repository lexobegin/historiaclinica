package com.historiaclinica.historiaclinica.service;

import com.historiaclinica.historiaclinica.dto.RolPermisoRequest;
import com.historiaclinica.historiaclinica.entity.RolesPermisos;
import com.historiaclinica.historiaclinica.entity.RolesPermisosId;
import com.historiaclinica.historiaclinica.repository.RolPermisoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolPermisoService {

    @Autowired
    private RolPermisoRepository rolesPermisosRepository;

    public List<RolesPermisos> getAllRolesPermisos() {
        return rolesPermisosRepository.findAll();
    }

    public RolesPermisos createRolesPermisos(RolPermisoRequest request) {
        RolesPermisos rolesPermisos = new RolesPermisos();
        rolesPermisos.setRol_id(request.getRol_id());
        rolesPermisos.setPermiso_id(request.getPermiso_id());
        return rolesPermisosRepository.save(rolesPermisos);
    }

    public RolesPermisos updateRolesPermisos(RolPermisoRequest request) {
        RolesPermisosId id = new RolesPermisosId();
        id.setRol_id(request.getRol_id());
        id.setPermiso_id(request.getPermiso_id());

        RolesPermisos rolesPermisos = rolesPermisosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("RolesPermisos not found with rolId " + request.getRol_id() + " and permisoId " + request.getPermiso_id()));

        rolesPermisos.setRol_id(request.getRol_id());
        rolesPermisos.setPermiso_id(request.getPermiso_id());

        return rolesPermisosRepository.save(rolesPermisos);
    }

    public void deleteRolesPermisos(Integer rolId, Integer permisoId) {
        RolesPermisosId id = new RolesPermisosId();
        id.setRol_id(rolId);
        id.setPermiso_id(permisoId);
        rolesPermisosRepository.deleteById(id);
    }

    public RolesPermisos getRolesPermisosById(Integer rolId, Integer permisoId) {
        RolesPermisosId id = new RolesPermisosId();
        id.setRol_id(rolId);
        id.setPermiso_id(permisoId);
        return rolesPermisosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("RolesPermisos not found with rolId " + rolId + " and permisoId " + permisoId));
    }

}
