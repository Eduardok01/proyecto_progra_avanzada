package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class BusTest {

    private Bus bus;
    private Asiento asiento1;
    private Asiento asiento2;

    @BeforeEach
    void setUp() {
        asiento1 = new Asiento(1);
        asiento2 = new Asiento(2);
        asiento2.reservarAsiento(new Usuario("ola","2-2","13131","a@.com"));
        List<Asiento> asientos = new ArrayList<>();
        asientos.add(asiento1);
        asientos.add(asiento2);
        bus = new Bus(1, 20);
    }

    @Test
    void testVerificarDisponibilidadAsientos() {
        List<Asiento> disponibles = bus.verificarDisponibilidadAsientos();
        assertEquals(1, disponibles.size());
        assertEquals(asiento1, disponibles.get(0));
    }

    @Test
    void testToString() {
        String expected = "Bus patente: ABC123, cantidad de asientos: 2";
        assertEquals(expected, bus.toString());
    }
}
