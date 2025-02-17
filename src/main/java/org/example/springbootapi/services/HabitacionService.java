package org.example.springbootapi.services;

import jakarta.transaction.Transactional;
import org.example.springbootapi.models.Habitacion;
import org.example.springbootapi.models.Hotel;
import org.example.springbootapi.repositories.HabitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// HabitacionService.java
@Service
public class HabitacionService {
    @Autowired
    private HabitacionRepository habitacionRepository;

    @Autowired
    private HotelService hotelService;

    public List<Habitacion> findAllHabitaciones() {
        return habitacionRepository.findAll();
    }

    public Habitacion findHabitacionById(Long id) {
        return habitacionRepository.findById(id).orElse(null);
    }

    @Transactional
    public Habitacion saveHabitacion(Habitacion habitacion, Long hotelId) {
        Hotel hotel = hotelService.findHotelById(hotelId);
        if(hotel != null) {
            habitacion.setHotel(hotel);
            return habitacionRepository.save(habitacion);
        }
        return null;
    }

    @Transactional
    public void deleteHabitacion(Long id) {
        habitacionRepository.deleteById(id);
    }



    // Buscar habitaciones por tipo
    public List<Habitacion> findRoomsByType(String tipo) {
        return habitacionRepository.findByTipoContainingIgnoreCase(tipo);
    }

    // Buscar habitaciones por precio
    public List<Habitacion> findRoomsByMaxPrice(double precio) {
        return habitacionRepository.findByPrecioLessThanEqual(precio);
    }
}
