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

	/**
	 * Gets the dni empleado.
	 *
	 * @return the dni empleado
	 */
	public String getDniEmpleado() {
		return dniEmpleado;
	}

	/**
	 * Sets the dni empleado.
	 *
	 * @param dniEmpleado the new dni empleado
	 */
	public void setDniEmpleado(String dniEmpleado) {
		this.dniEmpleado = dniEmpleado;
	}

	/**
	 * Gets the fecha.
	 *
	 * @return the fecha
	 */
	public LocalDate getFecha() {
		return fecha;
	}

	/**
	 * Sets the fecha.
	 *
	 * @param fecha the new fecha
	 */
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	/**
	 * Gets the horas.
	 *
	 * @return the horas
	 */
	public int getHoras() {
		return horas;
	}

	/**
	 * Sets the horas.
	 *
	 * @param horas the new horas
	 */
	public void setHoras(int horas) {
		this.horas = horas;
	}

	/**
	 * Gets the salario.
	 *
	 * @return the salario
	 */
	public double getSalario() {
		return salario;
	}

	/**
	 * Sets the salario.
	 *
	 * @param salario the new salario
	 */
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	

	
}
