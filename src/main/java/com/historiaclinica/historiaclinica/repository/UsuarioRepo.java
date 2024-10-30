package com.historiaclinica.historiaclinica.repository;

import com.historiaclinica.historiaclinica.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepo extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByEmail(String email);
}
