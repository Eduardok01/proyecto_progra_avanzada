package org.example;

/**
 * Clase que representa un asiento dentro de un bus.
 * Cada asiento tiene un número y un estado que indica si está ocupado o libre.
 *
 * @author Fernando
 */
public class Asiento {

    private int numero;
    private Usuario usuario;
    private Boolean ocupado;

    /**
     * Constructor de la clase Asiento.
     * Inicializa el asiento con un número específico.
     *
     * @param numeroAsiento Número del asiento.
     */
    public Asiento(int numeroAsiento) {
        this.numero = numeroAsiento;
        this.usuario = null;
        this.ocupado = false;
    }

    public int getNumero() {
        return numero;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Boolean isOcupado() {
        return ocupado;
    }

    public void reservarAsiento(Usuario usuario) {
        this.usuario = usuario;
        this.ocupado = true;
    }
}