package org.example.springbootapi.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties("actividades")
@Data
@Entity
public class ActividadTuristica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;
    private LocalDate fecha;

    @ManyToMany(mappedBy = "actividades")
    @JsonBackReference
    private List<Usuario> usuarios = new ArrayList<>();
}
