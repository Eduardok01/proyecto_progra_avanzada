package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CorreoTest {

    private Correo correo;

    @BeforeEach
    void setUp() {
        correo = new Correo("test@example.com",1,);
    }

    @Test
    void testGetDestinatario() {
        assertEquals("test@example.com", correo.getDestinatario());
    }

    @Test
    void testGetAsunto() {
        assertEquals("Confirmación de Pago", correo.getAsunto());
    }

    @Test
    void testEnviarCorreo() {
        // Dado que `enviarCorreo` imprime un mensaje, solo verificaremos que no lance excepciones.
        assertDoesNotThrow(() -> correo.enviarCorreo());
    }
}
