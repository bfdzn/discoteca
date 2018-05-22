package modelos;

import java.time.LocalDate;


public class Entradas {
	
	private int numEntrada;
	private int idEspectaculo;
	private String dniEntrada;
	private LocalDate fecha;
	private String vendedor;
	
	/**
	 * Constructor para Entradas
	 * @param numEntrada
	 * @param idEspectaculo
	 * @param dniEntrada
	 * @param fecha
	 * @param vendedor
	 */
	
	public Entradas(int numEntrada,int idEspectaculo, String dniEntrada, LocalDate fecha, String vendedor) {
		
		super();
		this.numEntrada=numEntrada;
		this.idEspectaculo = idEspectaculo;
		this.dniEntrada = dniEntrada;
		this.fecha = fecha;
		this.vendedor = vendedor;
		
	}

	/**
	 * @return the numEntrada
	 */
	public int getNumEntrada() {
		return numEntrada;
	}

	/**
	 * @param numEntrada the numEntrada to set
	 */
	public void setNumEntrada(int numEntrada) {
		this.numEntrada = numEntrada;
	}

	/**
	 * @return the idEspectaculo
	 */
	public int getIdEspectaculo() {
		return idEspectaculo;
	}

	/**
	 * @param idEspectaculo the idEspectaculo to set
	 */
	public void setIdEspectaculo(int idEspectaculo) {
		this.idEspectaculo = idEspectaculo;
	}

	/**
	 * @return the dniEntrada
	 */
	public String getDniEntrada() {
		return dniEntrada;
	}

	/**
	 * @param dniEntrada the dniEntrada to set
	 */
	public void setDniEntrada(String dniEntrada) {
		this.dniEntrada = dniEntrada;
	}

	/**
	 * @return the fecha
	 */
	public LocalDate getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
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

	
	
	
}
