package bbdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Vector;

import modelos.Entradas;
import modelos.ParteHoras;

// TODO: Auto-generated Javadoc
/**
 * The Class BD_Entradas.
 */
public class BD_Entradas extends BD_Conector {

	/** The s. */
	private static Statement s;

	/** The reg. */
	private static ResultSet reg;

	/**
	 * Instantiates a new b D entradas.
	 *
	 * @param fileName
	 *            the file name
	 */
	public BD_Entradas(String fileName) {
		super(fileName);
		// TODO Auto-generated constructor stub
	}

	/**
	 * A�adir entrada.
	 *
	 * @param entrada
	 *            the entrada
	 * @return the int
	 */
	public int a�adir_Entrada(Entradas entrada) {
		String cadenaSQL = "INSERT INTO entradas2 VALUES('" + entrada.getNumEntrada() + "','" + entrada.getDniEntrada()
				+ "','" + entrada.getIdEspectaculo() + "','" + entrada.getFecha() + "','" + entrada.getVendedor()
				+ "')";

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
	 * Borrar entrada.
	 *
	 * @param entrada
	 *            the entrada
	 * @return the int
	 */
	public int borrar_Entrada(Entradas entrada) {
		String cadenaSQL = "DELETE FROM ENTRADAS2 WHERE idEspectaculo = ' " + entrada.getIdEspectaculo() + "'";

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
	 * Listar entradas mes.
	 *
	 * @param mes
	 *            the mes
	 * @param ano
	 *            the ano
	 * @return the vector
	 */
	public Vector<Entradas> Listar_entradas_mes(String mesAno) {// esto ser�a m�s f�cil que nos devolviera una select
																	// con el valor
		String cadenaSQL = "SELECT * from entradas2 WHERE DATE_FORMAT(FECHA,'%m%Y')='" + mesAno + "'";
		System.out.println(cadenaSQL);
		Vector<Entradas> listar_entradas = new Vector<Entradas>();
		try {
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);

			while (reg.next()) {
				java.sql.Date f1 = reg.getDate("FECHA");
				LocalDate fecha1 = f1.toLocalDate();
				listar_entradas.add(new Entradas(reg.getInt("NUMENTRADA"), reg.getInt("IDESPECTACULO"),
						reg.getString("DNIENTRADA"), fecha1, reg.getString("VENDEDOR")));
			}

			s.close();
			this.cerrar();
			return listar_entradas;
		} catch (SQLException e) {
			return null;
		}
	}

	/**
	 * Numero entrada.
	 *
	 * @param id
	 *            the id
	 * @return the int
	 */
	public int numeroEntrada(int id) {
		String cadenaSQL = "SELECT MAX(NUMENTRADA) FROM ENTRADAS WHERE idEspectaculo ='" + id + "'";
		try {
			int maxEntrada = 0;
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);
			if (reg.next()) {
				maxEntrada = reg.getInt("NUMENTRADA");
				
			}
			s.close();
			this.cerrar();
			return maxEntrada;
		} catch (SQLException e) {
			return 0;
		}
	}

}
