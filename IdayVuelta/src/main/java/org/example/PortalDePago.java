package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa la forma para realizar el pago.
 * @author Marcelo Rebolledo
 */
public class PortalDePago {

	private List<MetodoPago> listaMetodosPago;

	/**
	 * Constructor de la clase PortalDePago.
	 * Inicializa la lista de métodos de pago disponibles.
	 */
	public PortalDePago() {
		this.listaMetodosPago = new ArrayList<>();
		listaMetodosPago.add(MetodoPago.TARJETA_CREDITO);
		listaMetodosPago.add(MetodoPago.TARJETA_DEBITO);
	}

	/**
	 * Selecciona un método de pago de la lista de métodos disponibles.
	 *
	 * @param metodo El método de pago a seleccionar.
	 * @return Una cadena que representa el resultado de la selección.
	 */
	public String seleccionarMetodoPago(MetodoPago metodo) {
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
	 */
	public void confirmarPago(Pago pago) {
		if (listaMetodosPago.contains(pago.getMetodoPago())) {
			System.out.println("Procesando el pago de: " + pago.getMonto() + " usando el método: " + pago.getMetodoPago());
			System.out.println("Pago confirmado: " + pago.toString());
		} else {
			System.out.println("Método de pago no válido: " + pago.getMetodoPago());
		}
	}

	/**
	 * Procesa el pago verificando si es válido y devuelve un resultado.
	 *
	 * @param pago El objeto Pago a procesar.
	 * @return true si el pago es válido, false si no lo es.
	 */
	public boolean procesarPago(Pago pago) {
		if (pago != null && pago.verificarPago(pago)) {
			System.out.println("Pago procesado correctamente.");
			return true;
		} else {
			System.out.println("Error en el procesamiento del pago.");
			return false;
		}
	}

	/**
	 * Método para devolver el pago, por ejemplo si fue rechazado.
	 *
	 * @param pago El pago que se desea devolver.
	 * @return true si el pago fue devuelto correctamente, false si no.
	 */
	public boolean devolverPago(Pago pago) {
		// Lógica para devolver el pago
		System.out.println("Pago devuelto: " + pago.getMonto());
		return true;
	}
}
