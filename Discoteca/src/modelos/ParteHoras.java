/*Tomás Gonzálvez*/

package modelos;

import java.time.LocalDate;

public class ParteHoras {
	private String dniEmpleado;
	private LocalDate fecha;
	private int horas;
	private double salario;
	
	
	public ParteHoras(String dniEmpleado, LocalDate fecha, int horas, double salario) {
		super();
		this.dniEmpleado = dniEmpleado;
		this.fecha = fecha;
		this.horas = horas;
		this.salario = salario;
	}


	public String getDniEmpleado() {
		return dniEmpleado;
	}


	public void setDniEmpleado(String dniEmpleado) {
		this.dniEmpleado = dniEmpleado;
	}


	public LocalDate getFecha() {
		return fecha;
	}


	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}


	public int getHoras() {
		return horas;
	}


	public void setHoras(int horas) {
		this.horas = horas;
	}


	public double getSalario() {
		return salario;
	}


	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	
}
