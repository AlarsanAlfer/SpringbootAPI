package org.example.springbootapi.repositories;

import org.example.springbootapi.models.ActividadTuristica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ActividadRepository extends JpaRepository < ActividadTuristica, Long > {
    List<ActividadTuristica> findByFechaAfter(LocalDate fecha);
}
