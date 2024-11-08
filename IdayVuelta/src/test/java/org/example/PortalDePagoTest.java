package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class PortalDePagoTest {

    private PortalDePago portalDePago;
    private Pago pago;

    @BeforeEach
    void setUp() {
        portalDePago = new PortalDePago();
        // Crear el pago con el metodoPago como MetodoPago.TARJETA_CREDITO
        pago = new Pago(1, 10000.0, MetodoPago.TARJETA_CREDITO, LocalDateTime.now());
    }

    @Test
    void testProcesarPago() {
        // Se asume que el pago se procesa correctamente si `verificarPago` devuelve true.
        // Asegurándote de que el método procesarPago devuelve true cuando todoo está correcto
        assertTrue(portalDePago.procesarPago(pago));
    }

    @Test
    void testDevolverPago() {
        // En este caso, el método devolverPago debería devolver true, indicando que el pago fue devuelto.
        assertTrue(portalDePago.devolverPago(pago));
    }
}
