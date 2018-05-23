//Borja Fern�ndez Nava
package modelos;
import java.time.LocalDate;
import java.util.Vector;


// TODO: Auto-generated Javadoc
/**
 * The Class Empleado.
 * Clase del objeto Empleado, Admin cuelga de ella
 */
public class Empleado {
	
	/** The dni. */
	private String dni;
	
	/** The nombre. */
	private String nombre;
	
	/** The apellido. */
	private String apellido;
	
	/** The oficio. */
	private String oficio;
	
	/** The fecha alta. */
	private LocalDate fechaAlta;
	
	/** The contrase�a. */
	private String contrase�a;
	
	/** The precio hora. */
	private double precioHora;

	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	/**
	 * toString de la informacion del empleado
	 */
	public String toString() {
		return "Empleado [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", oficio=" + oficio
				+ ", fechaAlta=" + fechaAlta + ", contrase�a=" + contrase�a + ", precioHora=" + precioHora + "]";
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
	 * Gets the nombre.
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Sets the nombre.
	 *
	 * @param nombre the new nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Gets the apellido.
	 *
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}
	
	/**
	 * Sets the apellido.
	 *
	 * @param apellido the new apellido
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	/**
	 * Gets the oficio.
	 *
	 * @return the oficio
	 */
	public String getOficio() {
		return oficio;
	}
	
	/**
	 * Sets the oficio.
	 *
	 * @param oficio the new oficio
	 */
	public void setOficio(String oficio) {
		this.oficio = oficio;
	}
	
	/**
	 * Gets the contrase�a.
	 *
	 * @return the contrase�a
	 */
	public String getContrase�a() {
		return contrase�a;
	}
	
	/**
	 * Sets the contrase�a.
	 *
	 * @param contrase�a the new contrase�a
	 */
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
	
	/**
	 * Gets the fecha alta.
	 *
	 * @return the fecha alta
	 */
	public LocalDate getFechaAlta() {
		return fechaAlta;
	}
	
	/**
	 * Sets the fecha alta.
	 *
	 * @param fechaAlta the new fecha alta
	 */
	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	
	/**
	 * Constructor del Empleado.
	 *
	 * @param dni the dni
	 * @param nombre the nombre
	 * @param apellido the apellido
	 * @param oficio the oficio
	 * @param fechaAlta the fecha alta
	 * @param contrase�a the contrase�a
	 * @param precioHora the precio hora
	 */
	public Empleado(String dni, String nombre, String apellido, String oficio, LocalDate fechaAlta, String contrase�a,double precioHora) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.oficio = oficio;
		this.fechaAlta = fechaAlta;
		this.contrase�a = contrase�a;
		this.precioHora = precioHora;
	}


	/**
	 * Gets the precio hora.
	 *
	 * @return the precioHora
	 */
	public double getPrecioHora() {
		return precioHora;
	}
	/**
	 * Sets the precio hora.
	 *
	 * @param precioHora the new precio hora
	 */
	public void setPrecioHora(double precioHora) {
		this.precioHora = precioHora;
	}
	
	
	
	
}
