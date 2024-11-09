package org.example;

import java.util.Map;
import java.util.Optional;

/**
 * Esta clase Pasaje representa un ticket de viaje que incluye la información
 * del viaje, asiento, usuario y precio. Además, permite realizar
 * operaciones como validar los datos, cancelar, mostrar detalles, entre otras.
 *
 * @author Daniel Sepúlveda
 */
public class Pasaje {

	/**
	 * Identificador único del pasaje comprado.
	 */
	private int idPasaje;

	/**
	 * Información del viaje al que corresponde el pasaje.
	 */
	private Viaje viaje;

	/**
	 * Número de asiento asignado en el viaje.
	 */
	private Asiento asiento;

	/**
	 * Datos de la persona que ha adquirido el pasaje.
	 */
	private Usuario usuario;

	/**
	 * Valor del pasaje.
	 */
	private Float precio;

	/**
	 * Tipo de pasaje (e.g., salón cama, semicama, ejecutivo, etc.)
	 */
	private String tipo;

	/**
	 * Valida que los datos del pasaje estén completos.
	 *
	 * @return	{@code true} si todos los campos requeridos ya sean idPasaje, viaje, asiento,
	 * 			usuario, precio} están presentes, de lo contrario {@code false}.
	 *
	 * @author Daniel Sepúlveda
	 */

	private static final Map<String, Float> PRECIOS_POR_TIPO = Map.of(
			"salón cama", 10000f,
			"semicama", 5000f
	);

	public Pasaje(int idPasaje, Viaje viaje, Asiento asiento, Usuario usuario, Float precio, String tipo) {
		this.idPasaje = idPasaje;
		this.viaje = viaje;
		this.asiento = asiento;
		this.usuario = usuario;
		this.precio = precio;
		this.tipo = tipo;
	}

	private boolean idPasajeValido() {
		return idPasaje > 0;
	}

	private boolean viajeValido() {
		return viaje != null;
	}

	private boolean asientoValido() {
		return asiento != null;
	}

	private boolean usuarioValido() {
		return usuario != null;
	}

	private boolean precioValido() {
		return precio != null;
	}

	/**
	 * Valida que los datos del pasaje estén completos.
	 *
	 * @return	{@code true} si todos los campos requeridos ya sean idPasaje, viaje, asiento,
	 * 			usuario, precio} están presentes, de lo contrario {@code false}.
	 *
	 * @author Daniel Sepúlveda
	 */
	public boolean validarDatos() {
		return idPasajeValido() && viajeValido() && asientoValido() && usuarioValido() && precioValido();
	}

	/**
	 * Cancela el pasaje asignado, liberando de esta forma el asiento y eliminando
	 * la referencia del usuario y el ID del pasaje. Éste muestra un mensaje de
	 * confirmación en consola
	 *
	 * @author Daniel Sepúlveda
	 */
	public void cancelarPasaje() {
		this.usuario = null;
		this.idPasaje = 0;
		imprimirMensaje("El pasaje ha sido cancelado");
	}

	/**
	 * Muestra en consola los detalles del pasaje, incluyendo el ID del pasaje,
	 * el nombre del usuario, el destino del viaje, el número de asiento,
	 * el precio y el tipo del pasaje
	 *
	 * @author Daniel Sepúlveda
	 */
	public void mostrarDetalles() {
		imprimirMensaje("Pasaje ID: " + idPasaje);
		imprimirMensaje("Usuario: " + usuario.getNombre());
		imprimirMensaje("Viaje : " + viaje.getDestino());
		imprimirMensaje("Asiento: " + asiento.getNumero());
		imprimirMensaje("Precio: $" + precio);
		imprimirMensaje("Tipo: " + tipo);
	}

	/**
	 * Actualiza el tipo de pasaje a un nuevo valor.
	 *
	 * @param nuevoTipo El nuevo tipo de pasaje.
	 *
	 * @author Daniel Sepúlveda
	 */
	public void actualizarTipo(String nuevoTipo) {
		this.tipo = nuevoTipo;
	}

	/**
	 * Registra un pacto asociado al pasaje si el pago es verificado correctamente.
	 *
	 * @param pago El pago a registrar.
	 *
	 * @author Daniel Sepúlveda
	 */
	public void registrarPago(Pago pago) {
		if (pago.verificarPago(pago)) {
			imprimirMensaje("El pago ha sido registrado");
		}
	}

	/**
	 * Calcula el precio del pasaje.
	 * No está implementado aún.
	 *
	 * @throws UnsupportedOperationException siempre, ya que no está implementado.
	 *
	 * @author Daniel Sepúlveda
	 */
	public void calcularPrecio() {
		if (tipo != null && PRECIOS_POR_TIPO.containsKey(tipo.toLowerCase())) {
			precio = PRECIOS_POR_TIPO.get(tipo.toLowerCase());
			imprimirMensaje("El precio del pasaje es: " + precio);
		} else {
			throw new UnsupportedOperationException("Tipo de pasaje no soportado");
		}
	}

	/**
	 * Asigna un asiento al pasaje.
	 * No está implementado aún.
	 *
	 * @throws UnsupportedOperationException siempre, ya que no está implementado.
	 *
	 * @author Daniel Sepúlveda
	 */
	public void asignarAsiento(Asiento asiento) {
		if (asiento != null && !asiento.isOcupado()) {
			imprimirMensaje("El asiento número " + asiento.getNumero() + " ha sido asignado.");
		} else {
			imprimirMensaje("No se puede asignar el asiento: ya está ocupado o es inválido.");
		}
	}

	private void imprimirMensaje(String mensaje) {
		System.out.println(mensaje);
	}

	public int getIdPasaje() {
		return idPasaje;
	}

	public Optional<Usuario> getUsuario() {
		return Optional.ofNullable(usuario);
	}

	public Optional<Float> getPrecio() {
		return Optional.ofNullable(precio);
	}

	public Optional<String> getTipo() {
		return Optional.ofNullable(tipo);
	}
}
