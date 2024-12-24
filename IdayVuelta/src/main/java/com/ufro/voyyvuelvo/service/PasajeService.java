package com.ufro.voyyvuelvo.service;

import com.ufro.voyyvuelvo.model.Asiento;
import com.ufro.voyyvuelvo.model.Pasaje;
import com.ufro.voyyvuelvo.model.Usuario;
import com.ufro.voyyvuelvo.repository.PasajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PasajeService {

    @Autowired
    private PasajeRepository pasajeRepository;

    public Pasaje guardarPasaje(Pasaje pasaje) {
        return pasajeRepository.save(pasaje);
    }

    public List<Pasaje> obtenerPasajesPorUsuario(Usuario usuario) {
        return pasajeRepository.findByUsuario(usuario);
    }


}
