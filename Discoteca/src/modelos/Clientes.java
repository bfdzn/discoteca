package modelos;

import java.time.LocalDate;

// TODO: Auto-generated Javadoc
/**
 * The Class Clientes.
 */
public class Clientes {
	
	/** The dni. */
	private String dni;
	
	/** The fecha nacimiento. */
	private LocalDate fechaNacimiento;
	
	/**
	 * Instantiates a new clientes.
	 *
	 * @param dni the dni
	 * @param fechaNacimiento the fecha nacimiento
	 */
	public Clientes(String dni, LocalDate fechaNacimiento) {
		super();
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * Gets the dni.
	 *
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * Sets the dni.
	 *
	 * @param dni the new dni
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * Gets the fecha nacimiento.
	 *
	 * @return the fecha nacimiento
	 */
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * Sets the fecha nacimiento.
	 *
	 * @param fechaNacimiento the new fecha nacimiento
	 */
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

}
