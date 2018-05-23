package bbdd;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

import modelos.Admin;
import modelos.Empleado;

import java.time.*;

// TODO: Auto-generated Javadoc
/**
 * The Class BD_Empleados.
 * La clase que contiene los m�todos que conectan con la base de datos empleado.
 */
public class BD_Empleado extends BD_Conector {

	/** The s. */
	private static Statement s;
	
	/** The reg. */
	private static ResultSet reg;

	/**
	 * Constructor empleado.
	 *
	 * @param file the file
	 */
	public BD_Empleado(String file) {
		super(file);
	}
	
	/**
	 * A�adir empleado.
	 *
	 * @param al es un objeto de la clase Empleado que se busca en la base de datos
	 * @return un int que ser� 1 en caso de que exista en la bbdd o -1 en caso de fallo
	 */
	public  int a�adir_Empleado( Empleado al){	
		String cadenaSQL="INSERT INTO empleados2 VALUES('" + al.getDni() + "','"+ al.getNombre() +"','"+ al.getApellido()+"','"+
				al.getOficio()+"','"+al.getFechaAlta()+"','"+al.getContrase�a()+"','"+al.getPrecioHora()+"')"; 	
		
		try{
		this.abrir();
		s=c.createStatement();
		int filas=s.executeUpdate(cadenaSQL);
		s.close();
		this.cerrar();
		return filas;
		}
		catch ( SQLException e){	
			System.out.println(e);
			return -1;
		}
	}
	
	
	
	

	/**
	 * Buscar empleado un m�todo que busca un Empleado en la bbdd y coteja su dni con la contrase�a almacenada.
	 *
	 * @param dni de empleado
	 * @param contrase�a la contrase�a de empleado
	 * @return el empleado o null sino existe o su contrase�a es invalida
	 */
	public Empleado buscarEmpleado(String dni, String contrase�a) {
		String cadenaSQL = "SELECT * from empleados2 WHERE DNI_EMPLEADO='" + dni + "'";
		
		Empleado retorno = null;
		try {
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);
			while (reg.next()) {
				// La fecha que se extrae de la bbdd es sql.Date, hay que transformarla a
				// LocalDate
				
				if (reg.getString("DNI_EMPLEADO").equalsIgnoreCase(dni)
						&& reg.getString("CONTRASE�A").equalsIgnoreCase(contrase�a)) {

					java.sql.Date f = reg.getDate("FECHA_ALTA");
					LocalDate fBuena = f.toLocalDate();
					if (reg.getString("OFICIO").equalsIgnoreCase("ADMIN")) {
						retorno = new Admin(reg.getString("DNI_EMPLEADO"), reg.getString("NOMBRE"),
								reg.getString("APELLIDO"), reg.getString("OFICIO"), fBuena, reg.getString("CONTRASE�A"),
								reg.getDouble("PRECIO_HORA"));
						return retorno;
					}

					retorno = new Empleado(reg.getString("DNI_EMPLEADO"), reg.getString("NOMBRE"),
							reg.getString("APELLIDO"), reg.getString("OFICIO"), fBuena, reg.getString("CONTRASE�A"),
							reg.getDouble("Precio_Hora"));
					return retorno;
				}
			}
			System.out.println("Hola");
			s.close();
			this.cerrar();
			return null;
		} catch (SQLException e) {
			System.err.println(e);
			return null;
		}
	}

	/**
	 * Borrar empleado.
	 *
	 * @param dni the dni
	 * @return the int
	 * @deprecated es una metodo que no se est� utilizando, para versiones futuras
	 */
	public int borrarEmpleado(String dni) {
		String cadena = "DELETE FROM empleados2 WHERE nombre='" + dni.toUpperCase() + "'";

		try {
			this.abrir();
			s = c.createStatement();
			int filas = s.executeUpdate(cadena);
			s.close();
			this.cerrar();
			return filas;

		} catch (SQLException e) {
			this.cerrar();
			return -1;
		}
	}

}
