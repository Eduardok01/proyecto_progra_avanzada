package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    @Test
    void testActualizarDatos() {
        Usuario usuario = new Usuario("Marcelo", "12345678-9", "987654321", "marcelo@gmail.com");
        usuario.actualizarDatos("Carlos","20105304-1","912345678","carlos@gmail.com");

        assertEquals("Carlos", usuario.getNombre());
        assertEquals("20105304-1",usuario.getRut());
        assertEquals("912345678", usuario.getTelefono());
        assertEquals("carlos@gmail.com", usuario.getEmail());
    }
}