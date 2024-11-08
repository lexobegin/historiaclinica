package com.historiaclinica.historiaclinica.service;

import com.historiaclinica.historiaclinica.dto.PermisoRequest;
import com.historiaclinica.historiaclinica.entity.Permiso;
import com.historiaclinica.historiaclinica.repository.PermisoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermisoService {

    @Autowired
    private PermisoRepository permisosRepository;

    public List<Permiso> getAllPermisos() {
        return permisosRepository.findAll();
    }

    public Permiso createPermiso(PermisoRequest permisoRequest) {
        Permiso permiso = new Permiso();
        permiso.setNombre(permisoRequest.getNombre());
        return permisosRepository.save(permiso);
    }

    public Permiso updatePermiso(Integer id, PermisoRequest permisoRequest) {
        Permiso permiso = permisosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Permiso not found with id " + id));
        permiso.setNombre(permisoRequest.getNombre());
        return permisosRepository.save(permiso);
    }

    public void deletePermiso(Integer id) {
        Permiso permiso = permisosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Permiso not found with id " + id));
        permisosRepository.delete(permiso);
    }

    public Permiso getPermisoById(Integer id) {
        return permisosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Permiso not found with id " + id));
    }

}
