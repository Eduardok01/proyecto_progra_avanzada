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
        // Creamos instancias mock o de prueba para los atributos requeridos
        viaje = new Viaje("DestinoEjemplo"); // Ejemplo simple de inicialización, ajusta según tu implementación de Viaje
        asiento = new Asiento(1, false); // Ejemplo simple de inicialización
        usuario = new Usuario("UsuarioEjemplo"); // Ejemplo simple de inicialización

        // Instanciamos `Pasaje` con valores iniciales
        pasaje = new Pasaje(1234, viaje, asiento, usuario, 5000f, "salón cama");
    }

    @Test
    public void testValidarDatos_CamposCompletos() {
        assertTrue(pasaje.validarDatos(), "Debería retornar true si todos los campos requeridos están completos.");
    }

    @Test
    public void testCancelarPasaje() {
        pasaje.cancelarPasaje();
        assertTrue(pasaje.getUsuario().isEmpty(), "El usuario debería ser null después de cancelar.");
        assertEquals(0, pasaje.getIdPasaje(), "El ID del pasaje debería ser 0 después de cancelar.");
    }

    @Test
    public void testMostrarDetalles() {
        // Solo ejecutamos mostrarDetalles y verificamos que no arroje excepciones
        assertDoesNotThrow(() -> pasaje.mostrarDetalles(), "No debería lanzar excepciones al mostrar detalles.");
    }

    @Test
    public void testActualizarTipo() {
        pasaje.actualizarTipo("ejecutivo");
        assertEquals("ejecutivo", pasaje.getTipo().orElse(""), "El tipo debería actualizarse a 'ejecutivo'.");
    }

    @Test
    public void testCalcularPrecio_SalonCama() {
        pasaje.actualizarTipo("salón cama");
        pasaje.calcularPrecio();
        assertEquals(10000f, pasaje.getPrecio().orElse(0f), 0.01f, "El precio debería ser 10000 para 'salón cama'.");
    }

    @Test
    public void testCalcularPrecio_Semicama() {
        pasaje.actualizarTipo("semicama");
        pasaje.calcularPrecio();
        assertEquals(5000f, pasaje.getPrecio().orElse(0f), 0.01f, "El precio debería ser 5000 para 'semicama'.");
    }

    @Test
    public void testCalcularPrecio_TipoInvalido() {
        pasaje.actualizarTipo("invalido");
        Exception exception = assertThrows(UnsupportedOperationException.class, pasaje::calcularPrecio);
        assertEquals("Tipo de pasaje no soportado", exception.getMessage());
    }
}
