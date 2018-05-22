//Borja Fernández Nava
package modelos;
import java.time.LocalDate;
import java.util.Vector;


public class Empleado {
	private String dni;
	private String nombre;
	private String apellido;
	private String oficio;
	private LocalDate fechaAlta;
	private String contraseña;
	private double precioHora;

	
	
	@Override
	/**
	 * toString de la informacion del empleado
	 */
	public String toString() {
		return "Empleado [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", oficio=" + oficio
				+ ", fechaAlta=" + fechaAlta + ", contraseña=" + contraseña + ", precioHora=" + precioHora + "]";
	}
	
	
	/**
	 * Constructor del Empleado
	 * @param dni
	 * @param nombre
	 * @param apellido
	 * @param oficio
	 * @param fechaAlta
	 * @param contraseña
	 * @param precioHora
	 */
	public Empleado(String dni, String nombre, String apellido, String oficio, LocalDate fechaAlta, String contraseña,double precioHora) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.oficio = oficio;
		this.fechaAlta = fechaAlta;
		this.contraseña = contraseña;
		this.precioHora = precioHora;
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
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}



	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}



	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	/**
	 * @return the oficio
	 */
	public String getOficio() {
		return oficio;
	}



	/**
	 * @param oficio the oficio to set
	 */
	public void setOficio(String oficio) {
		this.oficio = oficio;
	}



	/**
	 * @return the fechaAlta
	 */
	public LocalDate getFechaAlta() {
		return fechaAlta;
	}



	/**
	 * @param fechaAlta the fechaAlta to set
	 */
	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}



	/**
	 * @return the contraseña
	 */
	public String getContraseña() {
		return contraseña;
	}



	/**
	 * @param contraseña the contraseña to set
	 */
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}



	/**
	 * @return the precioHora
	 */
	public double getPrecioHora() {
		return precioHora;
	}



	/**
	 * @param precioHora the precioHora to set
	 */
	public void setPrecioHora(double precioHora) {
		this.precioHora = precioHora;
	}
	
	
	
	
}
