package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;

class PagoTest {

    private Pago pago;

    @BeforeEach
    void setUp() {
        // Usando el enum MetodoPago para el metodo de pago
        pago = new Pago(1, 10000d, MetodoPago.TARJETA_CREDITO, LocalDateTime.of(2024, 11, 8, 14, 30));
    }

    @Test
    void testGetMonto() {
        assertEquals(10000d, pago.getMonto());
    }

    @Test
    void testGetMetodoPago() {
        // Ahora que el metodoPago es un enum, podemos probar que el valor correcto se asigna
        assertEquals(MetodoPago.TARJETA_CREDITO, pago.getMetodoPago());
    }

    @Test
    void testVerificarPago() {
        // En este caso, el pago debería ser válido ya que el monto es mayor que 0 y el metodo de pago es válido
        assertTrue(pago.verificarPago(pago));
    }

    @Test
    void testToString() {
        // Asegúrate de que el método toString sea correcto según la implementación
        String expected = "Pago de $10000.0 mediante Tarjeta de Crédito";
        assertEquals(expected, pago.toString());
    }
}
