package com.ufro.voyyvuelvo.repository;

import com.ufro.voyyvuelvo.model.Pasaje;
import com.ufro.voyyvuelvo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PasajeRepository extends JpaRepository<Pasaje, Long> {
    List<Pasaje> findByUsuario(Usuario usuario);
}
