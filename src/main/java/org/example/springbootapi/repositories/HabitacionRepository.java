package org.example.springbootapi.repositories;

import org.example.springbootapi.models.Habitacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HabitacionRepository extends JpaRepository<Habitacion, Long> {
    List<Habitacion> findByTipoContainingIgnoreCase(String tipo); // Buscar por tipo de habitación
    List<Habitacion> findByPrecioLessThanEqual(double precio); // Buscar por precio menor o igual a X
}
