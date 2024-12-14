package org.example.controller;

import org.example.model.Pago;
import org.example.repository.PagoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagos")
public class PagoController {

    private final PagoRepository pagoRepository;

    // Constructor para inyectar el repositorio
    public PagoController(PagoRepository pagoRepository) {
        this.pagoRepository = pagoRepository;
    }

    // Endpoint POST para crear un pago
    @PostMapping
    public Pago crearPago(@RequestBody Pago pago) {
        return pagoRepository.save(pago);
    }

    // Endpoint GET para obtener la lista de pagos
    @GetMapping
    public List<Pago> listarPagos() {
        return pagoRepository.findAll();
    }
}


