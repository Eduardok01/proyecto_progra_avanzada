package org.example;


import java.util.ArrayList;
import java.util.List;

public class Bus {
	private String idBus;
	private int capacidad;
	private List<Asiento> listaAsientos;

	public Bus(String idBus, int capacidad) {
		this.idBus = idBus;
		this.capacidad = capacidad;
		this.listaAsientos = new ArrayList<>();
		for (int i = 1; i <= capacidad; i++) {
			listaAsientos.add(new Asiento(i));
		}
	}

	public List<Asiento> verificarDisponibilidadAsientos() {
		List<Asiento> asientosDisponibles = new ArrayList<>();
		for (Asiento asiento : listaAsientos) {
			if (!asiento.getEstado()) {
				asientosDisponibles.add(asiento);
			}
		}
		return asientosDisponibles;
	}

	public Asiento asignarAsiento(int numeroAsiento) {
		if (numeroAsiento > 0 && numeroAsiento <= capacidad) {
			Asiento asiento = listaAsientos.get(numeroAsiento - 1);
			if (!asiento.getEstado()) {
				asiento.reservarAsiento();
				return asiento;
			} else {
				System.out.println("El asiento ya está ocupado.");
			}
		} else {
			System.out.println("Número de asiento inválido.");
		}
		return null;
	}

	public String getIdBus() {
		return idBus;
	}

	public void setIdBus(String idBus) {
		this.idBus = idBus;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public List<Asiento> getListaAsientos() {
		return listaAsientos;
	}

	public void setListaAsientos(List<Asiento> listaAsientos) {
		this.listaAsientos = listaAsientos;
	}
}
