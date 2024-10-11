package org.example;

public class Asiento {

    private int numeroAsiento;
    private Boolean estado;

    public Asiento(int numeroAsiento, Boolean estado) {
        this.numeroAsiento = numeroAsiento;
        this.estado = estado;
    }

    public int getNumeroAsiento() {
        return numeroAsiento;
    }

    public void setNumeroAsiento(int numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Boolean reservarAsiento() {
        // TODO - implement Asiento.reservarAsiento
        throw new UnsupportedOperationException();
    }

    public void liberarAsiento() {
        // TODO - implement Asiento.liberarAsiento
        throw new UnsupportedOperationException();
    }

}