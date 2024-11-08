package com.historiaclinica.historiaclinica.service;

import com.historiaclinica.historiaclinica.dto.EspecialidadRequest;
import com.historiaclinica.historiaclinica.entity.Especialidad;
import com.historiaclinica.historiaclinica.entity.Usuario;
import com.historiaclinica.historiaclinica.repository.EspecialidadRepository;
import com.historiaclinica.historiaclinica.repository.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecialidadService {

    @Autowired
    private EspecialidadRepository especialidadRepository;

    //@Autowired
    //private UsuarioRepo medicoRepository;

    public List<Especialidad> getAllEspecialidades() {
        return especialidadRepository.findAll();
    }

    public Especialidad createEspecialidad(EspecialidadRequest especialidadRequest) {

        //Usuario medico = medicoRepository.findById(especialidadRequest.getMedico_id())
        //        .orElseThrow(() -> new RuntimeException("Medico not found with id " + especialidadRequest.getMedico_id()));

        Especialidad especialidad = new Especialidad();
        especialidad.setNombre(especialidadRequest.getNombre());
        especialidad.setDescripcion(especialidadRequest.getDescripcion());
        especialidad.setCondicionestratadas(especialidadRequest.getCondicionestratadas());
        //especialidad.setUsuarios(medico);

        return especialidadRepository.save(especialidad);
    }

    public Especialidad updateEspecialidad(Integer id, EspecialidadRequest especialidadRequest) {

        Especialidad especialidad = especialidadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Especialidad not found with id " + id));

        //Usuario medico = medicoRepository.findById(especialidadRequest.getMedico_id())
        //        .orElseThrow(() -> new RuntimeException("Especialidad not found with id " + especialidadRequest.getMedico_id()));

        especialidad.setNombre(especialidadRequest.getNombre());
        especialidad.setDescripcion(especialidadRequest.getDescripcion());
        especialidad.setCondicionestratadas(especialidadRequest.getCondicionestratadas());
        //especialidad.setMedico(medico);

        return especialidadRepository.save(especialidad);
    }

    public void deleteEspecialidad(Integer id) {
        Especialidad especialidad = especialidadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Especialidad not found with id " + id));
        especialidadRepository.delete(especialidad);
    }

    public Especialidad getEspecialidadById(Integer id) {
        return especialidadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Especialidad not found with id " + id));
    }

}
