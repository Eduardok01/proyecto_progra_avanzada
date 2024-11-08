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

	public Viaje(Ciudad origen, Ciudad destino, Date fechaSalida, LocalTime horaSalida, Bus bus) {
		this.origen = origen;
		this.destino = destino;
		this.fechaSalida = fechaSalida;
		this.horaSalida = horaSalida;
		this.bus = bus;
	}

	public Ciudad getOrigen() {
		return origen;
	}

	public Ciudad getDestino() {
		return destino;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public LocalTime getHoraSalida() {
		return horaSalida;
	}

	public Bus getBus() {
		return bus;
	}

	public List<Asiento> obtenerAsientosDisponibles() {
		return this.bus.obtenerAsientosDisponibles();
	}

	public boolean reservarAsiento(int numeroAsiento, Usuario usuario) {
		boolean flag = false;

		Asiento asiento = this.bus.obtenerAsientoPorNumero(numeroAsiento);

		if (asiento != null) {
			if (!asiento.isOcupado()){
				bus.reservarAsiento(numeroAsiento, usuario);
				flag = true;
			}
		}

		return flag;
	}

}