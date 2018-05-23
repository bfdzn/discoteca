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
 * La clase que conecta las entradas con la bdd
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
	 * Añadir entrada.
	 * Metodo que añade entrada accediendo al método por la ventana de usuario el vendedor será declarado a null
	 * @param entrada que es un Objeto entrada a añadir en la bbdd
	 * @return the int 1 si  se añade, 0 sino se añade nada y -1 sino;
	 */
	public int añadir_Entrada(Entradas entrada) {
		String cadenaSQL = null;
		if(!(entrada.getVendedor()==null)) {
		    cadenaSQL = "INSERT INTO entradas2 VALUES('" + entrada.getNumEntrada() + "','" + entrada.getDniEntrada()
				+ "','" + entrada.getIdEspectaculo() + "','" + entrada.getFecha() + "','" + entrada.getVendedor()
				+ "')";
		}else {
			cadenaSQL = "INSERT INTO entradas2 VALUES('" + entrada.getNumEntrada() + "','" + entrada.getDniEntrada()
			+ "','" + entrada.getIdEspectaculo() + "','" + entrada.getFecha() + "', null)";
		}
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
	 * @param entrada            the entrada
	 * @return the int
	 * @deprecated no se está utilizando para mantener la integridad de la bbdd
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
	 * se le pasa un mes
	 * @param mesAno es la suma de mes y ano que vamos a consultar
	 * @return vector con las entradas que cumplan la condicion
	 */
	public Vector<Entradas> Listar_entradas_mes(String mesAno) {
		
		String cadenaSQL = "SELECT * from entradas2 WHERE DATE_FORMAT(FECHA,'%m%Y')='" + mesAno + "'";
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
	 * @param id de espectáculo
	 * @param fecha de compra
	 * @return devuelve la máxima entrada del espectaculo en la fecha que se quiere utilizar
	 */
	public int numeroEntrada(int id, LocalDate fecha) {
		String cadenaSQL = "SELECT MAX(NUMENTRADA) ENT FROM ENTRADAS2 WHERE idEspectaculo ='" + id + "' AND FECHA = '"+fecha+"'";
		try {
			int maxEntrada = 0;
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);
			if (reg.next()) {
				maxEntrada = reg.getInt("ENT");
			}
			s.close();
			this.cerrar();
			return maxEntrada;
		} catch (SQLException e) {
			System.out.println(e);
			return 0;
		}
	}

}
