package bbdd;
/*
 * 
Lee los datos de un archivo de propiedades
 */

import java.sql.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

public class BD_Conector{
	
	private String usuario;
	private String pass;
	private String url;
	protected Connection c;
	
	private String driver;
	
	Properties prop;
	
	public BD_Conector(String fileName) {	
	   try{
		Properties prop = new Properties();
	    prop.loadFromXML(Files.newInputStream(Paths.get(fileName)));
	    
	    driver = prop.getProperty("driver");
	    usuario = prop.getProperty("user_name");
		pass = prop.getProperty("password");
	    
		String dbms = prop.getProperty("dbms");
		String dbName = prop.getProperty("database_name");
		String serverName = prop.getProperty("server_name");
		int portNumber = Integer.parseInt(prop.getProperty("port_number"));
		
		url="jdbc:" + dbms + "://"+ serverName + ":" + portNumber + "/" + dbName;
		
		System.out.println("Set the following properties:");
		System.out.println("dbms: " + dbms);
		System.out.println("driver: " + driver);
		System.out.println("dbName: " + dbName);
		System.out.println("userName: " + usuario);
		System.out.println("serverName: " + serverName);
		System.out.println("portNumber: " + portNumber);
		
		
	   }catch(FileNotFoundException e){
		   System.out.println("No se encuentra el archivo de configuración");  
	   }catch(InvalidPropertiesFormatException e){
		   System.out.println("Error formato fichero de configuración");
	   }catch(IOException e){
		   System.out.println("Error abriendo fichero de configuración");
	   }
	

	}
	
	public void abrir(){
		try{
			Class.forName(driver);
		}
		catch (ClassNotFoundException e){
			System.out.println(e.getMessage());
		}
		try{
		 	c=DriverManager.getConnection(url,usuario,pass);
		}
		catch (SQLException e ){
			System.out.println(e.getMessage());
		}
	
	}	
	

	public void cerrar(){
		try{
			if (c!=null){
				c.close();
				c=null;}
		}
		catch (SQLException e){
			System.out.println(e.getMessage());
			
		}
	}
	
	
}
