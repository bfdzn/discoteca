/*Tomás gonzálvez*/

package bbdd;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

import modelos.Reserva_sala;;



// TODO: Auto-generated Javadoc
/**
 * The Class BD_reserva_sala.
 */
public class BD_reserva_sala extends BD_Conector{
	
	/** The s. */
	private static Statement s;	
	
	/** The reg. */
	private static ResultSet reg;
	
	/**
	 * Instantiates a new b D reserva sala.
	 *
	 * @param fileName the file name
	 */
	public BD_reserva_sala(String fileName) {
		super(fileName);
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	/**
	 * Listar reserva.
	 *
	 * @return the vector
	 */
	public  Vector<Reserva_sala> Listar_reserva(){
		String cadenaSQL="SELECT * from reserva_sala2 ";
		Vector<Reserva_sala> lista_reservas=new Vector<Reserva_sala>();
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			while ( reg.next()){
				// La fecha que se extrae de la bbdd es sql.Date, hay que transformarla a LocalDate
				java.sql.Date f1=reg.getDate("FECHA_INICIO");
				LocalDate fecha1=f1.toLocalDate();
				java.sql.Date f2=reg.getDate("FECHA_FIN");
				LocalDate fecha2=f2.toLocalDate();
				lista_reservas.add(new Reserva_sala(reg.getString("VENDEDOR"),
						fecha1,fecha2,reg.getString("DNI_CLIENTE"),reg.getInt("IDESPECTACULO"),reg.getInt("PRECIO")));

				
			}
			s.close();
			this.cerrar();
			return lista_reservas;
		}
		catch ( SQLException e){		
			return null;			
		}
	}
	
	/**
	 * Ultima reserva.
	 *
	 * @return the int
	 */
	public int Ultima_reserva() {
		Vector <Reserva_sala> auxiliar = Listar_reserva();
		for(int i=0;i<auxiliar.size();i++) {
			if(i==(auxiliar.size()-1)) {
				return auxiliar.get(i).getId_espectaculo();
			}
		}
		return 0;
	}
	
	
	/**
	 * Añadir reserva.
	 *
	 * @param fecha1 the fecha 1
	 * @param fecha2 the fecha 2
	 * @param dniv the dniv
	 * @param dnic the dnic
	 * @return the int
	 */
	public int añadir_reserva (LocalDate fecha1,LocalDate fecha2,String dniv,String dnic) {
		
		
		Reserva_sala c1 = new Reserva_sala (fecha1,fecha2,dniv,dnic);
		
		String cadenaSQL="INSERT INTO reserva_sala2 VALUES('" + c1.getId_espectaculo() + "','" +  c1.getVendedor() + "','" + 
	c1.getFecha_inicio().getYear() + "-" + c1.getFecha_inicio().getMonthValue() + "-" + c1.getFecha_inicio().getDayOfMonth() + 
	"','" + c1.getFecha_fin().getYear() + "-" + c1.getFecha_fin().getMonthValue() + "-" + c1.getFecha_fin().getDayOfMonth() +  "','" + c1.getPrecio() +  "','" + c1.getDni_cliente() + "')";
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
	 * Esta libre.
	 *
	 * @return true, if successful
	 */
	public boolean esta_libre () {
		LocalDate fechaActual = LocalDate.now();
		BD_reserva_sala bd=new BD_reserva_sala("prueba.txt");
		int id = bd.Ultima_reserva();
		Vector<Reserva_sala> vectorr = bd.Listar_reserva();
		for(int i=0;i<vectorr.size();i++) {
			if(id == vectorr.get(i).getId_espectaculo()) {
				int dias = vectorr.get(i).getFecha_fin().compareTo(fechaActual);
				if(dias>0) {
					return false;
					
				}
				
			}
		}
		return true;
	}
	
	
}