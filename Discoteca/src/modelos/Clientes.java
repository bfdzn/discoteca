package modelos;

import java.time.LocalDate;

public class Clientes {
	private String dni;
	private LocalDate fechaNacimiento;
	
	public Clientes(String dni, LocalDate fechaNacimiento) {
		super();
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	


}
