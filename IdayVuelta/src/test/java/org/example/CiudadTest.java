package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CiudadTest {

    private Ciudad ciudad;

    @BeforeEach
    void setUp() {
        ciudad = new Ciudad("Santiago","Metropolitana");
    }

    @Test
    void testGetNombreCiudad() {
        assertEquals("Santiago", ciudad.getNombreCiudad());
    }

    @Test
    void testSetNombreCiudad() {
        ciudad.setNombreCiudad("Valparaíso");
        assertEquals("Valparaíso", ciudad.getNombreCiudad());
    }

    @Test
    void testToString() {
        String expected = "Ciudad: Santiago";
        assertEquals(expected, ciudad.toString());
    }
}
