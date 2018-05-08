package bbdd;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

import modelos.Alumno;
import modelos.Empleado;

import java.time.*;
public class BD_Empleado extends BD_Conector{
	
	


	private static Statement s;	
	private static ResultSet reg;
	
	public BD_Empleado(String file){
		super(file);
	}
	
	public Empleado buscarEmpleado(String dni){
		String cadenaSQL="SELECT * from empleados2 WHERE DNI_EMPLEADO='"+dni+"'";
		Vector<Alumno> listaCursos=new Vector<Alumno>();
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			while ( reg.next()){
				// La fecha que se extrae de la bbdd es sql.Date, hay que transformarla a LocalDate
				java.sql.Date f=reg.getDate("fechaMatricula");
				LocalDate fBuena=f.toLocalDate();
				listaCursos.add(new Alumno(reg.getString("dni"),reg.getString("nombre"),reg.getString("curso"),reg.getInt("matricula"),reg.getString("telefono"),fBuena));
				
			}
			s.close();
			this.cerrar();
			return listaCursos;
		}
		catch ( SQLException e){		
			return null;			
		}
	}
	
	

}
