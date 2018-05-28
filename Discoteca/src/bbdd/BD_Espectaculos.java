//Samuel de la torre
package bbdd;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

import excepciones.EspectaculoNoExiste;
import modelos.Admin;
import modelos.Espectaculos;

// TODO: Auto-generated Javadoc
/**
 * The Class BD_Espectaculos.
 * La clase que conecta la bbdd a los espectáculos
 */
public class BD_Espectaculos extends BD_Conector {

	/** The s. */
	private static Statement s;

	/** The reg. */
	private static ResultSet reg;

	/**
	 * Instantiates a new b D espectaculos.
	 *
	 * @param fileName
	 *            the file name
	 */
	public BD_Espectaculos(String fileName) {
		super(fileName);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Añadir espectaculo.
	 * metodo que añade espectaculos en la bbdd
	 * @param espectaculo se trata del espectáculo que vamos a añadir a la bbdd
	 *            
	 * @return devuelve un int que es -1 en caso de que la bbdd tenga un error o 1 si añade el empleado
	 */
	public int añadir_Espectaculo(Espectaculos espectaculo) {
		String cadenaSQL = "INSERT INTO ESPECTACULOS2 VALUES('" + espectaculo.getIdEspectaculo() + "','"
				+ espectaculo.getNombreEspectaculo() + "','" + espectaculo.getFechaInicio() + "','"
				+ espectaculo.getFechaFin() + "','" + espectaculo.getPrecioEntrada() + "','" + espectaculo.getAforo()
				+ "')";
		System.out.println(cadenaSQL);
		try {
			this.abrir();
			s = c.createStatement();
			int filas = s.executeUpdate(cadenaSQL);
			s.close();
			this.cerrar();
			return filas;
		} catch (SQLException e) {
			System.err.println(e);
			return -1;
		}
	}

	/**
	 * Borrar espectaculo.
	 *
	 * @param espectaculo se le pasa un espectáculo
	 * @return devuelve un int que nos dirá se si ha borrado o no de la bbdd
	 * @deprecated se trata de un metodo que no estamos utilizando para no violar la integridad de la tabla
	 */
	public int borrar_Espectaculo(Espectaculos espectaculo) {

		String cadenaSQL = "DELETE FROM espectaculos2 WHERE  idespectaculo= ' " + espectaculo.getIdEspectaculo() + "'";

		try {
			this.abrir();
			s = c.createStatement();
			int filas = s.executeUpdate(cadenaSQL);
			s.close();
			this.cerrar();
			return filas;
		} catch (SQLException e) {
			System.err.println(e);
			return -1;

		}
	}

	/**
	 * Buscar fecha.
	 * Se trata de un metodo cuya función es buscar que los espectáculos no se solapen en el tiempo.
	 *
	 * @param fechaInicio del espectaculo
	 * @param fechaFin del espectáculo
	 * @return si retorna 0 hay espectáculos que se solapan, si retorna 1 hay hueco, si retorna 2 hay un error en la bbdd
	 */
	public int buscarFecha(LocalDate fechaInicio, LocalDate fechaFin) {
		String cadenaSQL = "SELECT FECHA_INICIO, FECHA_FIN from espectaculos2";
		try {
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);
			while (reg.next()) {
				java.sql.Date f = reg.getDate("FECHA_INICIO");
				LocalDate fecha1 = f.toLocalDate();
				java.sql.Date f2 = reg.getDate("FECHA_FIN");
				LocalDate fecha2 = f2.toLocalDate();
				if ((fechaInicio.isAfter(fecha1) && fechaInicio.isBefore(fecha2))
						|| (fechaInicio.isAfter(fecha1) && fechaInicio.isBefore(fecha2))) {
					return 0;

				}else if(fechaInicio.equals(fecha2) || fechaInicio.equals(fecha1) || fechaFin.equals(fecha1) || fechaFin.equals(fecha2)){
					return 0;
				}
			}
			s.close();
			this.cerrar();
			return 1;
		} catch (SQLException e) {
			return 2;
		}
	}

	/**
	 * Listar espectaculos.
	 * Se trata de un metodo que lista todos los espectaculos
	 *
	 * @return retorna un vector con todos los espectáculos
	 */
	public Vector<Espectaculos> listarEspectaculos() {

		String cadena = "SELECT * FROM espectaculos2 ";
		Vector<Espectaculos> listaEspectaculos = new Vector<Espectaculos>();

		try {
			Espectaculos espectaculoBuscar = null;
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadena);
			while (reg.next()) {

				java.sql.Date f = reg.getDate("FECHA_INICIO");
				LocalDate fecha1 = f.toLocalDate();
				java.sql.Date f2 = reg.getDate("FECHA_FIN");
				LocalDate fecha2 = f2.toLocalDate();

				espectaculoBuscar = new Espectaculos(reg.getInt("IDESPECTACULO"), reg.getString("NOMBRE"), fecha1,
						fecha2, reg.getDouble("PRECIO_ENTRADA"), reg.getInt("AFORO"));
				listaEspectaculos.add(espectaculoBuscar);
			}
			s.close();
			this.cerrar();
			return listaEspectaculos;
		} catch (SQLException e) {

			return null;

		}
	}

	/**
	 * Buscar precio.
	 *
	 * @param espectaculo es el idEspectaculo 
	 * @return the double precio del espectaculo
	 * @throws EspectaculoNoExiste si el espectaculo no existe
	 *             
	 */
	public double buscarPrecio(int espectaculo) throws EspectaculoNoExiste {

		String cadena = "SELECT * FROM espectaculos2 WHERE idespectaculo = ' " + espectaculo + " ' ";

		try {
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadena);
			if (reg.next()) {
				double precio = reg.getDouble("PRECIO_ENTRADA");
				return precio;

			}
			s.close();
			this.cerrar();
			throw new EspectaculoNoExiste("El espectáculo no existe en la BBDD");
		} catch (SQLException e) {

			return -1;

		}
	}

	/**
	 * Buscar max.
	 * metodo que busca el máximo valor de idespectaculos de la bbdd
	 * @return un int que será utilizado como primary key
	 */
	public int buscarMax(){

		String cadena = "SELECT MAX(IDESPECTACULO) id FROM espectaculos2 ";
		int id = 0;
		try {
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadena);
			if (reg.next()) {
				id = reg.getInt("id");
				return id;

			}
			s.close();
			this.cerrar();
			return 0;
		} catch (SQLException e) {

			return -1;

		}
	}

	/**
	 * Buscar espectaculo.
	 *
	 * @param espectaculo id de espectaculo
	 * @return buscarEspectaculo el objeto espectaculo con esa idespectaculo
	 * @throws EspectaculoNoExiste si el espectaculo no existe
	 *             the espectaculo no existe
	 */
	public Espectaculos buscarEspectaculo(int espectaculo) throws EspectaculoNoExiste {

		String cadena = "SELECT * FROM espectaculos2 WHERE idespectaculo = ' " + espectaculo + " ' ";

		try {
			Espectaculos espectaculoBuscar = null;
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadena);
			if (reg.next()) {

				java.sql.Date f = reg.getDate("FECHA_INICIO");
				LocalDate fecha1 = f.toLocalDate();
				java.sql.Date f2 = reg.getDate("FECHA_FIN");
				LocalDate fecha2 = f2.toLocalDate();
				espectaculoBuscar = new Espectaculos(reg.getInt("IDESPECTACULO"), reg.getString("NOMBRE"), fecha1,
						fecha2, reg.getDouble("PRECIO_ENTRADA"), (reg.getInt("AFORO")));
				return espectaculoBuscar;
			}
			s.close();
			this.cerrar();
			throw new EspectaculoNoExiste("El espectáculo no existe en la BBDD");
		} catch (SQLException e) {

			return null;

		}
	}

	/**
	 * Modificar fecha espectaculo.
	 *
	 * @param espectaculo the espectaculo
	 * @param fechaInicio fechaInicio del espectaculo
	 * @param fechaFin fechaFin del espectaculo
	 * @return the int
	 * @deprecated no se está utilizando
	 */
	public int modificar_FechaEspectaculo(Espectaculos espectaculo, LocalDate fechaInicio, LocalDate fechaFin) {
		String cadenaSQL = "UPDATE ESPECTACULOS2 SET fecha_inicion ='" + fechaInicio + "','" + "fecha_fin= '" + fechaFin
				+ "'  WHERE idespectaculo = ' " + espectaculo.getIdEspectaculo() + " ' ";

		try {
			this.abrir();
			s = c.createStatement();
			int filas = s.executeUpdate(cadenaSQL);
			s.close();
			this.cerrar();
			return filas;
		} catch (SQLException e) {
			return -1;

		}
	}

}
