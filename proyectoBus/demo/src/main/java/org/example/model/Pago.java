package org.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity
public class Pago {

    @Id
    private String idPago;
    private Double monto;
    private String metodoPago;
    private LocalDate fechaPago;

    // Getters y Setters

}
