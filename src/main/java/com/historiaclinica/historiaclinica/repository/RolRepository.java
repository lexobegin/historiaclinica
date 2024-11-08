package com.historiaclinica.historiaclinica.repository;

import com.historiaclinica.historiaclinica.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {

}
