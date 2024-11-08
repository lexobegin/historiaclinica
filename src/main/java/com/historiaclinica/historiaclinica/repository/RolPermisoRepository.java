package com.historiaclinica.historiaclinica.repository;

import com.historiaclinica.historiaclinica.entity.RolesPermisos;
import com.historiaclinica.historiaclinica.entity.RolesPermisosId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolPermisoRepository extends JpaRepository<RolesPermisos, RolesPermisosId> {
}
