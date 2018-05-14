package bbdd;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import modelos.Espectaculos;

public class BD_Espectaculos extends BD_Conector {
	private static Statement s;	
	private static ResultSet reg;
	

	public BD_Espectaculos(String fileName) {
		super(fileName);
		// TODO Auto-generated constructor stub
	}



	public  int añadir_Espectaculo( Espectaculos espectaculo){	
		String cadenaSQL="INSERT INTO ESPECTACULOS VALUES('" + espectaculo.getIdEspectaculo() + "','" +
				espectaculo.getNombreEspectaculo() + "','" + espectaculo.getFechaInicio() + "','" + espectaculo.getFechaFin() + "','" + espectaculo.getAforo() + "')"; 
		
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
	
	
	public int borrar_Espectaculo (Espectaculos espectaculo) {
		
		String cadenaSQL="DELETE FROM ESPECTACULOS WHERE  idespectaculo= ' " + espectaculo.getIdEspectaculo() + "'";
		
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
	
	public String buscarEspectaculo (Espectaculos espectaculo) {
		
		String cadena="SELECT * FROM ESPECTACULOS2 WHERE idespectaculo = ' " +espectaculo.getIdEspectaculo() + " ' ";
		
		try{
			String t="";
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadena);
			if ( reg.next())							
				t= reg.getString(1);							
			s.close();
			this.cerrar();
			return t;
		}
		catch ( SQLException e){
	
			return null;
			
		}
	}
	
	public int modificar_FechaEspectaculo(Espectaculos espectaculo,LocalDate fechaInicio, LocalDate fechaFin) {
		String cadenaSQL="UPDATE ESPECTACULOS2 SET fecha_inicion ='"+ fechaInicio + "','"+ "fecha_fin= '" + fechaFin + "'  WHERE idespectaculo = ' " + espectaculo.getIdEspectaculo() + " ' ";
		
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
	
}
