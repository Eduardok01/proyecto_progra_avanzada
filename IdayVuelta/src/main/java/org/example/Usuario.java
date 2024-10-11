package org.example;

public class Usuario {

	private String nombre;
	private String rut;
	private String telefono;
	private String email;

	public void ingresaDatosPersonales() {
		// TODO - implement Usuario.ingresaDatosPersonales

		this.nombre = nombre;
		this.rut = rut;
		this.telefono = telefono;
		this.email = email;
	}

	public void actualizarDatos() {
		// TODO - implement Usuario.actualizarDatos

		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
	}

	public Usuario(String nombre, String rut, String telefono, String email) {
		this.nombre = nombre;
		this.rut = rut;
		this.telefono = telefono;
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public String getRut() {
		return rut;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}