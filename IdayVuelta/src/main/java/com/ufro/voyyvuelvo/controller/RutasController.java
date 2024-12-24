package com.ufro.voyyvuelvo.controller;

import com.ufro.voyyvuelvo.model.Asiento;
import com.ufro.voyyvuelvo.model.Pasaje;
import com.ufro.voyyvuelvo.model.Usuario;
import com.ufro.voyyvuelvo.service.AsientoService;
import com.ufro.voyyvuelvo.service.EmailSenderService;
import com.ufro.voyyvuelvo.service.PasajeService;
import com.ufro.voyyvuelvo.service.ViajeService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Controller
public class RutasController {

    @Autowired
    private EmailSenderService emailSenderService;

    @Autowired
    private ViajeService viajeService;

    @Autowired
    private AsientoService asientoService;

    @Autowired
    private PasajeService pasajeService;

    @GetMapping("/iniciar")
    public String loginForm() {
        return "inicio-sesion";
    }

    @GetMapping("/nuevo")
    public String formRegistrar(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "registro-usuario";
    }

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

    @PostMapping("/pagar")
    public String mostrarFormularioPago(
            @RequestParam Integer monto,
            @RequestParam Long asientoId,
            Model model) {
        List<String> mediosPago = Arrays.asList("Credito", "Debito");
        model.addAttribute("monto", monto);
        model.addAttribute("mediosPago", mediosPago);
        model.addAttribute("asientoId", asientoId);
        return "portal-pagos";
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
            session.setAttribute("idPasajeComprar", asientoId);
            return "resumen-compra";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/procesarPago")
    public String procesarPago(HttpSession session, Model model) {

        model.addAttribute("usuario", session.getAttribute("usuarioLogeado"));

        Long asientoId = (Long) session.getAttribute("idPasajeComprar");

        Usuario usuario = (Usuario) session.getAttribute("usuarioLogeado");
        Asiento asiento = asientoService.findById(asientoId);

        Pasaje pasaje = new Pasaje(asiento, usuario, LocalDateTime.now());

        asientoService.marcarAsientoOcupado(asientoId);
        pasajeService.guardarPasaje(pasaje);
        emailSenderService.sendEmail(pasaje);

        return "pago-confirmado";
    }
}
