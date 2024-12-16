package com.ufro.voyyvuelvo.controller;

import com.ufro.voyyvuelvo.model.Usuario;
import com.ufro.voyyvuelvo.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/registrar")
    public String guardarUsuario(Usuario usuario, Model model) {
        try {
            usuarioService.registrarUsuario(usuario);
            return "redirect:/";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", "Usuario ya se encuentra registrado");
            return "registro-usuario";
        }
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String email,
                        @RequestParam("password") String contrasena,
                        HttpSession session,
                        Model model) {

        Usuario usuario = usuarioService.autenticarUsuario(email, contrasena);

        if (usuario!= null) {
            session.setAttribute("usuarioLogeado", usuario);
            return "redirect:/viajes";
        } else {
            model.addAttribute("error", "Correo o contraseña incorrectos");
            return "inicio-sesion";
        }
    }

}
