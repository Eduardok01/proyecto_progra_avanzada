package org.example;

import org.example.Asiento;

//Hola

public class Pasaje {

	private String idPasaje;
	private Viaje viaje;
	private Asiento asiento;
	private Usuario usuario;
	private Float precio;
	private String tipo;

	public boolean validarDatos(){
		return idPasaje != null && viaje != null && asiento != null && usuario != null && precio != null;
	}
	public void canncelarPasaje(){
		asiento.setEstado(true);
		this.usuario = null;
		this.idPasaje = null;
		System.out.println("El pasaje ha sido cancelado");
	}

	public void mostrarDetalles(){
		System.out.println("Pasaje ID: " + idPasaje);
		System.out.println("Usuario: " + usuario.getNombre());
		System.out.println("Viaje : " + viaje.getDestino());
		System.out.println("Asiento " + asiento.getNumeroAsiento());
		System.out.println("Precio: $" + precio);
		System.out.println("Tipo: " + tipo);
	}

	public void actualizarTipo(String nuevoTipo){
		this.tipo = nuevoTipo;
	}

	public void registrarPago(Pago pago){
		if (pago.verificarPago(pago)) {
			System.out.println("El pago ha sido registrado");
		}
	}


	public void generarPasaje() {
		// TODO - implement Pasaje.generarPasaje
		throw new UnsupportedOperationException();
	}

	public void calcularPrercio() {
		// TODO - implement Pasaje.calcularPrercio
		throw new UnsupportedOperationException();
	}

	public void asignarAsiento() {
		// TODO - implement Pasaje.asignarAsiento
		throw new UnsupportedOperationException();
	}

}


