package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AsientoTest {

    private Asiento asiento;

    @BeforeEach
    void setUp() {
        asiento = new Asiento(1);
    }

    @Test
    void testGetNumeroAsiento() {
        assertEquals(1, asiento.getNumeroAsiento());
    }

    @Test
    void testGetEstado() {
        assertFalse(asiento.getEstado());
    }

    @Test
    void testSetEstado() {
        asiento.setEstado(true);
        assertTrue(asiento.getEstado());
    }

    @Test
    void testToString() {
        String expected = "Asiento número: 1, Estado: disponible";
        assertEquals(expected, asiento.toString());
    }
}
