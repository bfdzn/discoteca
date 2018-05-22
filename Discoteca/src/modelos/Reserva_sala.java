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
	
	BD_reserva_sala bd=new BD_reserva_sala("mysql-properties.xml.txt");
	
	
	
	
	/**
	 * 
	 * @param fecha_inicio
	 * @param fecha_fin
	 * @param vendedor
	 * @param dni_cliente
	 */
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
	


	/**
	 * @return the id_espectaculo
	 */
	public int getId_espectaculo() {
		return id_espectaculo;
	}

	/**
	 * @param id_espectaculo the id_espectaculo to set
	 */
	public void setId_espectaculo(int id_espectaculo) {
		this.id_espectaculo = id_espectaculo;
	}

	/**
	 * @return the vendedor
	 */
	public String getVendedor() {
		return vendedor;
	}

	/**
	 * @param vendedor the vendedor to set
	 */
	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}

	/**
	 * @return the fecha_inicio
	 */
	public LocalDate getFecha_inicio() {
		return fecha_inicio;
	}

	/**
	 * @param fecha_inicio the fecha_inicio to set
	 */
	public void setFecha_inicio(LocalDate fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	/**
	 * @return the fecha_fin
	 */
	public LocalDate getFecha_fin() {
		return fecha_fin;
	}

	/**
	 * @param fecha_fin the fecha_fin to set
	 */
	public void setFecha_fin(LocalDate fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	/**
	 * @return the precio
	 */
	public int getPrecio() {
		return precio;
	}

	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(int precio) {
		this.precio = precio;
	}

	/**
	 * @return the dni_cliente
	 */
	public String getDni_cliente() {
		return dni_cliente;
	}

	/**
	 * @param dni_cliente the dni_cliente to set
	 */
	public void setDni_cliente(String dni_cliente) {
		this.dni_cliente = dni_cliente;
	}

	/**
	 * @return the bd
	 */
	public BD_reserva_sala getBd() {
		return bd;
	}

	/**
	 * @param bd the bd to set
	 */
	public void setBd(BD_reserva_sala bd) {
		this.bd = bd;
	}


	
	
}
