package org.example;

/**
 * Clase que representa un correo electrónico que contiene la información del pasaje de bus.
 * El correo incluye detalles del pasajero y la reserva.
 * @author Marcelo Rebolledo
 */
public class Correo {

	private String destinatario;
	private String asunto;
	private String contenido;

	/**
	 * Constructor para crear un correo con la información del pasaje.
	 *
	 * @param destinatario Correo electrónico del destinatario (el pasajero).
	 * @param idBus Identificación del bus.
	 * @param numeroAsiento Número del asiento reservado.
	 * @param fechaSalida Fecha y hora de salida del bus.
	 * @param origen Ciudad de origen.
	 * @param destino Ciudad de destino.
	 */
	public Correo(String destinatario, String idBus, int numeroAsiento, String fechaSalida, String origen, String destino) {
		if (destinatario == null || destinatario.isEmpty()) {
			throw new IllegalArgumentException("El destinatario no puede ser nulo o vacío.");
		}

		this.destinatario = destinatario;
		this.asunto = "Detalles de su pasaje de bus";
		this.contenido = generarContenidoCorreo(idBus, numeroAsiento, fechaSalida, origen, destino);
	}

	/**
	 * Genera el contenido del correo con los detalles del pasaje.
	 *
	 * @param idBus Identificación del bus.
	 * @param numeroAsiento Número del asiento reservado.
	 * @param fechaSalida Fecha y hora de salida del bus.
	 * @param origen Ciudad de origen.
	 * @param destino Ciudad de destino.
	 * @return Contenido formateado del correo.
	 */
	private String generarContenidoCorreo(String idBus, int numeroAsiento, String fechaSalida, String origen, String destino) {
		return "¡Gracias por viajar con nosotros!, \n\n" +
				"Aquí están los detalles de su pasaje de bus:\n" +
				"Bus: " + idBus + "\n" +
				"Asiento: " + numeroAsiento + "\n" +
				"Fecha y ora de salida: " + fechaSalida + "\n" +
				"Origen: " + origen + "\n" +
				"Destino: " + destino;
	}

	/**
	 * Envía el correo con los detalles del pasaje.
	 */
	public void enviarCorreo() {
		if (validarCorreo(destinatario)) {
			System.out.println("Enviando correo a: " + destinatario);
			System.out.println("Asunto: " + asunto);
			System.out.println("Contenido: \n" + contenido);
		} else {
			System.out.println("Dirección de correo inválida.");
		}
	}

	/**
	 * Valida si una dirección de correo electrónico es válida.
	 *
	 * @param correo El correo electrónico a validar.
	 * @return true si el correo es válido y false en caso contrario.
	 */
	private boolean validarCorreo(String correo) {
		return correo.contains("@") && correo.contains(".");
	}

	/**
	 * Obtiene el destinatario del correo.
	 *
	 * @return El destinatario del correo.
	 */
	public String getDestinatario() {
		return destinatario;
	}

	/**
	 * Establece el destinatario del correo.
	 *
	 * @param destinatario El nuevo destinatario del correo.
	 */
	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	/**
	 * Obtiene el asunto del correo.
	 *
	 * @return El asunto del correo.
	 */
	public String getAsunto() {
		return asunto;
	}

	/**
	 * Establece el asunto del correo.
	 *
	 * @param asunto El nuevo asunto del correo.
	 */
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	/**
	 * Obtiene el contenido del correo.
	 *
	 * @return El contenido del correo.
	 */
	public String getContenido() {
		return contenido;
	}

	/**
	 * Establece el contenido del correo.
	 *
	 * @param contenido El nuevo contenido del correo.
	 */
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
}