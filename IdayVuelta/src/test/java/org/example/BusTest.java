package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class BusTest {

    private Bus bus;
    private Usuario usuario;

    @BeforeEach
    void setUp() {
        // Inicializa un bus con 5 asientos para las pruebas
        bus = new Bus(1, 5);
        usuario = new Usuario("Juan", "12345678-9", "987654321", "juan@example.com");
    }

    @Test
    void testObtenerAsientosDisponibles() {
        // Todos los asientos deben estar disponibles al principio
        List<Asiento> asientosDisponibles = bus.obtenerAsientosDisponibles();
        assertEquals(5, asientosDisponibles.size(), "El número de asientos disponibles debería ser 5");
    }

    @Test
    void testIsAsientoDisponible() {
        // Verifica que un asiento no esté ocupado
        assertTrue(bus.isAsientoDisponible(1), "El asiento 1 debería estar disponible");

        // Reserva el asiento
        bus.reservarAsiento(1, usuario);

        // Verifica que el asiento ahora está ocupado
        assertFalse(bus.isAsientoDisponible(1), "El asiento 1 debería estar ocupado después de la reserva");
    }

    @Test
    void testObtenerAsientoPorNumero() {
        // Verifica que se obtiene el asiento correcto por número
        Asiento asiento = bus.obtenerAsientoPorNumero(2);
        assertNotNull(asiento, "El asiento 2 debería existir");
        assertEquals(2, asiento.getNumero(), "El número del asiento debería ser 2");

        // Verifica que se devuelve null si el asiento no existe
        assertNull(bus.obtenerAsientoPorNumero(6), "El asiento 6 no debería existir");
    }

    @Test
    void testReservarAsiento() {
        // Reserva un asiento y verifica si se ha reservado correctamente
        bus.reservarAsiento(3, usuario);
        Asiento asiento = bus.obtenerAsientoPorNumero(3);
        assertTrue(asiento.isOcupado(), "El asiento 3 debería estar ocupado después de la reserva");
        assertEquals(usuario, asiento.getUsuario(), "El asiento 3 debería estar reservado por el usuario Juan");

        // Intenta reservar un asiento ya ocupado
        Usuario otroUsuario = new Usuario("Maria", "87654321-0", "987654322", "maria@example.com");
        bus.reservarAsiento(3, otroUsuario);
        assertEquals(usuario, asiento.getUsuario(), "El asiento 3 debería seguir reservado por el primer usuario, Juan");
    }

    @Test
    void testObtenerAsientosDisponiblesTrasReserva() {
        // Reserva un asiento
        bus.reservarAsiento(4, usuario);

        // Verifica que el número de asientos disponibles sea correcto
        List<Asiento> asientosDisponibles = bus.obtenerAsientosDisponibles();
        assertEquals(4, asientosDisponibles.size(), "El número de asientos disponibles debería ser 4 tras una reserva");
    }

    @Test
    void testReservarAsientoNoDisponible() {
        // Reserva todos los asientos
        bus.reservarAsiento(1, usuario);
        bus.reservarAsiento(2, usuario);
        bus.reservarAsiento(3, usuario);
        bus.reservarAsiento(4, usuario);
        bus.reservarAsiento(5, usuario);

        // Intenta reservar un asiento cuando no hay disponibilidad
        bus.reservarAsiento(6, usuario);  // Este asiento no existe
        List<Asiento> asientosDisponibles = bus.obtenerAsientosDisponibles();
        assertEquals(0, asientosDisponibles.size(), "No debe haber asientos disponibles si todos están reservados");
    }
}
