package com.ufro.voyyvuelvo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true, nullable = false)
    private String rut;

    @Column(nullable = false)
    private String contrasena;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL) // Relación con Pasaje
    private List<Pasaje> pasajes;

}
