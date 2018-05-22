package modelos;

import java.time.LocalDate;

public class Clientes {
	private String dni;
	private LocalDate fechaNacimiento;
	
	/**
	 * Constructor de clientes
	 * @param dni
	 * @param fechaNacimiento
	 */
	public Clientes(String dni, LocalDate fechaNacimiento) {
		super();
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * @return the fechaNacimiento
	 */
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * @param fechaNacimiento the fechaNacimiento to set
	 */
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	
}
