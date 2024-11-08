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
	private int id;
	private int capacidad;
	private List<Asiento> asientos;

	/**
	 * Constructor de la clase Bus.
	 *
	 * @param id Identificador único del bus.
	 * @param capacidad Cantidad de asientos que tiene el bus.
	 */

	public Bus(int id, int capacidad) {
		this.id = id;
		this.capacidad = capacidad;
		this.asientos = new ArrayList<>();

		// Inicializa la lista de asientos de acuerdo a la capacidad del bus
		for (int i = 1; i <= capacidad; i++) {
			asientos.add(new Asiento(i));
		}
	}

	public int getId() {
		return id;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public List<Asiento> getAsientos() {
		return asientos;
	}

	/**
	 * Retorna una lista con los asientos disponibles (no ocupados) del bus
	 *
	 * @return Lista de asientos disponibles (no ocupados).
	 */
	public List<Asiento> obtenerAsientosDisponibles() {
		List<Asiento> asientosDisponibles = new ArrayList<>();
		for (Asiento asiento : asientos) {
			if (!asiento.isOcupado()) {
				asientosDisponibles.add(asiento);
			}
		}
		return asientosDisponibles;
	}

	public Asiento obtenerAsientoPorNumero(int numeroAsiento) {
		for (Asiento asiento : asientos) {
			if (asiento.getNumero() == numeroAsiento) {
				return asiento;
			}
		}
		return null;
	}

	public boolean isAsientoDisponible(int numeroAsiento) {
		Asiento asiento = obtenerAsientoPorNumero(numeroAsiento);
		// Posible refactoring de code smell
		if (asiento != null) {
			if (!asiento.isOcupado()) {
				return true;
			}
		}
		return false;
	}

	public void reservarAsiento(int numeroAsiento, Usuario usuario) {
		Asiento asiento = obtenerAsientoPorNumero(numeroAsiento);
		if (asiento != null) {
			if (!asiento.isOcupado()) {
				asiento.reservarAsiento(usuario);
			}
		}
	}
}
