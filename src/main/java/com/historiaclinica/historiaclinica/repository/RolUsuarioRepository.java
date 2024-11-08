package com.historiaclinica.historiaclinica.repository;

import com.historiaclinica.historiaclinica.entity.RolUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolUsuarioRepository extends JpaRepository<RolUsuario, Integer> {
}
