package com.ufro.voyyvuelvo.controller;

import com.ufro.voyyvuelvo.service.AsientoService;
import com.ufro.voyyvuelvo.service.ViajeService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViajesController {

    @Autowired
    private ViajeService viajeService;

    @Autowired
    private AsientoService asientoService;

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

    @PostMapping("/comprar")
    public String comprarPasaje(@RequestParam("viajeId") Long viajeId,
                                @RequestParam("asientoId") Long asientoId,
                                HttpSession session,
                                Model model) {
        if(session.getAttribute("usuarioLogeado") != null){
            model.addAttribute("viajeId", viajeId);
            model.addAttribute("asientoId", asientoId);
            model.addAttribute("viajeService", viajeService);
            model.addAttribute("asientoService", asientoService);
            model.addAttribute("usuario", session.getAttribute("usuarioLogeado"));
            return "comprar-pasaje";
        } else {
            return "redirect:/";
        }
    }
}
