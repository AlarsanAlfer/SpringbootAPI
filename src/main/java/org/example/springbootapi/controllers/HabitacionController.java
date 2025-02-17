package org.example.springbootapi.controllers;

import org.example.springbootapi.models.Habitacion;
import org.example.springbootapi.services.HabitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// HabitacionController.java
@RestController
@RequestMapping("/api/habitaciones")
public class HabitacionController {

    @Autowired
    private HabitacionService habitacionService;

    @GetMapping
    public ResponseEntity<List<Habitacion>> getAllHabitaciones() {
        return ResponseEntity.ok(habitacionService.findAllHabitaciones());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Habitacion> getHabitacionById(@PathVariable Long id) {
        Habitacion habitacion = habitacionService.findHabitacionById(id);
        return habitacion != null ? ResponseEntity.ok(habitacion) : ResponseEntity.notFound().build();
    }

    @PostMapping("/c{hotelId}")
    public ResponseEntity<Habitacion> createHabitacion(
            @PathVariable Long hotelId,
            @RequestBody Habitacion habitacion
    ) {
        Habitacion nuevaHabitacion = habitacionService.saveHabitacion(habitacion, hotelId);
        return nuevaHabitacion != null
                ? ResponseEntity.status(HttpStatus.CREATED).body(nuevaHabitacion)
                : ResponseEntity.badRequest().build();
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<Habitacion>> getRoomsByType(@PathVariable String tipo) {
        return ResponseEntity.ok(habitacionService.findRoomsByType(tipo));
    }

    @GetMapping("/precio/{precio}")
    public ResponseEntity<List<Habitacion>> getRoomsByMaxPrice(@PathVariable double precio) {
        return ResponseEntity.ok(habitacionService.findRoomsByMaxPrice(precio));
    }





    /***************************************************************************************/

    @PutMapping("/u{id}")
    public ResponseEntity<Habitacion> updateHabitacion(
            @PathVariable Long id,
            @RequestBody Habitacion habitacion
    ) {
        habitacion.setId(id);
        return ResponseEntity.ok(habitacionService.saveHabitacion(habitacion, null));
    }

    @DeleteMapping("/d{id}")
    public ResponseEntity<Void> deleteHabitacion(@PathVariable Long id) {
        habitacionService.deleteHabitacion(id);
        return ResponseEntity.noContent().build();
    }
}
