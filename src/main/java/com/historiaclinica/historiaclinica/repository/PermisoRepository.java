package com.historiaclinica.historiaclinica.repository;

import com.historiaclinica.historiaclinica.entity.Permiso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermisoRepository extends JpaRepository<Permiso, Integer> {

}
