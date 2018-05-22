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
	 *
	 * @param espectaculo
	 *            the espectaculo
	 * @return the int
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
	 * @param espectaculo
	 *            the espectaculo
	 * @return the int
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
	 *
	 * @param fechaInicio
	 *            the fecha inicio
	 * @param fechaFin
	 *            the fecha fin
	 * @return the int
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
	 *
	 * @return the vector
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
	 * @param espectaculo
	 *            the espectaculo
	 * @return the double
	 * @throws EspectaculoNoExiste
	 *             the espectaculo no existe
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
	 * @param espectaculo
	 *            the espectaculo
	 * @return the espectaculos
	 * @throws EspectaculoNoExiste
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
	 * @param espectaculo
	 *            the espectaculo
	 * @param fechaInicio
	 *            the fecha inicio
	 * @param fechaFin
	 *            the fecha fin
	 * @return the int
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
