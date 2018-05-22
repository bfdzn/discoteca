/*Tomás Gonzálvez*/

package modelos;

import java.time.LocalDate;

import bbdd.BD_reserva_sala;

// TODO: Auto-generated Javadoc
/**
 * The Class Reserva_sala.
 */
public class Reserva_sala {
	
	/** The id espectaculo. */
	private int id_espectaculo;
	
	/** The vendedor. */
	private String vendedor;
	
	/** The fecha inicio. */
	private LocalDate fecha_inicio;
	
	/** The fecha fin. */
	private LocalDate fecha_fin;
	
	/** The precio. */
	private int precio;
	
	/** The dni cliente. */
	private String dni_cliente;
	
	/** The bd. */
	BD_reserva_sala bd=new BD_reserva_sala("prueba.txt");
//	BD_reserva_sala bd=new BD_reserva_sala("mysql-properties.xml.txt");
	
	
	
	
	/**
	 * Instantiates a new reserva sala.
	 *
	 * @param fecha_inicio the fecha inicio
	 * @param fecha_fin the fecha fin
	 * @param vendedor the vendedor
	 * @param dni_cliente the dni cliente
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
	 * Instantiates a new reserva sala.
	 *
	 * @param vendedor the vendedor
	 * @param fecha_inicio the fecha inicio
	 * @param fecha_fin the fecha fin
	 * @param dni_cliente the dni cliente
	 * @param id_espectaculo the id espectaculo
	 * @param precio the precio
	 */
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


	/**
	 * Gets the id espectaculo.
	 *
	 * @return the id espectaculo
	 */

	public int getId_espectaculo() {
		return id_espectaculo;
	}

	public void setId_espectaculo(int id_espectaculo) {
		this.id_espectaculo = id_espectaculo;
	}

	/**
	 * Gets the vendedor.
	 *
	 * @return the vendedor
	 */
	public String getVendedor() {
		return vendedor;
	}

	/**
	 * Sets the vendedor.
	 *
	 * @param vendedor the new vendedor
	 */
	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}
	/**
	 * Gets the fecha inicio.
	 *
	 * @return the fecha inicio
	 */
	public LocalDate getFecha_inicio() {
		return fecha_inicio;
	}


	/**
	 * Sets the fecha inicio.
	 *
	 * @param fecha_inicio the new fecha inicio
	 */
	public void setFecha_inicio(LocalDate fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	/**
	 * Gets the fecha fin.
	 *
	 * @return the fecha fin
	 */
	public LocalDate getFecha_fin() {
		return fecha_fin;
	}


	/**
	 * Sets the fecha fin.
	 *
	 * @param fecha_fin the new fecha fin
	 */
	public void setFecha_fin(LocalDate fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	/**
	 * Gets the precio.
	 */
	public int getPrecio() {
		return precio;
	}

	/**
	 * Sets the precio.
	 *
	 * @param precio the new precio
	 */
	public void setPrecio(int precio) {
		this.precio = precio;
	}

	/**
	 * Gets the dni cliente.
	 *
	 * @return the dni cliente
	 */
	public String getDni_cliente() {
		return dni_cliente;
	}


	/**
	 * Sets the dni cliente.
	 *
	 * @param dni_cliente the new dni cliente
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
