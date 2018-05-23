/*Tomás Gonzálvez*/

package bbdd;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.WRITE;

import java.io.BufferedWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
 * conecta la clase parte_horas con la base de datos
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
	 * añade un parte de horas en la base
	 * @param dni del empleado
	 * @param fecha en la que se realiza el parte de horas
	 * @param horas número de horas que ha trabajado
	 * @param precioHoras el precio hora que recibe
	 * @return the int devuelve un valor dependiendo de lo que añada en la bbdd
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
	 * devuelve un vector con los partes de horas de un empleado
	 * @param dni del empleado
	 * @return vector de ParteHoras
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
	 * @param anoMes año y mes a listar
	 * @param dni del empleado
	 * @return array en el que la posición 0 corresponde con el importe total a cobrar y la dos las horas totales trabajadas
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
	 * Generar texto.
	 * Genera un txt de un mes específico 
	 * @param anoFecha año y mes del que se quiere generar un txt
	 */
	public void generarTexto (String anoFecha) {
		String cadenaSQL="SELECT sum(salario) importe, sum(horas) horaT, dni_empleado "
				+ "FROM `parte_horas2` where DATE_FORMAT(FECHA,'%m%Y') = '"+anoFecha+"' group by dni_empleado";
		String [] meses = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
		Charset charset = Charset.forName("UTF-8");
		String ruta = meses[Integer.parseInt(anoFecha.substring(0,2))-1]+".txt";
		Path p = Paths.get(ruta);

		
		
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			BufferedWriter writer = Files.newBufferedWriter(p, charset);
			String linea = "";
			linea = "En el mes de "+meses[Integer.parseInt(anoFecha.substring(0,2))-1]+" se debe este dinero: ";
			writer.write(linea);
			writer.newLine();
			writer.newLine();
			while ( reg.next()){
				linea = "Al empleado con dni "+reg.getString("dni_empleado")+" se le debe "+reg.getDouble("importe")+
						" por estas horas: "+reg.getInt("horaT");
				writer.write(linea);
				writer.newLine();
				}
			writer.close();
			s.close();
			this.cerrar();
	
		}
		catch ( Exception e){	
			System.err.println(e);
					
		}

	}
	

	
	
	/**
	 * Listar parte horas fecha.
	 *devuelve un parte de horas asociado a una fecha
	 * @param fecha la fecha utilizada
	 * @return vector con parte de horas 
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