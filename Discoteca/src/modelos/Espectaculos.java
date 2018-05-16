package modelos;

import java.time.LocalDate;

public class Espectaculos {
	
	private int idEspectaculo;
	private String nombreEspectaculo;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private double precioEntrada;
	private int aforo=200;
	
	
	
	

	/**
	 * @param idEspectaculo
	 * @param nombreEspectaculo
	 * @param fechaInicio
	 * @param fechaFin
	 * @param precioEntrada
	 * @param aforo
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
	 * @return the idEspectaculo
	 */
	public int getIdEspectaculo() {
		return idEspectaculo;
	}





	/**
	 * @param idEspectaculo the idEspectaculo to set
	 */
	public void setIdEspectaculo(int idEspectaculo) {
		this.idEspectaculo = idEspectaculo;
	}





	/**
	 * @return the nombreEspectaculo
	 */
	public String getNombreEspectaculo() {
		return nombreEspectaculo;
	}





	/**
	 * @param nombreEspectaculo the nombreEspectaculo to set
	 */
	public void setNombreEspectaculo(String nombreEspectaculo) {
		this.nombreEspectaculo = nombreEspectaculo;
	}





	/**
	 * @return the fechaInicio
	 */
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}





	/**
	 * @param fechaInicio the fechaInicio to set
	 */
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}





	/**
	 * @return the fechaFin
	 */
	public LocalDate getFechaFin() {
		return fechaFin;
	}





	/**
	 * @param fechaFin the fechaFin to set
	 */
	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}





	/**
	 * @return the precioEntrada
	 */
	public double getPrecioEntrada() {
		return precioEntrada;
	}





	/**
	 * @param precioEntrada the precioEntrada to set
	 */
	public void setPrecioEntrada(double precioEntrada) {
		this.precioEntrada = precioEntrada;
	}





	/**
	 * @return the aforo
	 */
	public int getAforo() {
		return aforo;
	}





	/**
	 * @param aforo the aforo to set
	 */
	public void setAforo(int aforo) {
		this.aforo = aforo;
	}
	
	
	
	
	

}
