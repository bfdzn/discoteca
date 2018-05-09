package modelos;

import java.time.LocalDate;

public class Entradas {
	
	private int numEntrada;
	private String dniEntrada;
	private int idEspectaculo;
	private LocalDate fecha;
	private String vendedor;
	
	
	public Entradas(int numEntrada, String dniEntrada, int idEspectaculo, LocalDate fecha, String vendedor) {
		super();
		this.numEntrada = numEntrada;
		this.dniEntrada = dniEntrada;
		this.idEspectaculo = idEspectaculo;
		this.fecha = fecha;
		this.vendedor = vendedor;
	}


	

}
