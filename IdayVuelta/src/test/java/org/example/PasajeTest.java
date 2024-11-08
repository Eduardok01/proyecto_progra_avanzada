package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class PasajeTest {

    private Pasaje pasaje;
    private Usuario usuario;
    private Viaje viaje;
    private Asiento asiento;

    @BeforeEach
    void setUp() {
        // Crear instancias de las dependencias necesarias
        usuario = new Usuario("Juan Pérez", "12345678-9", "987654321", "juan@example.com");
        asiento = new Asiento(1); // Asiento no asignado (estado = false)
        viaje = new Viaje(new Ciudad("Santiago","Metropolitana"), new Ciudad("Valparaíso","Valparaiso"), new java.util.Date(), java.time.LocalTime.now(), new Bus(1,20));

        // Crear el pasaje con los datos iniciales
        pasaje = new Pasaje();
        pasaje.setIdPasaje("Id-01");
        pasaje.setUsuario(usuario);
        pasaje.setViaje(viaje);
        pasaje.setAsiento(asiento);
        pasaje.setPrecio(5000f);
        pasaje.setTipo("semicama");
    }

    @AfterEach
    void tearDown() {
        // Limpiar los objetos después de cada prueba
        pasaje = null;
        usuario = null;
        asiento = null;
        viaje = null;
    }

    @Test
    void validarDatos() {
        // Verificar que los datos estén completos
        assertTrue(pasaje.validarDatos(), "Los datos del pasaje deben ser válidos.");
    }

    @Test
    void cancelarPasaje() {
        // Cancelamos el pasaje
        pasaje.cancelarPasaje();

        // Verificar que el asiento se haya liberado y que el pasaje se haya cancelado
        assertTrue(asiento.getEstado(), "El asiento debe estar disponible tras la cancelación.");
        assertNull(pasaje.getUsuario(), "El usuario debe ser nulo después de cancelar el pasaje.");
        assertNull(pasaje.getIdPasaje(), "El ID del pasaje debe ser nulo después de cancelarlo.");
    }

    @Test
    void mostrarDetalles() {
        // Verificar que el método mostrarDetalles no lance excepciones
        pasaje.mostrarDetalles();
    }

    @Test
    void actualizarTipo() {
        // Actualizamos el tipo de pasaje y verificamos el cambio
        pasaje.actualizarTipo("salón cama");
        assertEquals("salón cama", pasaje.getTipo(), "El tipo del pasaje no se actualizó correctamente.");
    }

    @Test
    void registrarPago() {
    }

    @Test
    void generarPasaje() {
        // Generamos el pasaje
        pasaje.generarPasaje();

        // Verificamos que el ID del pasaje ha sido generado
        assertNotNull(pasaje.getIdPasaje(), "El ID del pasaje debería haber sido generado.");
    }

    @Test
    void calcularPrecio() {
        // Calculamos el precio del pasaje
        pasaje.calcularPrecio();

        // Verificamos que el precio se haya calculado correctamente
        assertEquals(5000f, pasaje.getPrecio(), "El precio del pasaje no se calculó correctamente.");
    }

    @Test
    void asignarAsiento() {
        // Asignamos un asiento
        pasaje.asignarAsiento();

        // Verificamos que el asiento se haya asignado correctamente
        assertTrue(asiento.getEstado(), "El asiento debe estar asignado.");
    }
}
