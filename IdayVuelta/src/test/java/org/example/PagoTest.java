package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

public class PagoTest {

    private Pago pagoValido;
    private MetodoPago metodoPagoValido;

    @BeforeEach
    public void setUp() {
        // Solo crear el pago válido en setUp
        metodoPagoValido = MetodoPago.TARJETA_CREDITO;
        pagoValido = new Pago(1, 100.0, metodoPagoValido, LocalDateTime.now());
    }

    // Test para el constructor con monto inválido
    @Test
    public void testPagoMontoInvalido() {
        assertThrows(IllegalArgumentException.class, () -> new Pago(2, -50.0, metodoPagoValido, LocalDateTime.now()),
                "El monto debe ser mayor que 0");
    }

    // Test para el constructor con método de pago nulo
    @Test
    public void testPagoMetodoPagoInvalido() {
        assertThrows(IllegalArgumentException.class, () -> new Pago(3, 100.0, null, LocalDateTime.now()),
                "El método de pago no puede ser nulo");
    }

    // Test para el constructor con fecha de pago en el futuro
    @Test
    public void testPagoFechaFutura() {
        assertThrows(IllegalArgumentException.class, () -> new Pago(4, 100.0, metodoPagoValido, LocalDateTime.now().plusDays(1)),
                "La fecha de pago no puede ser en el futuro");
    }

    // Test para verificar el setter de monto válido
    @Test
    public void testSetMontoValido() {
        assertDoesNotThrow(() -> pagoValido.setMonto(200.0));
    }

    // Test para verificar el setter de monto inválido
    @Test
    public void testSetMontoInvalido() {
        assertThrows(IllegalArgumentException.class, () -> pagoValido.setMonto(-200.0), "El monto debe ser mayor que 0");
        assertThrows(IllegalArgumentException.class, () -> pagoValido.setMonto(null), "El monto no puede ser nulo");
    }

    // Test para verificar el setter de metodoPago válido
    @Test
    public void testSetMetodoPagoValido() {
        assertDoesNotThrow(() -> pagoValido.setMetodoPago(metodoPagoValido));
    }

    // Test para verificar el setter de metodoPago inválido
    @Test
    public void testSetMetodoPagoInvalido() {
        assertThrows(IllegalArgumentException.class, () -> pagoValido.setMetodoPago(null), "El método de pago no puede ser nulo");
    }

    // Test para verificar el setter de fechaPago válida
    @Test
    public void testSetFechaPagoValida() {
        assertDoesNotThrow(() -> pagoValido.setFechaPago(LocalDateTime.now().minusDays(1)));
    }

    // Test para verificar el setter de fechaPago en el futuro
    @Test
    public void testSetFechaPagoFutura() {
        assertThrows(IllegalArgumentException.class, () -> pagoValido.setFechaPago(LocalDateTime.now().plusDays(1)),
                "La fecha de pago no puede ser en el futuro");
    }

    // Test para verificar la verificación del pago válido
    @Test
    public void testVerificarPagoValido() {
        assertTrue(pagoValido.verificarPago());
    }


    // Test para verificar el procesarPago con un pago válido
    @Test
    public void testProcesarPagoValido() {
        assertTrue(pagoValido.procesarPago());
    }

    // Test para verificar la verificación del pago con monto inválido por agregar


}
