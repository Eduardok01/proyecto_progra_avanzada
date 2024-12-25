package com.ufro.voyyvuelvo.controller;

import com.ufro.voyyvuelvo.model.Pasaje;
import com.ufro.voyyvuelvo.model.Usuario;
import com.ufro.voyyvuelvo.service.PasajeService;
import com.ufro.voyyvuelvo.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PasajeService pasajeService;

    @PostMapping("/registrar")
    public String guardarUsuario(Usuario usuario, Model model) {
        try {
            usuarioService.registrarUsuario(usuario);
            return "redirect:/";
        } catch (Exception e) {
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
            return "redirect:/";
        } else {
            model.addAttribute("error", "Correo o contraseña incorrectos");
            return "inicio-sesion";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/detalle")
    public String detalleUsuario(HttpSession session, Model model) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogeado");

        if (session.getAttribute("usuarioLogeado")== null) {
            return "redirect:/";
        }

        List<Pasaje> pasajes = pasajeService.obtenerPasajesPorUsuario(usuario);

        model.addAttribute("usuario", usuario);
        model.addAttribute("pasajes", pasajes);

        return "usuario-detalle";
    }

}
