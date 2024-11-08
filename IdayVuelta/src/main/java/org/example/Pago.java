package org.example;

import java.time.LocalDateTime;

/**
 * Clase que representa lo relacionado con el pago.
 * @author Eduardo Krause
 */
public class Pago {

	private int idPago;
	private Double monto;
	private MetodoPago metodoPago;  // cambié a MetodoPago en lugar de int
	private LocalDateTime fechaPago;

	/**
	 * Es el constructor del objeto
	 *
	 * @param idPago id del pago
	 * @param monto monto del pago
	 * @param metodoPago metodo del pago
	 * @param fechaPago fecha del pago
	 * @return contructor
	 */
	public Pago(int idPago, Double monto, MetodoPago metodoPago, LocalDateTime fechaPago){
		this.idPago = idPago;
		this.monto = monto;
		this.metodoPago = metodoPago;  // Cambié aquí
		this.fechaPago = fechaPago;
	}

	/**
	 * @author Eduardo Krause
	 * @return object data
	 */
	public int getIdPago() {
		return idPago;
	}

	public void setIdPago(int idPago) {
		this.idPago = idPago;
	}

	/**
	 * @author Eduardo Krause
	 * @return object data
	 */
	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	/**
	 * @author Eduardo Krause
	 * @return object data
	 */
	public MetodoPago getMetodoPago() {  // Cambié el tipo a MetodoPago
		return metodoPago;
	}

	public void setMetodoPago(MetodoPago metodoPago) {  // Cambié aquí también
		this.metodoPago = metodoPago;
	}

	/**
	 * @author Eduardo Krause
	 * @return object data
	 */
	public LocalDateTime getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(LocalDateTime fechaPago) {
		this.fechaPago = fechaPago;
	}

	/**
	 * @author Eduardo Krause
	 * @param pago
	 * @return boolean
	 * Este método revisa el procesamiento del pago del boleto
	 */
	public boolean procesarPago(Pago pago) {
		if (verificarPago(pago)) {
			System.out.println("Procesando el pago de " + pago.getMonto() + " con el método " + pago.getMetodoPago());
			System.out.println("Pago realizado con éxito el " + pago.getFechaPago() + ". ID de pago: " + pago.getIdPago());
			return true;
		} else {
			System.out.println("Error en los detalles del pago");
			return false;
		}
	}

	/**
	 * @author Eduardo Krause
	 * @param pago
	 * @return boolean
	 * Este método se encarga de verificar la existencia correcta del pago.
	 */
	public boolean verificarPago(Pago pago) {
		if (pago.getMonto() > 0) {
			if (pago.getMetodoPago() != null) {  // Verificamos si el metodoPago no es null
				return true;
			}
		}
		return false;
	}
}
