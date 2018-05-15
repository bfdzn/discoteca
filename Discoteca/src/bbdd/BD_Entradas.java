package bbdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import modelos.Entradas;

public class BD_Entradas extends BD_Conector {
	private static Statement s;	
	private static ResultSet reg;
	
	
	public BD_Entradas(String fileName) {
		super(fileName);
		// TODO Auto-generated constructor stub
	}
	
	public int añadir_Entrada (Entradas entrada)
	{
		String cadenaSQL="INSERT INTO ESPECTACULOS VALUES('"+ entrada.getNumEntrada() +  "','" + entrada.getDniEntrada() + "','" + entrada.getIdEspectaculo() +
				 "','" + entrada.getFecha() +  "','" + entrada.getVendedor() + "')";
		
		try{
			this.abrir();
			s=c.createStatement();
			int filas=s.executeUpdate(cadenaSQL);
			s.close();
			this.cerrar();
			return filas;
			}
			catch ( SQLException e){			
				return -1;
			}
	}
	
	public int borrar_Entrada (Entradas entrada) {
		String cadenaSQL="DELETE FROM ENTRADAS2 WHERE idEspectaculo = ' "+ entrada.getIdEspectaculo() + "'";
		
		try{
			this.abrir();
			s=c.createStatement();
			int filas=s.executeUpdate(cadenaSQL);
			s.close();
			this.cerrar();
			return filas;
			}
			catch ( SQLException e){			
				System.err.println(e);
				return -1;
			
		
			}
	}
	
}
