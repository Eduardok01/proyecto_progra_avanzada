package com.ufro.voyyvuelvo.repository;

import com.ufro.voyyvuelvo.model.Asiento;
import com.ufro.voyyvuelvo.model.Viaje;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AsientoRepository extends JpaRepository<Asiento, Long> {
}
