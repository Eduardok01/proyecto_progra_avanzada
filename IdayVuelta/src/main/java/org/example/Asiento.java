package org.example;

/**
 * Clase que representa un asiento dentro de un bus.
 * Cada asiento tiene un número y un estado que indica si está ocupado o libre.
 *
 * @author Fernando
 */
public class Asiento {

    private int numeroAsiento;
    private Boolean estado;

    /**
     * Constructor de la clase Asiento.
     * Inicializa el asiento con un número específico.
     *
     * @param numeroAsiento Número del asiento.
     */
    public Asiento(int numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

    /**
     * Obtiene el número del asiento.
     *
     * @return El número del asiento.
     */
    public int getNumeroAsiento() {
        return numeroAsiento;
    }

    /**
     * Establece un nuevo número para el asiento.
     *
     * @param numeroAsiento Nuevo número para el asiento.
     */
    public void setNumeroAsiento(int numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

    /**
     * Obtiene el estado actual del asiento.
     *
     * @return El estado del asiento: true si está ocupado, false si está libre.
     */
    public Boolean getEstado() {
        return estado;
    }

    /**
     * Establece el estado del asiento.
     *
     * @param estado El nuevo estado del asiento: true para ocupado, false para libre.
     */
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    /**
     * Reserva el asiento, cambiando su estado a ocupado.
     *
     * @return true si el asiento fue reservado con éxito, false si no se pudo reservar.
     * @throws UnsupportedOperationException Método no implementado.
     */
    public Boolean reservarAsiento() {
        // TODO - implementar la lógica para reservar el asiento
        throw new UnsupportedOperationException();
    }

    /**
     * Libera el asiento, cambiando su estado a libre.
     *
     * @throws UnsupportedOperationException Método no implementado.
     */
    public void liberarAsiento() {
        // TODO - implementar la lógica para liberar el asiento
        throw new UnsupportedOperationException();
    }
}
