package bbdd;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

import modelos.Admin;
import modelos.Empleado;

import java.time.*;

// TODO: Auto-generated Javadoc
/**
 * The Class BD_Empleado.
 */
public class BD_Empleado extends BD_Conector {

	/** The s. */
	private static Statement s;
	
	/** The reg. */
	private static ResultSet reg;

	/**
	 * Instantiates a new b D empleado.
	 *
	 * @param file the file
	 */
	public BD_Empleado(String file) {
		super(file);
	}
	
	/**
	 * Añadir empleado.
	 *
	 * @param al the al
	 * @return the int
	 */
	public  int añadir_Empleado( Empleado al){	
		String cadenaSQL="INSERT INTO empleados2 VALUES('" + al.getDni() + "','"+ al.getNombre() +"','"+ al.getApellido()+"','"+
				al.getOficio()+"','"+al.getFechaAlta()+"','"+al.getContraseña()+"','"+al.getPrecioHora()+"')"; 	
		
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
	 * Buscar empleado.
	 *
	 * @param dni the dni
	 * @param contraseña the contraseña
	 * @return the empleado
	 */
	public Empleado buscarEmpleado(String dni, String contraseña) {
		String cadenaSQL = "SELECT * from empleados2 WHERE DNI_EMPLEADO='" + dni + "'";
		System.out.println("Hola");
		System.out.println(cadenaSQL);
		Empleado retorno = null;
		try {
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);
			while (reg.next()) {
				// La fecha que se extrae de la bbdd es sql.Date, hay que transformarla a
				// LocalDate
				
				if (reg.getString("DNI_EMPLEADO").equalsIgnoreCase(dni)
						&& reg.getString("CONTRASEÑA").equalsIgnoreCase(contraseña)) {

					java.sql.Date f = reg.getDate("FECHA_ALTA");
					LocalDate fBuena = f.toLocalDate();
					if (reg.getString("OFICIO").equalsIgnoreCase("ADMIN")) {
						retorno = new Admin(reg.getString("DNI_EMPLEADO"), reg.getString("NOMBRE"),
								reg.getString("APELLIDO"), reg.getString("OFICIO"), fBuena, reg.getString("CONTRASEÑA"),
								reg.getDouble("PRECIO_HORA"));
						return retorno;
					}

					retorno = new Empleado(reg.getString("DNI_EMPLEADO"), reg.getString("NOMBRE"),
							reg.getString("APELLIDO"), reg.getString("OFICIO"), fBuena, reg.getString("CONTRASEÑA"),
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
