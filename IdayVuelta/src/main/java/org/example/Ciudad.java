package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * La clase Ciudad representa una ciudad con un nombre y una región.
 *
 * @author Adolfo Gayoso
 */
public class Ciudad {

	private String nombreCiudad;
	private String region;
	private List<Viaje> viajes;

	/**
	 * Crea una nueva instancia de la clase Ciudad con un nombre y una región.
	 *
	 * @param nombreCiudad el nombre de la ciudad (representado como un entero).
	 * @param region       la región donde se encuentra la ciudad.
	 */
	public Ciudad(String nombreCiudad, String region) {
		this.nombreCiudad = nombreCiudad;
		this.region = region;
		this.viajes = new ArrayList<>();
	}

	/**
	 * Obtiene el nombre de la ciudad.
	 *
	 * @return el nombre de la ciudad como un entero.
	 */
	public String getNombreCiudad() {
		return nombreCiudad;
	}

	/**
	 * Establece el nombre de la ciudad.
	 *
	 * @param nombreCiudad el nombre de la ciudad (representado como un entero).
	 */
	public void setNombreCiudad(String nombreCiudad) {
		this.nombreCiudad = nombreCiudad;
	}

	/**
	 * Obtiene la región en la que se encuentra la ciudad.
	 *
	 * @return la región de la ciudad.
	 */
	public String getRegion() {
		return region;
	}

	/**
	 * Establece la región en la que se encuentra la ciudad.
	 *
	 * @param region la región de la ciudad.
	 */
	public void setRegion(String region) {
		this.region = region;
	}

	/**
	 * Consulta los viajes disponibles desde o hacia la ciudad.
	 *
	 * Este método aún no está implementado.
	 *
	 * @throws UnsupportedOperationException si el método no está implementado.
	 */
	public void consultarViajes() {
		if (viajes.isEmpty()) {
			System.out.println("No hay viajes disponibles desde o hacia esta ciudad.");
		} else {
			System.out.println("Viajes disponibles desde o hacia la ciudad:");
			for (Viaje viaje : viajes) {
				System.out.println("- Origen: " + viaje.getOrigen().getNombreCiudad() +
						", Destino: " + viaje.getDestino().getNombreCiudad() +
						", Fecha: " + viaje.getFechaSalida() +
						", Hora: " + viaje.getHoraSalida());
			}
		}
	}

	/**
	 * Actualiza la disponibilidad de los viajes asociados a la ciudad.
	 *
	 * Este método aún no está implementado.
	 *
	 * @return una lista de viajes con disponibilidad actualizada.
	 * @throws UnsupportedOperationException si el método no está implementado.
	 */
	public List<Viaje> actualizarDisponibilidad() {
		List<Viaje> viajesConDisponibilidad = new ArrayList<>();
		for (Viaje viaje : viajes) {
			List<Asiento> asientosDisponibles = viaje.getBus().verificarDisponibilidadAsientos();
			if (!asientosDisponibles.isEmpty()) {
				viajesConDisponibilidad.add(viaje);
			}
		}
		return viajesConDisponibilidad;
	}

	public void agregarViaje(Viaje viaje) {
		viajes.add(viaje);
	}
}