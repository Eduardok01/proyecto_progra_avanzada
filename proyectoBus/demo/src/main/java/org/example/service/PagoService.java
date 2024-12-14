package org.example.service;

import org.example.model.Pago;
import org.example.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagoService {

    @Autowired
    private PagoRepository pagoRepository;

    public List<Pago> obtenerTodosLosPagos() {
        return pagoRepository.findAll();
    }

    public Pago guardarPago(Pago pago) {
        return pagoRepository.save(pago);
    }

    public Pago obtenerPagoPorId(Long id) {
        return pagoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pago no encontrado"));
    }

    public void eliminarPago(Long id) {
        pagoRepository.deleteById(id);
    }
}

