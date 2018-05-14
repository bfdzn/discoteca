package bbdd;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

import modelos.Admin;
import modelos.Empleado;

import java.time.*;

public class BD_Empleado extends BD_Conector {

	private static Statement s;
	private static ResultSet reg;

	public BD_Empleado(String file) {
		super(file);
	}

	public Empleado buscarEmpleado(String dni, String contraseña) {
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
							reg.getDouble("PrecioHora"));
					return retorno;
				}
			}
			s.close();
			this.cerrar();
			return null;
		} catch (SQLException e) {
			return null;
		}
	}

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
