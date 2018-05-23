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
 * Es la clase que conecta la reserva_sala a la bbdd
 */
public class BD_reserva_sala extends BD_Conector {

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
	 * @return todas las reservas en un vector
	 */
	public Vector<Reserva_sala> Listar_reserva() {
		String cadenaSQL = "SELECT * from reserva_sala2 ";
		Vector<Reserva_sala> lista_reservas = new Vector<Reserva_sala>();
		try {
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);
			while (reg.next()) {
				// La fecha que se extrae de la bbdd es sql.Date, hay que transformarla a
				// LocalDate
				java.sql.Date f1 = reg.getDate("FECHA_INICIO");
				LocalDate fecha1 = f1.toLocalDate();
				java.sql.Date f2 = reg.getDate("FECHA_FIN");
				LocalDate fecha2 = f2.toLocalDate();
				lista_reservas.add(
						new Reserva_sala(fecha1, fecha2, reg.getString("VENDEDOR"), reg.getString("DNI_CLIENTE")));

			}
			s.close();
			this.cerrar();
			return lista_reservas;
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}
	}

	/**
	 * Ultima reserva.
	 * devuelve la fecha de la última reserva
	 * @return LocalDate de la última reserva
	 */
	public LocalDate Ultima_reserva() {
		Vector<Reserva_sala> auxiliar = Listar_reserva();
		for (int i = 0; i < auxiliar.size(); i++) {
			if (i == (auxiliar.size() - 1)) {
				return auxiliar.get(i).getFecha_inicio();
			}
		}
		return null;
	}

	/**
	 * Añadir reserva.
	 * añade la reserva
	 * @param c1 es un objeto reserva_sala
	 * @return the int dependiendo del comportamiento de la bbdd
	 */
	public int añadir_reserva(Reserva_sala c1) {
		String cadenaSQL = null;
		if(!(c1.getVendedor()==null)) {
		 cadenaSQL = "INSERT INTO reserva_sala2 VALUES('" + c1.getVendedor() + "','"
				+ c1.getFecha_inicio().getYear() + "-" + c1.getFecha_inicio().getMonthValue() + "-"
				+ c1.getFecha_inicio().getDayOfMonth() + "','" + c1.getFecha_fin().getYear() + "-"
				+ c1.getFecha_fin().getMonthValue() + "-" + c1.getFecha_fin().getDayOfMonth() + "','" + c1.getPrecio()
				+ "','" + c1.getDni_cliente() + "')";
		}else {
		 cadenaSQL = "INSERT INTO reserva_sala2 VALUES( null,'"
					+ c1.getFecha_inicio().getYear() + "-" + c1.getFecha_inicio().getMonthValue() + "-"
					+ c1.getFecha_inicio().getDayOfMonth() + "','" + c1.getFecha_fin().getYear() + "-"
					+ c1.getFecha_fin().getMonthValue() + "-" + c1.getFecha_fin().getDayOfMonth() + "','" + c1.getPrecio()
					+ "','" + c1.getDni_cliente() + "')";
		}
		try {
			this.abrir();
			s = c.createStatement();
			int filas = s.executeUpdate(cadenaSQL);
			s.close();
			this.cerrar();
			return filas;
		} catch (SQLException e) {
			System.out.println(e);
			return -1;
		}
	}

	/**
	 * Esta libre.
	 *
	 * @return true, si la sala está libre
	 */
	public boolean esta_libre() {
		LocalDate fechaActual = LocalDate.now();
		BD_reserva_sala bd = new BD_reserva_sala("mysql-properties.xml");
		LocalDate id = bd.Ultima_reserva();
		Vector<Reserva_sala> vectorr = bd.Listar_reserva();
		for (int i = 0; i < vectorr.size(); i++) {
			if (id.equals(vectorr.get(i).getFecha_inicio())) {
				int dias = vectorr.get(i).getFecha_fin().compareTo(fechaActual);
				if (dias > 0) {
					return false;

				}

			}
		}
		return true;
	}

}