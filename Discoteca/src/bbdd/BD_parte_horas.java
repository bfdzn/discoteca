/*Tomás Gonzálvez*/

package bbdd;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.Date;

import modelos.ParteHoras;
import modelos.Reserva_sala;;



// TODO: Auto-generated Javadoc
/**
 * The Class BD_parte_horas.
 */
public class BD_parte_horas extends BD_Conector{
	
	
	
	/** The s. */
	private static Statement s;	
	
	/** The reg. */
	private static ResultSet reg;
	
	/**
	 * Instantiates a new b D parte horas.
	 *
	 * @param fileName the file name
	 */
	public BD_parte_horas(String fileName) {
		super(fileName);
		// TODO Auto-generated constructor stub
	}
	
	
	
	/**
	 * Añadir parte horas.
	 *
	 * @param dni the dni
	 * @param fecha the fecha
	 * @param horas the horas
	 * @param precioHoras the precio horas
	 * @return the int
	 */
	public int añadir_parte_horas (String dni,LocalDate fecha,int horas,Double precioHoras) {
		double importe = horas*precioHoras;
		
		
		String cadenaSQL="INSERT INTO parte_horas2 VALUES('" + dni + "','" +  fecha.getYear() + "-" + fecha.getMonthValue() + "-"
		  + fecha.getDayOfMonth() + "','" + 	horas + "','" + importe + "')";
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
	
	/**
	 * Listar parte horas dni.
	 *
	 * @param dni the dni
	 * @return the vector
	 */
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
						fecha1,reg.getInt("HORAS"),reg.getDouble("IMPORTE")));
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

	/**
	 * Listar parte horas mes dni.
	 *
	 * @param anoMes the ano mes
	 * @param dni the dni
	 * @return the vector
	 */
	public  double[] Listar_parte_horas_mes_dni(String anoMes, String dni){
		String cadenaSQL="SELECT sum(salario) importe, sum(horas) horaT FROM `parte_horas2` where DATE_FORMAT(FECHA,'%m%Y') = '"+anoMes+"' and DNI_EMPLEADO = '"+dni+"'";
		double [] importes = new double[2] ;
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			
			while ( reg.next()){
				importes[0] = reg.getDouble("importe");
				importes[1] = reg.getDouble("horaT");
				}
			s.close();
			this.cerrar();
			return importes;
		}
		catch ( SQLException e){	
			System.err.println(e);
			return null;			
		}
	}
	

	
	
	/**
	 * Listar parte horas fecha.
	 *
	 * @param fecha the fecha
	 * @return the vector
	 */
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
						fecha1,reg.getInt("HORAS"),reg.getDouble("IMPORTE")));
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