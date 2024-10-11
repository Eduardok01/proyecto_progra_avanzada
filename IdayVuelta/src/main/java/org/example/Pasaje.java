package org.example;

import org.example.Asiento;

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
	private String idPasaje;

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
	public boolean validarDatos(){
		return idPasaje != null && viaje != null && asiento != null && usuario != null && precio != null;
	}

	/**
	 * Cancela el pasaje asignado, liberando de esta forma el asiento y eliminando
	 * la referencia del usuario y el ID del pasaje. Éste muestra un mensaje de
	 * confirmación en consola
	 *
	 * @author Daniel Sepúlveda
	 */
	public void cancelarPasaje(){
		asiento.setEstado(true);
		this.usuario = null;
		this.idPasaje = null;
		System.out.println("El pasaje ha sido cancelado");
	}

	/**
	 * Muestra en consola los detalles del pasaje, incluyendo el ID del pasaje,
	 * el nombre del usuario, el destino del viaje, el número de asiento,
	 * el precio y el tipo del pasaje
	 *
	 * @author Daniel Sepúlveda
	 */
	public void mostrarDetalles(){
		System.out.println("Pasaje ID: " + idPasaje);
		System.out.println("Usuario: " + usuario.getNombre());
		System.out.println("Viaje : " + viaje.getDestino());
		System.out.println("Asiento " + asiento.getNumeroAsiento());
		System.out.println("Precio: $" + precio);
		System.out.println("Tipo: " + tipo);
	}

	/**
	 * Actualiza el tipo de pasaje a un nuevo valor.
	 *
	 * @param nuevoTipo El nuevo tipo de pasaje.
	 *
	 * @author Daniel Sepúlveda
	 */
	public void actualizarTipo(String nuevoTipo){
		this.tipo = nuevoTipo;
	}

	/**
	 * Registra un pacto asociado al pasaje si el pago es verificado correctamente.
	 *
	 * @param pago El pago a registrar.
	 *
	 * @author Daniel Sepúlveda
	 */
	public void registrarPago(Pago pago){
		if (pago.verificarPago(pago)) {
			System.out.println("El pago ha sido registrado");
		}
	}

	/**
	 * Genera un nuevo pasaje.
	 * No está implementado aún.
	 *
	 * @throws UnsupportedOperationException siempre, ya que no está implementado.
	 *
	 * @author Daniel Sepúlveda
	 */
	public void generarPasaje() {

		throw new UnsupportedOperationException();
	}

	/**
	 * Calcula el precio del pasaje.
	 * No está implementado aún.
	 *
	 * @throws UnsupportedOperationException siempre, ya que no está implementado.
	 *
	 * @author Daniel Sepúlveda
	 */
	public void calcularPrercio() {

		throw new UnsupportedOperationException();
	}

	/**
	 * Asigna un asiento al pasaje.
	 * No está implementado aún.
	 *
	 * @throws UnsupportedOperationException siempre, ya que no está implementado.
	 *
	 * @author Daniel Sepúlveda
	 */
	public void asignarAsiento() {

		throw new UnsupportedOperationException();
	}

}


