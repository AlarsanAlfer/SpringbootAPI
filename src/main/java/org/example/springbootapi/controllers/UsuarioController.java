package org.example.springbootapi.controllers;

import org.example.springbootapi.models.Usuario;
import org.example.springbootapi.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        return ResponseEntity.ok(usuarioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id) {
        Usuario usuario = usuarioService.findById(id);
        return usuario != null ? ResponseEntity.ok(usuario) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario));
    }

    @PutMapping("/u{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        usuario.setId(id);
        return ResponseEntity.ok(usuarioService.save(usuario));
    }

    @DeleteMapping("/d{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        usuarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Endpoint para asociar actividad a usuario
    @PostMapping("/{usuarioId}/actividades/{actividadId}")
    public ResponseEntity<Usuario> addActividadToUsuario(
            @PathVariable Long usuarioId,
            @PathVariable Long actividadId
    ) {
        Usuario usuario = usuarioService.addActividadToUsuario(usuarioId, actividadId);
        return usuario != null ? ResponseEntity.ok(usuario) : ResponseEntity.notFound().build();
    }
}
