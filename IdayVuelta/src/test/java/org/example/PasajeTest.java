package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PasajeTest {

    private Pasaje pasaje;
    private Viaje viaje;
    private Asiento asiento;
    private Usuario usuario;

    @BeforeEach
    public void setUp() {
        pasaje = new Pasaje();

        // Configuración inicial del pasaje
        pasaje.setIdPasaje("1234");
        pasaje.setPrecio(5000f);
        pasaje.setTipo("salón cama");
    }

    @Test
    public void testValidarDatos_CamposCompletos() {
        assertTrue(pasaje.validarDatos(), "Debería retornar true si todos los campos requeridos están completos.");
    }

    @Test
    public void testCancelarPasaje() {
        pasaje.cancelarPasaje();
        assertNull(pasaje.getUsuario(), "El usuario debería ser null después de cancelar.");
        assertNull(pasaje.getIdPasaje(), "El ID del pasaje debería ser null después de cancelar.");
    }

    @Test
    public void testMostrarDetalles() {
        // Para esta prueba, solo ejecutamos mostrarDetalles y verificamos la ausencia de errores
        pasaje.mostrarDetalles();
    }

    @Test
    public void testActualizarTipo() {
        pasaje.actualizarTipo("ejecutivo");
        assertEquals("ejecutivo", pasaje.getTipo(), "El tipo debería actualizarse a 'ejecutivo'.");
    }

}
