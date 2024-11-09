package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class PasajeTest {

    private Pasaje pasaje;
    private Viaje viaje;
    private Asiento asiento;
    private Usuario usuario;

    @BeforeEach
    public void setUp() {
        pasaje = new Pasaje();

        // Inicialización de objetos requeridos
        Ciudad origen = new Ciudad("Santiago", "Región Metropolitana");
        Ciudad destino = new Ciudad("Valparaíso", "Región de Valparaíso");
        Date fechaSalida = new Date();
        LocalTime horaSalida = LocalTime.of(10, 30);
        Bus bus = new Bus(1, 40);

        // Inicialización de objetos requeridos
        viaje = new Viaje(origen, destino, fechaSalida, horaSalida, bus);
        asiento = new Asiento(1);
        usuario = new Usuario("Probando", "12345678-9", "987654321", "prob@gmail.com");

        // Configuración inicial del pasaje
        pasaje.setIdPasaje(1234);
        pasaje.setPrecio(10000f);
        pasaje.setTipo("salón cama");
        pasaje.setViaje(viaje);
        pasaje.setAsiento(asiento);
        pasaje.setUsuario(usuario);
    }

    @Test
    public void testValidarDatos_CamposCompletos() {
        assertTrue(pasaje.validarDatos(), "Debería retornar true si todos los campos requeridos están completos.");
    }

    @Test
    public void testCancelarPasaje() {
        pasaje.cancelarPasaje();
        assertNull(pasaje.getUsuario(), "El usuario debería ser null después de cancelar.");
        assertEquals(0, pasaje.getIdPasaje(), "El ID del pasaje debería ser 0 después de cancelar.");
    }

    @Test
    public void testMostrarDetalles() {
        // Para esta prueba, solo ejecutamos mostrarDetalles y verificamos la ausencia de errores
        System.out.println("Detalles Pasaje:\n");
        pasaje.mostrarDetalles();
    }

    @Test
    public void testActualizarTipo() {
        pasaje.actualizarTipo("ejecutivo");
        assertEquals("ejecutivo", pasaje.getTipo(), "El tipo debería actualizarse a 'ejecutivo'.");
    }

    @Test
    public void testGenerarPasaje() {
        pasaje.generarPasaje();
        assertTrue(pasaje.getIdPasaje() >= 0 && pasaje.getIdPasaje() < 100, "El ID del pasaje generado debería estar en el rango 0-99.");
    }

    @Test
    public void testCalcularPrecio_SalonCama() {
        pasaje.setTipo("salón cama");
        pasaje.calcularPrecio();
        assertEquals(10000, pasaje.getPrecio(), "El precio debería ser 10000 para salón cama.");
    }

    @Test
    public void testCalcularPrecio_Semicama() {
        pasaje.setTipo("semicama");
        pasaje.calcularPrecio();
        assertEquals(5000, pasaje.getPrecio(), "El precio debería ser 5000 para semicama.");
    }
    @Test
    public void testAsignarAsiento_Disponible() {
        pasaje.asignarAsiento(asiento);
        assertFalse(asiento.isOcupado(), "El asiento debería ser asignado correctamente si está disponible.");
    }

    @Test
    public void testAsignarAsiento_Ocupado() {
        Asiento asientoOcupado = new Asiento(2);
        asientoOcupado.reservarAsiento(usuario);
        pasaje.asignarAsiento(asientoOcupado);
        // Debe imprimir que no se puede asignar el asiento porque ya está ocupado.
    }
}