package org.example;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    private Usuario usuario;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        // Crear una instancia de Usuario antes de cada prueba
        usuario = new Usuario("Juan Pérez", "12345678-9", "987654321", "juan@example.com");
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        // Limpiar el objeto Usuario después de cada prueba
        usuario = null;
    }

    @org.junit.jupiter.api.Test
    void ingresaDatosPersonales() {
        // Verificar que los datos ingresados sean correctos
        assertEquals("Juan Pérez", usuario.getNombre(), "El nombre no se ingresó correctamente.");
        assertEquals("12345678-9", usuario.getRut(), "El RUT no se ingresó correctamente.");
        assertEquals("987654321", usuario.getTelefono(), "El teléfono no se ingresó correctamente.");
        assertEquals("juan@example.com", usuario.getEmail(), "El correo electrónico no se ingresó correctamente.");
    }

    @org.junit.jupiter.api.Test
    void actualizarDatos() {
        // Cambiar los datos del usuario
        usuario.setNombre("Carlos Soto");
        usuario.setRut("98765432-1");
        usuario.setTelefono("912345678");
        usuario.setEmail("carlos@example.com");

        // Verificar que los datos se hayan actualizado correctamente
        assertEquals("Carlos Soto", usuario.getNombre(), "El nombre no se actualizó correctamente.");
        assertEquals("98765432-1", usuario.getRut(), "El RUT no se actualizó correctamente.");
        assertEquals("912345678", usuario.getTelefono(), "El teléfono no se actualizó correctamente.");
        assertEquals("carlos@example.com", usuario.getEmail(), "El correo electrónico no se actualizó correctamente.");
    }
}
