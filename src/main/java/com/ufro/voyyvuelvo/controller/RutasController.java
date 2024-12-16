package com.ufro.voyyvuelvo.controller;

import com.ufro.voyyvuelvo.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RutasController {

    @GetMapping("/iniciar")
    public String loginForm() {
        return "inicio-sesion";
    }

    @GetMapping("/nuevo")
    public String formRegistrar(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "registro-usuario";
    }
}
