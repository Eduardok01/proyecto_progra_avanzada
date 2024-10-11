package org.example;

import java.util.Date;

public class Pago {

	private String idPago;
	private Double monto;
	private String metodoPago;
	private Date fechaPago;

	public Pago(String idPago, Double monto, String metodoPago, Date fechaPago){
		this.idPago = idPago;
		this.monto = monto;
		this.metodoPago = metodoPago;
		this.fechaPago = fechaPago;

	}

	/**
	 * @author Eduardo Krause
	 * @return object data
	 *
	 */
	public String getIdPago() {
		return idPago;
	}

	public void setIdPago(String idPago) {
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
	public String getMetodoPago() {
		return metodoPago;
	}

	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}
	/**
	 * @author Eduardo Krause
	 * @return object data
	 */
	public Date getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}


	/**
	 * @author Eduardo Krause
	 * @param pago
	 * @return boolean
	 * este metodo revisa el procesamiento del pago del boleto
	 */
	public boolean procesarPago(Pago pago) {
		//throw new UnsupportedOperationException();
		if(verificarPago(pago)){
			System.out.println("procesando el pago de " +  pago.getMonto() + "con el metodo" + pago.getMetodoPago());
			System.out.println("pago realizado con exito el"+ pago.getFechaPago() + ". ID de pago: "+ pago.getIdPago());
			return true;
		}else{
			System.out.println("Error en los detalles del pago");
			return false;
		}
		

	}

	/**
	 * @author Eduardo Krause
	 * @param pago
	 * @return boolean
	 * este metodo se encarga de verificar la existencia correcta del pago,
	 *
	 */
	public boolean verificarPago(Pago pago) {
		//throw new UnsupportedOperationException();
		if(pago.getMonto() > 0){
			if(!pago.getMetodoPago().isEmpty()){
				return true;
			}

		}return false;
	}





}