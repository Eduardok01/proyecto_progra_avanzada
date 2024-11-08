package org.example;

public enum MetodoPago {
    TARJETA_CREDITO(1),
    TARJETA_DEBITO(2),
    TRANSFERENCIA(3);

    private final int valor;

    // Constructor del enum
    MetodoPago(int valor) {
        this.valor = valor;
    }

    // Getter para obtener el valor asociado
    public int getValor() {
        return valor;
    }

    // Método estático para obtener un enum desde un valor
    public static MetodoPago fromInt(int i) {
        for (MetodoPago metodo : MetodoPago.values()) {
            if (metodo.getValor() == i) {
                return metodo;
            }
        }
        return null;  // Devuelve null si no se encuentra el valor
    }
}
