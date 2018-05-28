/*Samuel de la Torre*/
package modelos;

import java.time.LocalDate;

// TODO: Auto-generated Javadoc
/**
 * The Class Espectaculos.
 * La clase de los espect�culos
 */
public class Espectaculos {
	
	/** The id espectaculo. */
	private int idEspectaculo;
	
	/** The nombre espectaculo. */
	private String nombreEspectaculo;
	
	/** The fecha inicio. */
	private LocalDate fechaInicio;
	
	/** The fecha fin. */
	private LocalDate fechaFin;
	
	/** The precio entrada. */
	private double precioEntrada;
	
	/** The aforo. */
	private int aforo;
	
	
	
	

	/**
	 * Instantiates a new espectaculos.
	 *
	 * @param idEspectaculo the id espectaculo
	 * @param nombreEspectaculo the nombre espectaculo
	 * @param fechaInicio the fecha inicio
	 * @param fechaFin the fecha fin
	 * @param precioEntrada the precio entrada
	 * @param aforo the aforo
	 */
	public Espectaculos(int idEspectaculo, String nombreEspectaculo, LocalDate fechaInicio, LocalDate fechaFin,
			double precioEntrada, int aforo) {
		super();
		this.idEspectaculo = idEspectaculo;
		this.nombreEspectaculo = nombreEspectaculo;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.precioEntrada = precioEntrada;
		this.aforo = aforo;
	}





	/**
	 * Gets the id espectaculo.
	 *
	 * @return the idEspectaculo
	 */
	public int getIdEspectaculo() {
		return idEspectaculo;
	}





	/**
	 * Sets the id espectaculo.
	 *
	 * @param idEspectaculo the idEspectaculo to set
	 */
	public void setIdEspectaculo(int idEspectaculo) {
		this.idEspectaculo = idEspectaculo;
	}





	/**
	 * Gets the nombre espectaculo.
	 *
	 * @return the nombreEspectaculo
	 */
	public String getNombreEspectaculo() {
		return nombreEspectaculo;
	}





	/**
	 * Sets the nombre espectaculo.
	 *
	 * @param nombreEspectaculo the nombreEspectaculo to set
	 */
	public void setNombreEspectaculo(String nombreEspectaculo) {
		this.nombreEspectaculo = nombreEspectaculo;
	}





	/**
	 * Gets the fecha inicio.
	 *
	 * @return the fechaInicio
	 */
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}





	/**
	 * Sets the fecha inicio.
	 *
	 * @param fechaInicio the fechaInicio to set
	 */
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}





	/**
	 * Gets the fecha fin.
	 *
	 * @return the fechaFin
	 */
	public LocalDate getFechaFin() {
		return fechaFin;
	}





	/**
	 * Sets the fecha fin.
	 *
	 * @param fechaFin the fechaFin to set
	 */
	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}





	/**
	 * Gets the precio entrada.
	 *
	 * @return the precioEntrada
	 */
	public double getPrecioEntrada() {
		return precioEntrada;
	}





	/**
	 * Sets the precio entrada.
	 *
	 * @param precioEntrada the precioEntrada to set
	 */
	public void setPrecioEntrada(double precioEntrada) {
		this.precioEntrada = precioEntrada;
	}





	/**
	 * Gets the aforo.
	 *
	 * @return the aforo
	 */
	public int getAforo() {
		return aforo;
	}





	/**
	 * Sets the aforo.
	 *
	 * @param aforo the aforo to set
	 */
	public void setAforo(int aforo) {
		this.aforo = aforo;
	}





	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Espectaculos [idEspectaculo=" + idEspectaculo + ", nombreEspectaculo=" + nombreEspectaculo
				+ ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", precioEntrada=" + precioEntrada
				+ ", aforo=" + aforo + "]";
	}
	
	
	
	
	


}
