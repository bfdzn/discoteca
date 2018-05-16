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
		String cadenaSQL="INSERT INTO entradas2 VALUES('"+ entrada.getNumEntrada() +  "','" + entrada.getDniEntrada() + "','" + entrada.getIdEspectaculo() +
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
	
	public int numeroEntrada(Entradas entrada)
	{
		String cadenaSQL="SELECT MAX(NUMENTRADA) FROM ENTRADAS WHERE idEspectaculo ='"+ entrada.getIdEspectaculo() + "'";
		try{
			int maxEntrada=0;
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			if ( reg.next()) {
				maxEntrada=reg.getInt("NUMENTRADA");
			}
			s.close();
			this.cerrar();
			return maxEntrada;
	}catch ( SQLException e){
		return -1;		
	}
	}
	
}
