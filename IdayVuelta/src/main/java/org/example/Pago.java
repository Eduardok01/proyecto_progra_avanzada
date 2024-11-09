package org.example;

import java.time.LocalDateTime;

/**
 * Clase que representa lo relacionado con el pago.
 * @author Eduardo Krause
 */
public class Pago {

	private int idPago;
	private Double monto;
	private MetodoPago metodoPago;  // Cambié a MetodoPago en lugar de int
	private LocalDateTime fechaPago;

	/**
	 * Constructor de la clase Pago.
	 *
	 * @param idPago id del pago
	 * @param monto monto del pago
	 * @param metodoPago metodo del pago
	 * @param fechaPago fecha del pago
	 */
	public Pago(int idPago, Double monto, MetodoPago metodoPago, LocalDateTime fechaPago) {
		this.idPago = idPago;
		setMonto(monto);
		setMetodoPago(metodoPago);
		setFechaPago(fechaPago);
	}


	public int getIdPago() {
		return idPago;
	}

	public void setIdPago(int idPago) {
		this.idPago = idPago;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		if (monto == null || monto <= 0) {
			throw new IllegalArgumentException("El monto debe ser mayor que 0");
		}
		this.monto = monto;
	}

	public MetodoPago getMetodoPago() {
		return metodoPago;
	}

	public void setMetodoPago(MetodoPago metodoPago) {
		if (metodoPago == null) {
			throw new IllegalArgumentException("El método de pago no puede ser nulo");
		}
		this.metodoPago = metodoPago;
	}

	public LocalDateTime getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(LocalDateTime fechaPago) {
		if (fechaPago != null && fechaPago.isAfter(LocalDateTime.now())) {
			throw new IllegalArgumentException("La fecha de pago no puede ser en el futuro");
		}
		this.fechaPago = fechaPago;
	}

	/**
	 * Método para procesar un pago.
	 * Este método verifica la validez del pago y luego lo procesa si es válido.
	 *
	 * @return true si el pago es procesado correctamente, false si no lo es.
	 */
	public boolean procesarPago() {
		if (verificarPago()) {
			mostrarMensajeExito();
			return true;
		} else {
			mostrarMensajeError();
			return false;
		}
	}

	/**
	 * Verifica que el pago sea válido.
	 * Este método asegura que el monto sea mayor que 0 y el método de pago no sea nulo.
	 *
	 * @return true si el pago es válido, false si no lo es.
	 */
	public boolean verificarPago() {
		return monto > 0 && metodoPago != null && fechaPago != null && !fechaPago.isAfter(LocalDateTime.now());
	}

	/**
	 * Muestra el mensaje de éxito después de procesar el pago.
	 */
	private void mostrarMensajeExito() {
		System.out.println("Procesando el pago de " + monto + " con el método " + metodoPago);
		System.out.println("Pago realizado con éxito el " + fechaPago + ". ID de pago: " + idPago);
	}

	/**
	 * Muestra el mensaje de error si el pago no es válido.
	 */
	private void mostrarMensajeError() {
		System.out.println("Error en los detalles del pago");
	}

	/**
	 * Sobrecarga del método toString para facilitar la impresión de los detalles de un pago.
	 *
	 * @return una cadena que representa los detalles del pago.
	 */
	@Override
	public String toString() {
		return "Pago{idPago=" + idPago + ", monto=" + monto + ", metodoPago=" + metodoPago + ", fechaPago=" + fechaPago + '}';
	}
}
