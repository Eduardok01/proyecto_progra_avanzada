package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    @Test
    void testActualizarDatos() {
        Usuario usuario = new Usuario("Marcelo", "12345678-9", "987654321", "marcelo@gmail.com");
        usuario.actualizarDatos("Carlos","20105304-1","452345678","carlos@gmail.com");

        assertEquals("Carlos", usuario.getNombre());
        assertEquals("20105304-1",usuario.getRut());
        assertEquals("452345678", usuario.getTelefono());
        assertEquals("carlos@gmail.com", usuario.getEmail());

        System.out.println("Datos del usuario actualizados:");
        System.out.println("Nombre: " + usuario.getNombre());
        System.out.println("RUT: " + usuario.getRut());
        System.out.println("Teléfono: " + usuario.getTelefono());
        System.out.println("Email: " + usuario.getEmail());
    }
}