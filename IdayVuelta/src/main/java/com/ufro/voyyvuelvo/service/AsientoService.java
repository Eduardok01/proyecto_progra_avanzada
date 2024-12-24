package com.ufro.voyyvuelvo.service;

import com.ufro.voyyvuelvo.model.Asiento;
import com.ufro.voyyvuelvo.model.Viaje;
import com.ufro.voyyvuelvo.repository.AsientoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class AsientoService {

    private Logger logger = LoggerFactory.getLogger(AsientoService.class);

    @Autowired
    private AsientoRepository asientoRepository;

    public Asiento findById(Long id) {
        return asientoRepository.findById(id).orElse(null);
    }

    public List<Asiento> agruparPorViaje(Viaje viaje) {
        return asientoRepository.findAll().stream()
                .filter(asiento -> Objects.equals(asiento.getViaje().getId(), viaje.getId()))
                .collect(Collectors.toList());
    }

    public void marcarAsientoOcupado(Long idAsiento) {
        Asiento asiento = asientoRepository.findById(idAsiento).orElse(null);
        if (asiento != null) {
            asiento.setDisponible(false);
            asientoRepository.save(asiento);
            logger.info("Asiento reservado en viaje: {}", asiento.getViaje().getId());
        }
    }
}
