package com.ufro.voyyvuelvo.controller;

import com.ufro.voyyvuelvo.service.ViajeService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViajesController {

    @Autowired
    private ViajeService viajeService;

    @GetMapping("/viajes")
    public String mostrarViajes(HttpSession session, Model model){
        if(session.getAttribute("usuarioLogeado") != null){
            model.addAttribute("viajes", viajeService.findAll());
            model.addAttribute("viajeService", viajeService);
            return "listado-viajes";
        } else {
            return "redirect:/";
        }
    }
}
