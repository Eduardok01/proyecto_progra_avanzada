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

	public String getIdPago() {
		return idPago;
	}

	public void setIdPago(String idPago) {
		this.idPago = idPago;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public String getMetodoPago() {
		return metodoPago;
	}

	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}

	public Date getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}








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

	public boolean verificarPago(Pago pago) {
		//throw new UnsupportedOperationException();
		if(pago.getMonto() > 0){
			if(!pago.getMetodoPago().isEmpty()){
				return true;
			}

		}return false;
	}





}