package modelos;

import java.time.LocalDate;

public class Espectaculos {
	
	private int idEspectaculo;
	private String nombreEspectaculo;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private int aforo=200;
	
	
	public Espectaculos(int idEspectaculo, String nombreEspectaculo, LocalDate fechaInicio, LocalDate fechaFin) {
		super();
		this.idEspectaculo = idEspectaculo;
		this.nombreEspectaculo = nombreEspectaculo;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}


	public int getIdEspectaculo() {
		return idEspectaculo;
	}


	public String getNombreEspectaculo() {
		return nombreEspectaculo;
	}


	public LocalDate getFechaInicio() {
		return fechaInicio;
	}


	public LocalDate getFechaFin() {
		return fechaFin;
	}


	public void setIdEspectaculo(int idEspectaculo) {
		this.idEspectaculo = idEspectaculo;
	}


	public void setNombreEspectaculo(String nombreEspectaculo) {
		this.nombreEspectaculo = nombreEspectaculo;
	}


	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}


	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}


	public int getAforo() {
		return aforo;
	}
	
	
	
	
	

}
