package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un bus con una lista de asientos y una capacidad definida.
 * Se encarga de gestionar la disponibilidad de los asientos y asignar asientos a los pasajeros.
 *
 * @author Fernando
 */
public class Bus {
	private String idBus;
	private int capacidad;
	private List<Asiento> listaAsientos;

	/**
	 * Constructor de la clase Bus.
	 *
	 * @param idBus Identificador único del bus.
	 * @param capacidad Cantidad de asientos que tiene el bus.
	 */
	public Bus(String idBus, int capacidad) {
		this.idBus = idBus;
		this.capacidad = capacidad;
		this.listaAsientos = new ArrayList<>();
		// Inicializa la lista de asientos de acuerdo a la capacidad del bus
		for (int i = 1; i <= capacidad; i++) {
			listaAsientos.add(new Asiento(i));
		}
	}

	/**
	 * Verifica la disponibilidad de los asientos en el bus.
	 *
	 * @return Lista de asientos disponibles (no ocupados).
	 */
	public List<Asiento> verificarDisponibilidadAsientos() {
		List<Asiento> asientosDisponibles = new ArrayList<>();
		for (Asiento asiento : listaAsientos) {
			if (!asiento.getEstado()) {
				asientosDisponibles.add(asiento);
			}
		}
		return asientosDisponibles;
	}

	/**
	 * Asigna un asiento en el bus si está disponible.
	 *
	 * @param numeroAsiento Número del asiento a asignar.
	 * @return El objeto Asiento asignado, o null si no se puede asignar.
	 */
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

	/**
	 * Obtiene el identificador único del bus.
	 *
	 * @return ID del bus.
	 */
	public String getIdBus() {
		return idBus;
	}

	/**
	 * Establece el identificador del bus.
	 *
	 * @param idBus Nuevo identificador del bus.
	 */
	public void setIdBus(String idBus) {
		this.idBus = idBus;
	}

	/**
	 * Obtiene la capacidad del bus.
	 *
	 * @return Cantidad de asientos del bus.
	 */
	public int getCapacidad() {
		return capacidad;
	}

	/**
	 * Establece la capacidad del bus.
	 *
	 * @param capacidad Nueva capacidad del bus.
	 */
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	/**
	 * Obtiene la lista de asientos del bus.
	 *
	 * @return Lista de objetos Asiento del bus.
	 */
	public List<Asiento> getListaAsientos() {
		return listaAsientos;
	}

	/**
	 * Establece la lista de asientos del bus.
	 *
	 * @param listaAsientos Nueva lista de asientos.
	 */
	public void setListaAsientos(List<Asiento> listaAsientos) {
		this.listaAsientos = listaAsientos;
	}
}
