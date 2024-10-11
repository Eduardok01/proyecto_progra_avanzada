package org.example;

import java.util.List;




/**
 * La clase Ciudad representa una ciudad con un nombre y una región.
 *
 * @author Adolfo Gayoso
 */
public class Ciudad {

	private int nombreCiudad;
	private String region;

	/**
	 * Crea una nueva instancia de la clase Ciudad con un nombre y una región.
	 *
	 * @param nombreCiudad el nombre de la ciudad (representado como un entero).
	 * @param region       la región donde se encuentra la ciudad.
	 */
	public Ciudad(int nombreCiudad, String region) {
		this.nombreCiudad = nombreCiudad;
		this.region = region;
	}

	/**
	 * Obtiene el nombre de la ciudad.
	 *
	 * @return el nombre de la ciudad como un entero.
	 */
	public int getNombreCiudad() {
		return nombreCiudad;
	}

	/**
	 * Establece el nombre de la ciudad.
	 *
	 * @param nombreCiudad el nombre de la ciudad (representado como un entero).
	 */
	public void setNombreCiudad(int nombreCiudad) {
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
		// TODO - implement Ciudad.consultarViajes
		throw new UnsupportedOperationException();
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
		// TODO - implement Ciudad.actualizarDisponibilidad
		throw new UnsupportedOperationException();
	}

}
