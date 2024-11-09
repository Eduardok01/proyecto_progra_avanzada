package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

public class PagoTest {

    private Pago pagoValido;
    private Pago pagoMontoInvalido;
    private Pago pagoMetodoPagoInvalido;
    private Pago pagoFechaFutura;
    private MetodoPago metodoPagoValido;

    @BeforeEach
    public void setUp() {
        // Preparar los objetos para las pruebas
        metodoPagoValido = MetodoPago.TARJETA_CREDITO; // Asumiendo que tienes un enum de tipos de métodos de pago.

        pagoValido = new Pago(1, 100.0, metodoPagoValido, LocalDateTime.now());

        // Test con monto inválido
        pagoMontoInvalido = new Pago(2, -50.0, metodoPagoValido, LocalDateTime.now());

        // Test con método de pago nulo
        pagoMetodoPagoInvalido = new Pago(3, 100.0, null, LocalDateTime.now());

        // Test con fecha de pago futura
        pagoFechaFutura = new Pago(4, 100.0, metodoPagoValido, LocalDateTime.now().plusDays(1));
    }

    // Test para verificar el setter de monto
    @Test
    public void testSetMontoValido() {
        assertDoesNotThrow(() -> pagoValido.setMonto(200.0));
    }
    // este test fue realizado por IA, en base a un ejemplo del test anterior
    @Test
    public void testSetMontoInvalido() {
        assertThrows(IllegalArgumentException.class, () -> pagoValido.setMonto(-200.0));
        assertThrows(IllegalArgumentException.class, () -> pagoValido.setMonto(null));
    }

    // Test para verificar el setter de metodoPago
    @Test
    public void testSetMetodoPagoValido() {
        assertDoesNotThrow(() -> pagoValido.setMetodoPago(metodoPagoValido));
    }

    @Test
    public void testSetMetodoPagoInvalido() {
        assertThrows(IllegalArgumentException.class, () -> pagoValido.setMetodoPago(null));
    }

    // Test para verificar el setter de fechaPago
    @Test
    public void testSetFechaPagoValida() {
        assertDoesNotThrow(() -> pagoValido.setFechaPago(LocalDateTime.now().minusDays(1)));
    }

    @Test
    public void testSetFechaPagoFutura() {
        assertThrows(IllegalArgumentException.class, () -> pagoValido.setFechaPago(LocalDateTime.now().plusDays(1)));
    }

    // Test para verificar la verificación del pago, fue realizado con IA, junto al
    // siguiente, posterior a eso se continuó con validaciones similares
    @Test
    public void testVerificarPagoValido() {
        assertTrue(pagoValido.verificarPago());
    }

    @Test
    public void testVerificarPagoMontoInvalido() {
        assertFalse(pagoMontoInvalido.verificarPago());
    }

    @Test
    public void testVerificarPagoMetodoPagoInvalido() {
        assertFalse(pagoMetodoPagoInvalido.verificarPago());
    }

    @Test
    public void testVerificarPagoFechaFutura() {
        assertFalse(pagoFechaFutura.verificarPago());
    }

    // Test para verificar el procesarPago con un pago válido
    @Test
    public void testProcesarPagoValido() {
        assertTrue(pagoValido.procesarPago());
    }

    // Test para verificar el procesarPago con un pago inválido
    @Test
    public void testProcesarPagoInvalido() {
        assertFalse(pagoMontoInvalido.procesarPago());
        assertFalse(pagoMetodoPagoInvalido.procesarPago());
        assertFalse(pagoFechaFutura.procesarPago());
    }
}
