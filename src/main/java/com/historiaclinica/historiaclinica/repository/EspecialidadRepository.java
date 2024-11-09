package com.historiaclinica.historiaclinica.repository;

import com.historiaclinica.historiaclinica.entity.Especialidad;
import com.historiaclinica.historiaclinica.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EspecialidadRepository extends JpaRepository<Especialidad, Integer> {

}
