package com.ufro.voyyvuelvo.service;

import com.ufro.voyyvuelvo.model.Usuario;
import com.ufro.voyyvuelvo.repository.UsuarioRepository;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UsuarioService {

    private Logger logger = LoggerFactory.getLogger(UsuarioService.class);

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario registrarUsuario(Usuario usuario) {
        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new IllegalArgumentException("Usuario ya existe");
        }
        logger.info("Nuevo usuario registrado con exito");
        return usuarioRepository.save(usuario);
    }

    public Usuario autenticarUsuario(String email, String contrasena) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        if (usuario != null && Objects.equals(usuario.getContrasena(), contrasena)) {
             return usuario;
        }
        return null;
    }

    public Usuario findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }
}
