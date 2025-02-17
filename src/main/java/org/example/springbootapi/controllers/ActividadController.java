package org.example.springbootapi.controllers;

import org.example.springbootapi.models.ActividadTuristica;
import org.example.springbootapi.services.ActividadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

// ActividadTuristicaController.java
@RestController
@RequestMapping("/api/actividades")
public class ActividadController {

    @Autowired
    private ActividadService actividadService;

    @GetMapping
    public ResponseEntity<List<ActividadTuristica>> getAllActividades() {
        return ResponseEntity.ok(actividadService.findAllActividades());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActividadTuristica> getActividadById(@PathVariable Long id) {
        ActividadTuristica actividad = actividadService.findActividadById(id);
        return actividad != null ? ResponseEntity.ok(actividad) : ResponseEntity.notFound().build();
    }

    @GetMapping("/fecha/{date}")
    public ResponseEntity<List<ActividadTuristica>> getActivitiesByDate(@PathVariable String date) {
        LocalDate fecha = LocalDate.parse(date);
        return ResponseEntity.ok(actividadService.findActivitiesByDate(fecha));
    }





    /*************************************************************************/

    @PostMapping
    public ResponseEntity<ActividadTuristica> createActividad(@RequestBody ActividadTuristica actividad) {
        return ResponseEntity.status(HttpStatus.CREATED).body(actividadService.saveActividad(actividad));
    }

    @PutMapping("/u{id}")
    public ResponseEntity<ActividadTuristica> updateActividad(
            @PathVariable Long id,
            @RequestBody ActividadTuristica actividad
    ) {
        actividad.setId(id);
        return ResponseEntity.ok(actividadService.saveActividad(actividad));
    }

    @DeleteMapping("/d{id}")
    public ResponseEntity<Void> deleteActividad(@PathVariable Long id) {
        actividadService.deleteActividad(id);
        return ResponseEntity.noContent().build();
    }
}
