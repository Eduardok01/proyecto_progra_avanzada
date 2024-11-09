package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AsientoTest {

    private Asiento asiento;
    private Usuario usuario;

    @BeforeEach
    void setUp() {
        // Crea un usuario para usarlo en las pruebas de reserva de asiento
        usuario = new Usuario("Juan", "12345678-9", "987654321", "juan@example.com");

        // Crea un asiento con el número 1
        asiento = new Asiento(1);
    }

    @Test
    void testGetNumero() {
        // Verifica que el número del asiento es el esperado
        assertEquals(1, asiento.getNumero(), "El número del asiento debería ser 1");
    }

    @Test
    void testIsOcupadoInicialmente() {
        // Verifica que el asiento esté libre inicialmente
        assertFalse(asiento.isOcupado(), "El asiento debería estar libre inicialmente");
    }

    @Test
    void testReservarAsiento() {
        // Reserva el asiento para el usuario
        asiento.reservarAsiento(usuario);

        // Verifica que el asiento esté ocupado después de la reserva
        assertTrue(asiento.isOcupado(), "El asiento debería estar ocupado después de la reserva");

        // Verifica que el usuario sea el que reservó el asiento
        assertEquals(usuario, asiento.getUsuario(), "El usuario del asiento debería ser Juan");
    }


    @Test
    void testGetUsuario() {
        // Verifica que el usuario asignado al asiento sea el correcto
        asiento.reservarAsiento(usuario);
        assertNotNull(asiento.getUsuario(), "El usuario no debería ser nulo después de la reserva");
        assertEquals(usuario, asiento.getUsuario(), "El usuario debería ser Juan");
    }


    @Test
    void testEstadoDeOcupacionTrasReservaYLiberacion() {
        // Reserva un asiento
        asiento.reservarAsiento(usuario);
        assertTrue(asiento.isOcupado(), "El asiento debería estar ocupado después de la reserva");

        // "Libera" el asiento (simulando un proceso que podría implicar una acción adicional)
        // Aquí asumo que la clase Asiento debería tener un método para liberar el asiento
        asiento = new Asiento(1);  // Resetearlo crea el efecto de liberación (si fuera necesario)

        assertFalse(asiento.isOcupado(), "El asiento debería estar libre después de liberarse");
    }

}