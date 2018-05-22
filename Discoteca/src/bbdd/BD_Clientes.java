package bbdd;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

import modelos.*;


public class BD_Clientes extends BD_Conector{
	
	private static Statement s;	
	private static ResultSet reg;
	
	public BD_Clientes(String fileName) {
		super(fileName);
		// TODO Auto-generated constructor stub
	}
	/**
	 * Añade un cliente a la bbdd
	 * @param cliente
	 * @return
	 */
	public  int añadir_Cliente( Clientes cliente){	
		String cadenaSQL="INSERT INTO CLIENTES2 VALUES('" + cliente.getDni() + "','" +
		cliente.getFechaNacimiento()+"')"; 	
		
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
	/**
	 * Busca un cliente dado su dni
	 * @param dni
	 * @return
	 */
	public Clientes buscarCliente(String dni){
		String cadenaSQL="SELECT * from clientes2 WHERE DNI_CLIENTE='"+dni+"'";
		Clientes retorno = null;
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			while ( reg.next()){
				if(!(reg.getString("DNI_CLIENTE").equalsIgnoreCase(dni))) {
					return null;
				}
				java.sql.Date f=reg.getDate("FECHA_NACIMIENTO");
				LocalDate fBuena=f.toLocalDate();
				retorno = new Clientes(reg.getString("DNI_CLIENTE"),fBuena);
			}
			s.close();
			this.cerrar();
			return retorno;
		}
		catch ( SQLException e){		
			return null;			
		}
	}
	/**
	 * Retorna un listado con todos los clientes
	 * @return
	 */
	public  Vector<Clientes> listadoClientes(){
		String cadenaSQL="SELECT * from CLIENTES2";
		Vector<Clientes> listaClientes=new Vector<Clientes>();
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			while ( reg.next()){
				// La fecha que se extrae de la bbdd es sql.Date, hay que transformarla a LocalDate
				java.sql.Date f=reg.getDate("FECHA_NACIMIENTO");
				LocalDate fBuena=f.toLocalDate();
				listaClientes.add(new Clientes(reg.getString("dni"),fBuena));
				
			}
			s.close();
			this.cerrar();
			return listaClientes;
		}
		catch ( SQLException e){		
			return null;			
		}
	}

}
