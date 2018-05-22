/*Tomás Gonzálvez*/

package modelos;

import java.time.LocalDate;

// TODO: Auto-generated Javadoc
/**
 * The Class ParteHoras.
 */
public class ParteHoras {
	
	/** The dni empleado. */
	private String dniEmpleado;
	
	/** The fecha. */
	private LocalDate fecha;
	
	/** The horas. */
	private int horas;
	
	/** The salario. */
	private double salario;
	
	/**
	 * Instantiates a new parte horas.
	 *
	 * @param dniEmpleado the dni empleado
	 * @param fecha the fecha
	 * @param horas the horas
	 * @param salario the salario
	 */
	public ParteHoras(String dniEmpleado, LocalDate fecha, int horas, double salario) {
		super();
		this.dniEmpleado = dniEmpleado;
		this.fecha = fecha;
		this.horas = horas;

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
