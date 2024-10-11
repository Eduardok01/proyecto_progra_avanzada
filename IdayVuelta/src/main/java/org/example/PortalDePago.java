package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 *Clase que representa la forma para realizar el pago.
 * @author Marcelo Rebolledo
 */
public class PortalDePago {

	private List<String> listaMetodosPago;

	/**
	 * Constructor de la clase PortalDePago.
	 * Inicializa la lista de métodos de pago disponibles.
	 */
	public PortalDePago() {
		this.listaMetodosPago = new ArrayList<>();
		listaMetodosPago.add("Tarjeta de Crédito");
		listaMetodosPago.add("Tarjeta de Débito");
	}

	/**
	 * Selecciona un método de pago de la lista de métodos disponibles.
	 *
	 * @param metodo El nombre del método de pago a seleccionar.
	 * @return Una cadena que representa el resultado de la selección.
	 * @throws UnsupportedOperationException Si el método no está implementado.
	 */
	public String seleccionarMetodoPago(String metodo) {
		if (listaMetodosPago.contains(metodo)) {
			return "Método de pago seleccionado: " + metodo;
		} else {
			return "Método de pago no disponible.";
		}
	}

	/**
	 * Confirma el pago utilizando el método de pago seleccionado.
	 *
	 * @param pago El objeto Pago que contiene los detalles del pago a confirmar.
	 * @throws UnsupportedOperationException Si el método no está implementado.
	 */
	public void confirmarPago(Pago pago) {
		if (listaMetodosPago.contains(pago.getMetodoPago())) {
			System.out.println("Procesando el pago de: " + pago.getMonto() + " usando el método: " + pago.getMetodoPago());
			System.out.println("Pago confirmado: " + pago.toString());
		} else {
			System.out.println("Método de pago no válido: "+ pago.getMetodoPago());
		}
	}
}