package com.ufro.voyyvuelvo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Asiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer numero;
    private Boolean disponible;
    @ManyToOne
    @JoinColumn(name = "viaje_id", nullable = false) // FK hacia Viaje
    private Viaje viaje;

    @OneToOne(mappedBy = "asiento", cascade = CascadeType.ALL) // Relación con Pasaje
    private Pasaje pasaje;
}
