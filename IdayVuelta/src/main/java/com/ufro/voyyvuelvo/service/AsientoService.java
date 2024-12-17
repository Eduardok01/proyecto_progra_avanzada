package com.ufro.voyyvuelvo.service;

import com.ufro.voyyvuelvo.model.Asiento;
import com.ufro.voyyvuelvo.model.Viaje;
import com.ufro.voyyvuelvo.repository.AsientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class AsientoService {

    @Autowired
    private AsientoRepository asientoRepository;

    public Asiento findById(Long id) {
        return asientoRepository.findById(id).orElse(null);
    }

    public List<Asiento> agruparPorViaje(Viaje viaje) {
        List<Asiento> asientosViaje = new ArrayList<>();
        List<Asiento> asientosRegistrados = asientoRepository.findAll();

        for (Asiento asiento : asientosRegistrados) {
            if (Objects.equals(asiento.getViaje().getId(), viaje.getId())) {
                asientosViaje.add(asiento);
            }
        }
        return asientosViaje;
    }
}
