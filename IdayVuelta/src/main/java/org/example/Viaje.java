package org.example;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public class Viaje {

	private Ciudad origen;
	private Ciudad destino;
	private Date fechaSalida;
	private LocalTime horaSalida;
	private Bus bus;

	public Ciudad getOrigen() {
		return origen;
	}

	public void setOrigen(Ciudad origen) {
		this.origen = origen;
	}

	public Ciudad getDestino() {
		return destino;
	}

	public void setDestino(Ciudad destino) {
		this.destino = destino;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public LocalTime getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(LocalTime horaSalida) {
		this.horaSalida = horaSalida;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public Viaje(Ciudad origen, Ciudad destino, Date fechaSalida, LocalTime horaSalida, Bus bus) {
		this.origen = origen;
		this.destino = destino;
		this.fechaSalida = fechaSalida;
		this.horaSalida = horaSalida;
		this.bus = bus;
	}

	public void consultarViaje() {

		System.out.println("Datos del viaje: ");

		System.out.println("Origen: " + this.origen.getNombre());
		System.out.println("Destino: " + this.destino.getNombre());
		System.out.println("Fecha Salida: " + this.fechaSalida);
		System.out.println("Hora Salida: " + this.horaSalida);

	}

	public List<Asiento> actualizarDisponibilidad() {
		// TODO - implement Viaje.actualizarDisponibilidad
		throw new UnsupportedOperationException();
	}

}