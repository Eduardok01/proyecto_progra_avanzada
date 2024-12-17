package com.ufro.voyyvuelvo.service;


import com.ufro.voyyvuelvo.model.Asiento;
import com.ufro.voyyvuelvo.model.Viaje;

import com.ufro.voyyvuelvo.repository.ViajeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ViajeService {

    private Logger logger = LoggerFactory.getLogger(ViajeService.class);

    @Autowired
    private ViajeRepository viajeRepository;

    @Autowired
    private AsientoService asientoService;

    public List<Viaje> findAll() {
        return viajeRepository.findAll();
    }

    public Viaje findById(Long id) {
        return viajeRepository.findById(id).orElse(null);
    }

    public int numAsientosDisponiblesViaje(Viaje viaje) {
        int disponibles = 0;
        List<Asiento> asientos = asientoService.agruparPorViaje(viaje);
        for(Asiento asiento : asientos) {
            if (asiento.getDisponible()){
                disponibles++;
            }
        }
        return disponibles;
    }

    public List<Asiento> getAsientosDisponibles(Viaje viaje) {
        List<Asiento> asientosDisponibles = new ArrayList<>();
        List<Asiento> asientosViaje = asientoService.agruparPorViaje(viaje);
        for(Asiento asiento : asientosViaje) {
            if (asiento.getDisponible()){
                asientosDisponibles.add(asiento);
            }
        }
        return asientosDisponibles;
    }

}
