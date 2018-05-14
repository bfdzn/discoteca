package principal;

import java.time.LocalDate;
import java.util.*;

import bbdd.*;
import modelos.Admin;
import modelos.Empleado;

public class Principal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BD_Empleado bdempleado = new BD_Empleado("mysql-properties.xml");
		BD_parte_horas bdhoras = new BD_parte_horas("mysql-properties.xml");

		int filas = 0;

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

					switch (opcion) {
					case 1:
						System.out.println("Introduce el nombre del espectáculo para borrarlo");
						String nEspectaculoBuscar = sc.nextLine();
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
						filas = 0;
						filas = bdempleado.borrarEmpleado(dniBorrar);
						switch (filas) {
						case 1:
							System.out.println("Empleado borrado");
							break;
						case 0:
							System.out.println("Empleado no borrado");
							break;
						case -1:
							System.out.println("Problemas técnicos");
							break;

						}
						break;

					}

				}

			} else {
				opcion = 0;

				while (opcion != 3) {
					System.out.println("Introduce opción");
					System.out.println("1.Mandar informe");
					System.out.println("2.Vender entrada");
					opcion = sc.nextInt();

					switch (opcion) {
					case 1:
						System.out.println("Introduce numero horas");
						int horas = sc.nextInt();
						filas = 0;
						filas = bdhoras.añadir_parte_horas(usuario.getDni(), LocalDate.now(), horas, usuario.get);
						switch (filas) {
						case 1:
							System.out.println("Parte horas añadido");
							break;
						case 0:
							System.out.println("Parte de horas no añadido");
							break;
						case -1:
							System.out.println("Problemas técnicos");
							break;

						}
						break;

					}

				}//cierre while

			}

		}

	}

}
