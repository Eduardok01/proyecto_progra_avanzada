package org.example;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

/**
 * La clase Viaje representa un viaje en bus entre dos ciudades en una fecha y hora específicas.
 *
 * @author Adolfo Gayoso
 */
public class Viaje {

	private Ciudad origen;
	private Ciudad destino;
	private Date fechaSalida;
	private LocalTime horaSalida;
	private Bus bus;

	/**
	 * Obtiene la ciudad de origen del viaje.
	 *
	 * @return la ciudad de origen del viaje.
	 */
	public Ciudad getOrigen() {
		return origen;
	}

	/**
	 * Establece la ciudad de origen del viaje.
	 *
	 * @param origen la ciudad de origen.
	 */
	public void setOrigen(Ciudad origen) {
		this.origen = origen;
	}

	/**
	 * Obtiene la ciudad de destino del viaje.
	 *
	 * @return la ciudad de destino del viaje.
	 */
	public Ciudad getDestino() {
		return destino;
	}

	/**
	 * Establece la ciudad de destino del viaje.
	 *
	 * @param destino la ciudad de destino.
	 */
	public void setDestino(Ciudad destino) {
		this.destino = destino;
	}

	/**
	 * Obtiene la fecha de salida del viaje.
	 *
	 * @return la fecha de salida del viaje.
	 */
	public Date getFechaSalida() {
		return fechaSalida;
	}

	/**
	 * Establece la fecha de salida del viaje.
	 *
	 * @param fechaSalida la fecha de salida del viaje.
	 */
	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	/**
	 * Obtiene la hora de salida del viaje.
	 *
	 * @return la hora de salida del viaje.
	 */
	public LocalTime getHoraSalida() {
		return horaSalida;
	}

	/**
	 * Establece la hora de salida del viaje.
	 *
	 * @param horaSalida la hora de salida del viaje.
	 */
	public void setHoraSalida(LocalTime horaSalida) {
		this.horaSalida = horaSalida;
	}

	/**
	 * Obtiene el bus asignado al viaje.
	 *
	 * @return el bus asignado al viaje.
	 */
	public Bus getBus() {
		return bus;
	}

	/**
	 * Establece el bus asignado al viaje.
	 *
	 * @param bus el bus asignado.
	 */
	public void setBus(Bus bus) {
		this.bus = bus;
	}

	/**
	 * Crea una nueva instancia de la clase Viaje con los detalles del origen, destino, fecha y hora de salida, y el bus.
	 *
	 * @param origen      la ciudad de origen del viaje.
	 * @param destino     la ciudad de destino del viaje.
	 * @param fechaSalida la fecha de salida del viaje.
	 * @param horaSalida  la hora de salida del viaje.
	 * @param bus         el bus asignado al viaje.
	 */
	public Viaje(Ciudad origen, Ciudad destino, Date fechaSalida, LocalTime horaSalida, Bus bus) {
		this.origen = origen;
		this.destino = destino;
		this.fechaSalida = fechaSalida;
		this.horaSalida = horaSalida;
		this.bus = bus;
	}

	/**
	 * Imprime en consola los detalles del viaje, incluyendo la ciudad de origen, la ciudad de destino, la fecha y hora de salida.
	 */
	public void consultarViaje() {

		System.out.println("Datos del viaje: ");

		System.out.println("Origen: " + this.origen.getNombreCiudad());
		System.out.println("Destino: " + this.destino.getNombreCiudad());
		System.out.println("Fecha Salida: " + this.fechaSalida);
		System.out.println("Hora Salida: " + this.horaSalida);

	}

	/**
	 * Actualiza la disponibilidad de los asientos del viaje.
	 *
	 * Este método aún no está implementado.
	 *
	 * @return una lista de asientos disponibles.
	 * @throws UnsupportedOperationException si el método no está implementado.
	 */
	public List<Asiento> actualizarDisponibilidad() {
		// TODO - implement Viaje.actualizarDisponibilidad
		throw new UnsupportedOperationException();
	}

}
