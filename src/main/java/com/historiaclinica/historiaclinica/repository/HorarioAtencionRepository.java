package com.historiaclinica.historiaclinica.repository;

import com.historiaclinica.historiaclinica.entity.HorarioAtencion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioAtencionRepository extends JpaRepository<HorarioAtencion, Integer> {
}
