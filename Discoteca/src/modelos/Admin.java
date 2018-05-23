//Borja Fernández Nava
package modelos;

import java.time.LocalDate;

// TODO: Auto-generated Javadoc
/**
 * The Class Admin.
 * Clase que cuelga de usuario, tiene privilegios especiales
 */
public class Admin extends Empleado {

	/**
	 * Instantiates a new admin.
	 *
	 * @param dni the dni
	 * @param nombre the nombre
	 * @param apellido the apellido
	 * @param oficio the oficio
	 * @param fechaAlta the fecha alta
	 * @param contraseña the contraseña
	 * @param precioHora the precio hora
	 */
	public Admin(String dni, String nombre, String apellido, String oficio, LocalDate fechaAlta, String contraseña,double precioHora) {
		super(dni, nombre, apellido, oficio, fechaAlta, contraseña, precioHora);
		// TODO Auto-generated constructor stub 
		//frvgs
	}

	
}
