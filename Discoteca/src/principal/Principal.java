package principal;

import java.util.*;

import bbdd.*;
import modelos.Admin;
import modelos.Empleado;

public class Principal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BD_Empleado bdempleado = new BD_Empleado("mysql-properties.xml");

		int opcion = 0;
		while (opcion != 1 && opcion != 2) {
			System.out.println("1.Solicitar entrada");
			System.out.println("2.Iniciar sesión");
			opcion = sc.nextInt();
			sc.nextLine();
		}

		switch (opcion) {
		case 1:
			System.out.println("1.Solicitar entradas");
			System.out.println("2.Solicitar comprar entradas");
			break;
		case 2:
			Empleado usuario = null;
			while (usuario == null) {

				System.out.println("Introduzca dni");
				String dni = sc.nextLine();
				System.out.println("Introduce contraseña");
				String password = sc.nextLine();

				usuario = bdempleado.buscarEmpleado(dni, password);

				if (usuario == null) {
					System.out.println(
							"El nombre/contraseña introducidos no corresponde con ninguno de los guardados en la base de datos");
				}

			}

			if (usuario instanceof Admin) {
				opcion = 0;
				while (opcion != 6) {
					System.out.println("Introduce opción");
					System.out.println("1.Alta/Baja espectáculos");
					System.out.println("2.Alta/Baja alquiler sala");
					System.out.println("3.Revisar informe de horas");
					System.out.println("4.Revisar facturas");
					System.out.println("5.Alta/Baja Empleado");
					System.out.println("6.Salir programa");
					opcion = sc.nextInt();
					sc.nextLine();
					
					switch(opcion) {
					case 1:
						
						break;
						
					case 2:
						
						break;
					case 3:
						break;
					case 4:
						break;
					case 5:
						System.out.println("Introduce dni empleado");
						String dniBorrar = sc.nextLine();
					
					
					
					}

				}

			} else {

				System.out.println("Introduce opción");
				System.out.println("1.Mandar informe");
				System.out.println("2.Vender entrada");

			}

		}

	}

}
