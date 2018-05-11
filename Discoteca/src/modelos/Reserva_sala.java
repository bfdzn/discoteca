/*Tomás Gonzálvez*/

package modelos;

import java.time.LocalDate;

import bbdd.BD_reserva_sala;

public class Reserva_sala {
	private int id_espectaculo;
	private String vendedor;
	private LocalDate fecha_inicio;
	private LocalDate fecha_fin;
	private int precio;
	private String dni_cliente;
	
	BD_reserva_sala bd=new BD_reserva_sala("prueba.txt");
	
	
	
	
	public Reserva_sala( LocalDate fecha_inicio, LocalDate fecha_fin,String vendedor,
			String dni_cliente) {
		super();
		
		this.id_espectaculo = bd.Ultima_reserva() + 1;
		this.vendedor = vendedor;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.dni_cliente = dni_cliente;
		int dias_reserva=fecha_fin.compareTo(fecha_inicio);
		if(dias_reserva<5)
		this.precio = (dias_reserva*1500);
		if(dias_reserva>5&&dias_reserva<30)
			this.precio = (dias_reserva*1100);
		if(dias_reserva>30)
			this.precio = (dias_reserva*800);
	}
	public Reserva_sala( String vendedor, LocalDate fecha_inicio, LocalDate fecha_fin,
			String dni_cliente, int id_espectaculo,int precio) {
		super();
		
		this.id_espectaculo = id_espectaculo;
		this.vendedor = vendedor;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.dni_cliente = dni_cliente;
		int dias_reserva=fecha_fin.compareTo(fecha_inicio);
		this.precio = precio;
	}


	public int getId_espectaculo() {
		return id_espectaculo;
	}
	



	public String getVendedor() {
		return vendedor;
	}


	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}


	public LocalDate getFecha_inicio() {
		return fecha_inicio;
	}


	public void setFecha_inicio(LocalDate fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}


	public LocalDate getFecha_fin() {
		return fecha_fin;
	}


	public void setFecha_fin(LocalDate fecha_fin) {
		this.fecha_fin = fecha_fin;
	}


	public int getPrecio() {
		return precio;
	}


	public void setPrecio(int precio) {
		this.precio = precio;
	}


	public String getDni_cliente() {
		return dni_cliente;
	}


	public void setDni_cliente(String dni_cliente) {
		this.dni_cliente = dni_cliente;
	}
	
}
