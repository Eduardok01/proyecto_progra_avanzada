package com.ufro.voyyvuelvo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Viaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String origen;
    private String destino;
    private Integer precio;
    private Integer num_asientos;
    private LocalDateTime salida;
}