package com.historiaclinica.historiaclinica.service;

import com.historiaclinica.historiaclinica.dto.HorarioAtencionRequest;
import com.historiaclinica.historiaclinica.dto.RolRequest;
import com.historiaclinica.historiaclinica.entity.HorarioAtencion;
import com.historiaclinica.historiaclinica.entity.Rol;
import com.historiaclinica.historiaclinica.repository.HorarioAtencionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorarioAtencionService {

    @Autowired
    private HorarioAtencionRepository horarioAtencionRepository;

    public List<HorarioAtencion> getAllHorarioAtencion() {
        return horarioAtencionRepository.findAll();
    }

    public HorarioAtencion createHorarioAtencion(HorarioAtencionRequest horarioAtencionRequest) {
        HorarioAtencion horarioAtencion = new HorarioAtencion();

        horarioAtencion.setHoraInicio(horarioAtencionRequest.getHoraInicio());
        horarioAtencion.setHoraFin(horarioAtencionRequest.getHoraFin());
        horarioAtencion.setHora(horarioAtencionRequest.getHora());

        return horarioAtencionRepository.save(horarioAtencion);
    }

    public HorarioAtencion updateHorarioAtencion(Integer id, HorarioAtencionRequest horarioAtencionRequest) {
        HorarioAtencion horarioAtencion = horarioAtencionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found with id " + id));

        horarioAtencion.setHoraInicio(horarioAtencionRequest.getHoraInicio());
        horarioAtencion.setHoraFin(horarioAtencionRequest.getHoraFin());
        horarioAtencion.setHora(horarioAtencionRequest.getHora());

        return horarioAtencionRepository.save(horarioAtencion);
    }

    public void deleteHorarioAtencion(Integer id) {
        HorarioAtencion horarioAtencion = horarioAtencionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found with id " + id));
        horarioAtencionRepository.delete(horarioAtencion);
    }

    public HorarioAtencion getHorarioAtencionId(Integer id) {
        return horarioAtencionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found with id " + id));
    }
}
