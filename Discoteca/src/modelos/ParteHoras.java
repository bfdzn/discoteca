/*Tomás Gonzálvez*/

package modelos;

import java.time.LocalDate;

public class ParteHoras {
	private String dniEmpleado;
	private LocalDate fecha;
	private int horas;
	private double salario;
	
	/**
	 * Constructor Parte de Horas
	 * @param dniEmpleado
	 * @param fecha
	 * @param horas
	 * @param salario
	 */
	public ParteHoras(String dniEmpleado, LocalDate fecha, int horas, double salario) {
		super();
		this.dniEmpleado = dniEmpleado;
		this.fecha = fecha;
		this.horas = horas;
		this.salario = salario;
	}

	/**
	 * @return the dniEmpleado
	 */
	public String getDniEmpleado() {
		return dniEmpleado;
	}

	/**
	 * @param dniEmpleado the dniEmpleado to set
	 */
	public void setDniEmpleado(String dniEmpleado) {
		this.dniEmpleado = dniEmpleado;
	}

	/**
	 * @return the fecha
	 */
	public LocalDate getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the horas
	 */
	public int getHoras() {
		return horas;
	}

	/**
	 * @param horas the horas to set
	 */
	public void setHoras(int horas) {
		this.horas = horas;
	}

	/**
	 * @return the salario
	 */
	public double getSalario() {
		return salario;
	}

	/**
	 * @param salario the salario to set
	 */
	public void setSalario(double salario) {
		this.salario = salario;
	}


	
}
