package modelos;
import java.time.LocalDate;
import java.util.Vector;


public class Empleado {
	String dni;
	String nombre;
	String apellido;
	String oficio;
	LocalDate fechaAlta;
	Vector<ParteHoras> usuarios;
}
