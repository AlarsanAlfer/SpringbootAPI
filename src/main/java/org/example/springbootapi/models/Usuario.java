package org.example.springbootapi.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private int edad;
    private String email;
    private String direccion;

    @JsonIgnoreProperties("usuarios")
    @ManyToMany
    @JoinTable(
            name = "usuario_actividad",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "actividad_id")
    )
    @JsonBackReference
    private List<ActividadTuristica> actividades = new ArrayList<>();
}
