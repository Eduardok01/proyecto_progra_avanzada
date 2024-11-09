package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    @Test
    void testIngresaDatosPersonales() {
        Usuario usuario = new Usuario("marcelo", "12345678-9", "987654321", "marcelo@gmail.com");
        usuario.ingresaDatosPersonales("Pedro", "98765432-1", "123456789", "pedro@gmail.com");

        assertEquals("Pedro", usuario.getNombre());
        assertEquals("98765432-1", usuario.getRut());
        assertEquals("123456789", usuario.getTelefono());
        assertEquals("pedro@gmail.com", usuario.getEmail());
    }

    @Test
    void testActualizarDatos() {
        Usuario usuario = new Usuario("marcelo", "12345678-9", "987654321", "marcelo@gmail.com");
        usuario.actualizarDatos("Carlos", "987654321", "carlos@gmail.com");

        assertEquals("Carlos", usuario.getNombre());
        assertEquals("987654321", usuario.getTelefono());
        assertEquals("carlos@gmail.com", usuario.getEmail());
    }
}
