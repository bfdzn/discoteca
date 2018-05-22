//Borja Fernández Nava
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

// TODO: Auto-generated Javadoc
/**
 * The Class BD_Conector.
 */
public class BD_Conector{
	
	/** The usuario. */
	private String usuario;
	
	/** The pass. */
	private String pass;
	
	/** The url. */
	private String url;
	
	/** The c. */
	protected Connection c;
	
	/** The driver. */
	private String driver;
	
	/** The prop. */
	Properties prop;
	
	/**
	 * Instantiates a new b D conector.
	 *
	 * @param fileName the file name
	 */
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
		
		
		
		
	   }catch(FileNotFoundException e){
		   System.out.println("No se encuentra el archivo de configuración");  
	   }catch(InvalidPropertiesFormatException e){
		   System.out.println("Error formato fichero de configuración");
	   }catch(IOException e){
		   System.out.println("Error abriendo fichero de configuración");
	   }
	

	}
	
	/**
	 * Abrir.
	 */
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
	

	/**
	 * Cerrar.
	 */
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
