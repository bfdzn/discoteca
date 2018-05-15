package bbdd;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

import modelos.Admin;
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
		
		String cadenaSQL="DELETE FROM espectaculos2 WHERE  idespectaculo= ' " + espectaculo.getIdEspectaculo() + "'";
		
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
	
	public  int buscarFecha(LocalDate fechaInicio, LocalDate fechaFin){
		String cadenaSQL="SELECT FECHA_INICIO, FECHA_FIN from espectaculos2";
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			while ( reg.next()){
				java.sql.Date f=reg.getDate("FECHA_INICIO");
				LocalDate fecha1=f.toLocalDate();
				java.sql.Date f2=reg.getDate("FECHA_FIN");
				LocalDate fecha2=f2.toLocalDate();
				if((fecha1.isBefore(fechaInicio) && fecha2.isAfter(fechaInicio)) || (fechaFin.isAfter(fecha1)) || fecha1.equals(fechaInicio) ) {
					return 0;
				
				}
			}
			s.close();
			this.cerrar();
			return 1;
		}
		catch ( SQLException e){		
			return 2;			
		}
	}
	public Vector<Espectaculos> listarEspectaculos () {
		
		String cadena="SELECT * FROM espectaculos2 ";
		Vector<Espectaculos> listaEspectaculos=new Vector<Espectaculos>();

		try{
			Espectaculos espectaculoBuscar=null;
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadena);
			while ( reg.next()) {	
				
				java.sql.Date f=reg.getDate("FECHA_INICIO");
				LocalDate fecha1=f.toLocalDate();
				java.sql.Date f2=reg.getDate("FECHA_FIN");
				LocalDate fecha2=f2.toLocalDate();
				
				espectaculoBuscar = new Espectaculos(reg.getInt("IDESPECTACULO"), reg.getString("NOMBRE"),fecha1,fecha2);	
				listaEspectaculos.add(espectaculoBuscar);
			}
			s.close();
			this.cerrar();
			return listaEspectaculos;
		}
		catch ( SQLException e){
	
			return null;
			
		}
	}
	
	
	public Espectaculos buscarEspectaculo (int espectaculo) {
		
		String cadena="SELECT * FROM espectaculos2 WHERE idespectaculo = ' " +espectaculo + " ' ";
		
		try{
			Espectaculos espectaculoBuscar=null;
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadena);
			if ( reg.next()) {	
				
				java.sql.Date f=reg.getDate("FECHA_INICIO");
				LocalDate fecha1=f.toLocalDate();
				java.sql.Date f2=reg.getDate("FECHA_FIN");
				LocalDate fecha2=f2.toLocalDate();
				
				espectaculoBuscar = new Espectaculos(reg.getInt("IDESPECTACULO"), reg.getString("NOMBRE"),fecha1,fecha2);	
			}
			s.close();
			this.cerrar();
			return espectaculoBuscar;
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
