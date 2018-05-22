package modelos;

import java.time.LocalDate;


// TODO: Auto-generated Javadoc
/**
 * The Class Entradas.
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
	 * @param numEntrada the new num entrada
	 */
	public void setNumEntrada(int numEntrada) {
		this.numEntrada = numEntrada;
	}
	
	/**
	 * Gets the id espectaculo.
	 *
	 * @return the id espectaculo
	 */
	public int getIdEspectaculo() {
		return idEspectaculo;
	}
	
	/**
	 * Sets the id espectaculo.
	 *
	 * @param idEspectaculo the new id espectaculo
	 */
	public void setIdEspectaculo(int idEspectaculo) {
		this.idEspectaculo = idEspectaculo;
	}
	
	/**
	 * Gets the dni entrada.
	 *
	 * @return the dni entrada
	 */
	public String getDniEntrada() {
		return dniEntrada;
	}
	
	/**
	 * Sets the dni entrada.
	 *
	 * @param dniEntrada the new dni entrada
	 */
	public void setDniEntrada(String dniEntrada) {
		this.dniEntrada = dniEntrada;
	}
	
	/**
	 * Gets the fecha.
	 *
	 * @return the fecha
	 */
	public LocalDate getFecha() {
		return fecha;
	}
	
	/**
	 * Sets the fecha.
	 *
	 * @param fecha the new fecha
	 */
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
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

	
	
}
