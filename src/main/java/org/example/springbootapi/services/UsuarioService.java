package org.example.springbootapi.services;

import jakarta.transaction.Transactional;
import org.example.springbootapi.models.ActividadTuristica;
import org.example.springbootapi.models.Usuario;
import org.example.springbootapi.repositories.ActividadRepository;
import org.example.springbootapi.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ActividadRepository actividadRepository;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }
    public Usuario findById(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Transactional
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Transactional
    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }

    // Método para añadir actividad a usuario
    @Transactional
    public Usuario addActividadToUsuario(Long usuarioId, Long actividadId) {
        Usuario usuario = usuarioRepository.findById(usuarioId).orElse(null);
        ActividadTuristica actividad = actividadRepository.findById(actividadId).orElse(null);

        if (usuario != null && actividad != null) {
            usuario.getActividades().add(actividad);
            actividad.getUsuarios().add(usuario);
            usuarioRepository.save(usuario);
            actividadRepository.save(actividad);
        }
        return usuario;
    }

}
