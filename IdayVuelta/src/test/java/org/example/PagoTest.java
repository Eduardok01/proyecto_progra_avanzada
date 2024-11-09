package org.example;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class PagoTest {

    @Test
    void testVerificarPagoValido() {
        MetodoPago metodo = MetodoPago.TARJETA_CREDITO;
        Pago pago = new Pago(1, 1000.0, metodo, LocalDateTime.now());
        assertTrue(pago.verificarPago(pago));
    }

    @Test
    void testVerificarPagoInvalido() {
        Pago pago = new Pago(1, -1000.0, null, LocalDateTime.now());
        assertFalse(pago.verificarPago(pago));
    }

    @Test
    void testProcesarPago() {
        MetodoPago metodo = MetodoPago.TARJETA_DEBITO;
        Pago pago = new Pago(1, 1000.0, metodo, LocalDateTime.now());
        assertTrue(pago.procesarPago(pago));
    }

    @Test
    void testProcesarPagoInvalido() {
        Pago pago = new Pago(1, -1000.0, null, LocalDateTime.now());
        assertFalse(pago.procesarPago(pago));
    }

    @Test
    void testActualizarPago() {
        Pago pago = new Pago(1, 2000.0, MetodoPago.TRANSFERENCIA, LocalDateTime.now());
        pago.setMonto(2500.0);
        assertEquals(2500.0, pago.getMonto());
    }
}
