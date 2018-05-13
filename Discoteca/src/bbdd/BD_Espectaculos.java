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





	public  int añadir_Cliente( Espectaculos espectaculo){	
		String cadenaSQL="INSERT INTO CLIENTES2 VALUES('" + espectaculo.getIdEspectaculo() + "','" +
				espectaculo.getNombreEspectaculo() + "','" + espectaculo.getFechaInicio() + "','" + espectaculo.getFechaFin() + "')"; 	
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
