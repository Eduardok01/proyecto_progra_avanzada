package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * La clase Ciudad representa una ciudad con un nombre y una región.
 *
 * @author Adolfo Gayoso
 */
public class Ciudad {

	private String nombre;
	private String region;

	/**
	 * Crea una nueva instancia de la clase Ciudad con un nombre y una región.
	 *
	 * @param nombre el nombre de la ciudad (representado como un entero).
	 * @param region       la región donde se encuentra la ciudad.
	 */
	public Ciudad(String nombre, String region) {
		this.nombre = nombre;
		this.region = region;
	}

	/**
	 * Obtiene el nombre de la ciudad.
	 *
	 * @return el nombre de la ciudad como un entero.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Obtiene la región en la que se encuentra la ciudad.
	 *
	 * @return la región de la ciudad.
	 */
	public String getRegion() {
		return region;
	}
}