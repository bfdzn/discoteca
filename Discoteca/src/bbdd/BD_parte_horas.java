/*Tom�s Gonz�lvez*/

package bbdd;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.Date;

import modelos.ParteHoras;
import modelos.Reserva_sala;;



public class BD_parte_horas extends BD_Conector{
	
	
	
	private static Statement s;	
	private static ResultSet reg;
	
	public BD_parte_horas(String fileName) {
		super(fileName);
		// TODO Auto-generated constructor stub
	}
	
	
	
	public int a�adir_parte_horas (String vendedor,LocalDate fecha,int horas,Double salario) {
		
		
		
		String cadenaSQL="INSERT INTO parte_horas2 VALUES('" + vendedor + "','" +  fecha.getYear() + "-" + fecha.getMonthValue() + "-"
		  + fecha.getDayOfMonth() + "','" + 	horas + "','" + salario + "')";
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
	

	
	
	public  Vector<ParteHoras> Listar_parte_horas_dni(String dni){
		String cadenaSQL="SELECT * from parte_horas2 ";
		Vector<ParteHoras> lista_parte_horas=new Vector<ParteHoras>();
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			
			while ( reg.next()){
				java.sql.Date f1=reg.getDate("FECHA");
				LocalDate fecha1=f1.toLocalDate();
				if(reg.getString("DNI_EMPLEADO").equals(dni)) {
				lista_parte_horas.add(new ParteHoras(reg.getString("DNI_EMPLEADO"),
						fecha1,reg.getInt("HORAS"),reg.getDouble("PRECIO")));
				}

				}
			s.close();
			this.cerrar();
			return lista_parte_horas;
		}
		catch ( SQLException e){		
			return null;			
		}
	}
	
	
	public  Vector<ParteHoras> Listar_parte_horas_fecha(Date fecha){
		String cadenaSQL="SELECT * from parte_horas2 ";
		Vector<ParteHoras> lista_parte_horas=new Vector<ParteHoras>();
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			
			while ( reg.next()){
				java.sql.Date f1=reg.getDate("FECHA");
				LocalDate fecha1=f1.toLocalDate();
				if(reg.getDate("FECHA").compareTo(fecha)==0) {
				lista_parte_horas.add(new ParteHoras(reg.getString("DNI_EMPLEADO"),
						fecha1,reg.getInt("HORAS"),reg.getDouble("PRECIO")));
				}

				}
			s.close();
			this.cerrar();
			return lista_parte_horas;
		}
		catch ( SQLException e){		
			return null;			
		}
	}


}