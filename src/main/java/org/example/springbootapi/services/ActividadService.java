package org.example.springbootapi.services;

import jakarta.transaction.Transactional;
import org.example.springbootapi.models.ActividadTuristica;
import org.example.springbootapi.repositories.ActividadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ActividadService {
    @Autowired
    private ActividadRepository actividadRepository;

    public List<ActividadTuristica> findAllActividades() {
        return actividadRepository.findAll();
    }

    public ActividadTuristica findActividadById(Long id) {
        return actividadRepository.findById(id).orElse(null);
    }

    @Transactional
    public ActividadTuristica saveActividad(ActividadTuristica actividad) {
        return actividadRepository.save(actividad);
    }

    @Transactional
    public void deleteActividad(Long id) {
        actividadRepository.deleteById(id);
    }

    public List<ActividadTuristica> findActivitiesByDate(LocalDate date) {
        return actividadRepository.findByFechaAfter(date);
    }


}
