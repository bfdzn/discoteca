package modelos;

import java.time.LocalDate;


public class Entradas {
	
	private int numEntrada;
	private int idEspectaculo;
	private String dniEntrada;
	private LocalDate fecha;
	private String vendedor;
	
	
	
	public Entradas(int numEntrada,int idEspectaculo, String dniEntrada, LocalDate fecha, String vendedor) {
		
		super();
		this.numEntrada=numEntrada;
		this.idEspectaculo = idEspectaculo;
		this.dniEntrada = dniEntrada;
		this.fecha = fecha;
		this.vendedor = vendedor;
		
	}

	public int getNumEntrada() {
		return numEntrada;
	}
	
	public void setNumEntrada(int numEntrada) {
		this.numEntrada = numEntrada;
	}
	
	public int getIdEspectaculo() {
		return idEspectaculo;
	}
	
	public void setIdEspectaculo(int idEspectaculo) {
		this.idEspectaculo = idEspectaculo;
	}
	
	public String getDniEntrada() {
		return dniEntrada;
	}
	
	public void setDniEntrada(String dniEntrada) {
		this.dniEntrada = dniEntrada;
	}
	
	public LocalDate getFecha() {
		return fecha;
	}
	
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	public String getVendedor() {
		return vendedor;
	}
	
	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}

	
	
}
