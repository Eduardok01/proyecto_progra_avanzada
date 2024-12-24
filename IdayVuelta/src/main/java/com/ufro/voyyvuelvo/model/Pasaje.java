package com.ufro.voyyvuelvo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@RequiredArgsConstructor // Constructor con parámetros de los campos final o @NonNull
public class Pasaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "asiento_id", nullable = false, unique = true) // FK única hacia Asiento
    @NonNull
    private Asiento asiento;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false) // FK hacia Usuario
    @NonNull
    private Usuario usuario;

    @NonNull
    private LocalDateTime fechaCompra;


    public Pasaje() {

    }
}
