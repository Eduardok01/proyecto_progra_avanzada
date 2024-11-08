package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;
import java.util.Date;

class ViajeTest {

    private Viaje viaje;
    private Ciudad origen;
    private Ciudad destino;
    private Bus bus;
    private Date fechaSalida;
    private LocalTime horaSalida;

    @BeforeEach
    void setUp() {
        origen = new Ciudad("Santiago","Metropolitana");
        destino = new Ciudad("Concepción","Bio Bio");
        bus = new Bus(1, 30);
        fechaSalida = new Date();
        horaSalida = LocalTime.of(10, 0);
        viaje = new Viaje(origen, destino, fechaSalida, horaSalida, bus);
    }

    @Test
    void testGetOrigen() {
        assertEquals(origen, viaje.getOrigen());
    }

    @Test
    void testGetDestino() {
        assertEquals(destino, viaje.getDestino());
    }

    @Test
    void testGetFechaSalida() {
        assertEquals(fechaSalida, viaje.getFechaSalida());
    }

    @Test
    void testGetHoraSalida() {
        assertEquals(horaSalida, viaje.getHoraSalida());
    }

    @Test
    void testGetBus() {
        assertEquals(bus, viaje.getBus());
    }

    @Test
    void testConsultarViaje() {
        // Esta prueba se enfocará en que no haya errores al invocar el método
        assertDoesNotThrow(() -> viaje.consultarViaje());
    }

    @Test
    void testActualizarDisponibilidad() {
        assertNotNull(viaje.actualizarDisponibilidad());
    }
}
