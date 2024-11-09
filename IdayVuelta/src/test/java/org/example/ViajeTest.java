package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de prueba unitaria para la clase Viaje.
 */
public class ViajeTest {

    private Ciudad origen;
    private Ciudad destino;

    private Date fechaSalida;
    private LocalTime horaSalida;

    private Bus bus;
    private final int capacidadBus = 5;

    private Usuario usuario;

    private Viaje viaje;
    private int numeroAsientoReserva = 1;

    @BeforeEach
    public void setUp() {
        origen = new Ciudad("Ciudad Origen", "");
        destino = new Ciudad("Ciudad Destino", "");

        fechaSalida = new Date();
        horaSalida = LocalTime.now();

        bus = new Bus(1, capacidadBus);

        usuario = new Usuario("usuario1", "", "", "correo@ejemplo.com");

        viaje = new Viaje(origen, destino, fechaSalida, horaSalida, bus);
    }

    @Test
    public void testObtenerAsientosDisponiblesSinRerservas() {
        List<Asiento> asientosDisponibles = viaje.obtenerAsientosDisponibles();
        int cantidadDisponibles = asientosDisponibles.size();
        assertEquals(capacidadBus, cantidadDisponibles);
    }

    @Test
    public void testAsientosDisponiblesConReserva() {
        viaje.reservarAsiento(numeroAsientoReserva, usuario);
        List<Asiento> asientosDisponibles = viaje.obtenerAsientosDisponibles();
        int cantidadDisponibles = asientosDisponibles.size();
        assertEquals(capacidadBus - 1, cantidadDisponibles);
    }

    @Test
    public void testReservarAsientoDisponible() {
        boolean resultado = viaje.reservarAsiento(numeroAsientoReserva, usuario);
        assertTrue(resultado);
    }

    @Test
    public void testReservarAsientoOcupado() {
        viaje.reservarAsiento(numeroAsientoReserva, usuario);
        boolean resultado = viaje.reservarAsiento(numeroAsientoReserva, usuario);
        assertFalse(resultado);
    }

    @Test
    public void testReservarAsientoInexistente() {
        boolean resultado = viaje.reservarAsiento(capacidadBus + 1, usuario);
        assertFalse(resultado);
    }

}
