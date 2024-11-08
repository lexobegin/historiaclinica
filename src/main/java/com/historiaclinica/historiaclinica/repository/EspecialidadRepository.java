package com.historiaclinica.historiaclinica.repository;

import com.historiaclinica.historiaclinica.entity.Especialidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecialidadRepository extends JpaRepository<Especialidad, Integer> {
}
