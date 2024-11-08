package com.historiaclinica.historiaclinica.repository;

import com.historiaclinica.historiaclinica.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepo extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByEmail(String email);

    List<Usuario> findByRole(String role);

    @Query("SELECT u FROM Usuario u WHERE u.role = :role ORDER BY u.id DESC")
    List<Usuario> findByRoleOrderedByIdDesc(@Param("role") String role);

    @Query("SELECT u FROM Usuario u ORDER BY u.id DESC") // Orden descendente
    List<Usuario> findAllOrderedByIdDesc();
}
