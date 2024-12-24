package com.ufro.voyyvuelvo.service;

import com.ufro.voyyvuelvo.model.Asiento;
import com.ufro.voyyvuelvo.model.Viaje;

import com.ufro.voyyvuelvo.repository.ViajeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        return getAsientosDisponibles(viaje).size();
    }

    public List<Asiento> getAsientosDisponibles(Viaje viaje) {
        return asientoService.agruparPorViaje(viaje)
                .stream()
                .filter(Asiento::getDisponible)
                .collect(Collectors.toList());
    }

}
