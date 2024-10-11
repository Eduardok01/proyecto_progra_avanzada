package org.example;

/**
 * Esta clase representa un usuario en el sistema.
 * Contiene la información personal del usuario.
 * @author Marcelo Rebolledo
 */

public class Usuario {

	private String nombre;
	private String rut;
	private String telefono;
	private String email;

	/**
	 * Método para ingresar los datos personales del usuario.
	 */
	public void ingresaDatosPersonales() {
		// TODO - implement Usuario.ingresaDatosPersonales

		this.nombre = nombre;
		this.rut = rut;
		this.telefono = telefono;
		this.email = email;
	}

	/**
	 * Actualizar los datos personales del usuario.
	 */
	public void actualizarDatos() {
		// TODO - implement Usuario.actualizarDatos

		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
	}

	/**
	 * Crear un nuevo usuario con los datos proporcionados.
	 *@param nombre nombre del usuario.
	 *@param rut el RUT del usuario.
	 *@param telefono número de telefono del usuario.
	 *@param email correo del usuario.
	 */
	public Usuario(String nombre, String rut, String telefono, String email) {
		this.nombre = nombre;
		this.rut = rut;
		this.telefono = telefono;
		this.email = email;
	}

	/**
	 * Obtiene el nombre del usuario.
	 *
	 * @return El nombre del usuario.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Obtiene el RUT del usuario.
	 *
	 * @return El RUT del usuario.
	 */
	public String getRut() {
		return rut;
	}

	/**
	 * Obtiene el número de teléfono del usuario.
	 *
	 * @return El número de teléfono del usuario.
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * Obtiene el correo electrónico del usuario.
	 *
	 * @return El correo electrónico del usuario.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Establece el nombre del usuario.
	 *
	 * @param nombre El nombre a establecer.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Establece el RUT del usuario.
	 *
	 * @param rut El RUT a establecer.
	 */
	public void setRut(String rut) {
		this.rut = rut;
	}

	/**
	 * Establece el número de teléfono del usuario.
	 *
	 * @param telefono El número de teléfono a establecer.
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * Establece el correo electrónico del usuario.
	 *
	 * @param email El correo electrónico a establecer.
	 */
	public void setEmail(String email) {
		this.email = email;
	}
}