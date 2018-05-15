//Borja Fern�ndez Nava
package modelos;
import java.time.LocalDate;
import java.util.Vector;


public class Empleado {
	private String dni;
	private String nombre;
	
	private String apellido;
	private String oficio;
	private LocalDate fechaAlta;
	private String contrase�a;
	private double precioHora;

	
	@Override
	public String toString() {
		return "Empleado [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", oficio=" + oficio
				+ ", fechaAlta=" + fechaAlta + ", contrase�a=" + contrase�a + ", precioHora=" + precioHora + "]";
	}
	
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getOficio() {
		return oficio;
	}
	public void setOficio(String oficio) {
		this.oficio = oficio;
	}
	public String getContrase�a() {
		return contrase�a;
	}
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
	public LocalDate getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
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
	public double getPrecioHora() {
		return precioHora;
	}
	public void setPrecioHora(double precioHora) {
		this.precioHora = precioHora;
	}
	
	
	
}
