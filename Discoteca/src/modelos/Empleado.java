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
	public String toString() {
		return "Empleado [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", oficio=" + oficio
				+ ", fechaAlta=" + fechaAlta + ", contraseña=" + contraseña + ", precioHora=" + precioHora + "]";
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
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public LocalDate getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
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
	public double getPrecioHora() {
		return precioHora;
	}
	public void setPrecioHora(double precioHora) {
		this.precioHora = precioHora;
	}
	
	
	
}
