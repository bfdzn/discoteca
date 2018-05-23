package modelos;

import java.time.LocalDate;



// TODO: Auto-generated Javadoc
/**
 * The Class Entradas.
 * La clase de entradas
 */
public class Entradas {
	
	/** The num entrada. */
	private int numEntrada;
	
	/** The id espectaculo. */
	private int idEspectaculo;
	
	/** The dni entrada. */
	private String dniEntrada;
	
	/** The fecha. */
	private LocalDate fecha;
	
	/** The vendedor. */
	private String vendedor;
	
	/**
	 * Constructor para Entradas.
	 *
	 * @param numEntrada the num entrada
	 * @param idEspectaculo the id espectaculo
	 * @param dniEntrada the dni entrada
	 * @param fecha the fecha
	 * @param vendedor the vendedor
	 */
	
	/**
	 * Instantiates a new entradas.
	 *
	 * @param numEntrada the num entrada
	 * @param idEspectaculo the id espectaculo
	 * @param dniEntrada the dni entrada
	 * @param fecha the fecha
	 * @param vendedor the vendedor
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
	 * Gets the num entrada.
	 *
	 * @return the num entrada
	 */
	public int getNumEntrada() {
		return numEntrada;
	}
	
	/**
	 * Sets the num entrada.
	 *
	 * @param numEntrada the numEntrada to set
	 */
	public void setNumEntrada(int numEntrada) {
		this.numEntrada = numEntrada;
	}
	/**
	 * Gets the id espectaculo.
	 *
	 * @return the idEspectaculo
	 */
	public int getIdEspectaculo() {
		return idEspectaculo;
	}
	
	/**
	 * Sets the id espectaculo.
	 *
	 * @param idEspectaculo the idEspectaculo to set
	 */
	public void setIdEspectaculo(int idEspectaculo) {
		this.idEspectaculo = idEspectaculo;
	}

	/**
	 * Gets the dni entrada.
	 *
	 * @return the dniEntrada
	 */
	public String getDniEntrada() {
		return dniEntrada;
	}
	
	/**
	 * Sets the dni entrada.
	 *
	 * @param dniEntrada the dniEntrada to set
	 */
	public void setDniEntrada(String dniEntrada) {
		this.dniEntrada = dniEntrada;
	}

	/**
	 * Gets the fecha.
	 * @return the fecha
	 */
	public LocalDate getFecha() {
		return fecha;
	}

	/**
	 * Sets the fecha.
	 *
	 * @param fecha the fecha to set
	 */
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	/**
	 * Gets the vendedor.
	 * @return the vendedor
	 */
	public String getVendedor() {
		return vendedor;
	}

	
	/**
	 * Sets the vendedor.
	 *
	 * @param vendedor the vendedor to set
	 */
	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}

	
	
	
}
