package principal;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

import bbdd.*;
import modelos.Admin;
import modelos.Empleado;
import modelos.Espectaculos;

public class Principal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BD_Empleado bdempleado = new BD_Empleado("mysql-properties.xml");
		BD_parte_horas bdhoras = new BD_parte_horas("mysql-properties.xml");
		BD_Espectaculos bdespectaculos = new BD_Espectaculos("mysql-properties.xml");


		int filas = 0;

		int opcion = 0;
		while (opcion != 1 && opcion != 2) {
			System.out.println("1.Solicitar entrada");
			System.out.println("2.Iniciar sesi�n");
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
				System.out.println("Introduce contrase�a");
				String password = sc.nextLine();

				usuario = bdempleado.buscarEmpleado(dni, password);
				if (usuario == null) {
					System.out.println(
							"El nombre/contrase�a introducidos no corresponde con ninguno de los guardados en la base de datos");
				}

			}

			if (usuario instanceof Admin) {
				opcion = 0;
				while (opcion != 6) {
					System.out.println("Introduce opci�n");
					System.out.println("1.Alta espect�culo/Listar espect�culos");
					System.out.println("2.Alta/Baja alquiler sala");
					System.out.println("3.Revisar informe de horas");
					System.out.println("4.Revisar facturas");
					System.out.println("5.Alta Empleado");
					System.out.println("6.Salir programa");
					opcion = sc.nextInt();
					sc.nextLine();

					switch (opcion) {
					case 1:
						opcion = 0;
						while (opcion != 3) {
							System.out.println("1.Alta espect�culo");
							System.out.println("2.Listar espect�culos");
							System.out.println("3.Salir");
							opcion = sc.nextInt();
							sc.nextLine();
							switch (opcion) {
							case 1:
								System.out.println("Introduce idEspectaculo");
								int idEspectaculo = sc.nextInt();
								sc.nextLine();
								System.out.println("Introduce nombre de espect�culo");
								String nombreEspectaculo = sc.nextLine();
								LocalDate fechaInicio = null;
								while (fechaInicio == null) {
									System.out.println("Introduce fecha inicio en el siguiente formato dd/LL/yyyy");
									String fechaAnotada = sc.nextLine();
									fechaInicio = fechaformateada(fechaAnotada);
									
								}
								LocalDate fechaFin = null;
								while (fechaFin == null) {
									System.out.println("Introduce fecha inicio en el siguiente formato dd/LL/yyyy");
									String fechaAnotada2 = sc.nextLine();
									fechaFin = fechaformateada(fechaAnotada2);
									
								}
								int validarFecha = bdespectaculos.buscarFecha(fechaInicio, fechaFin);
								switch(validarFecha) {
									case 0:
										System.out.println("El espect�culo se solapa con otro");
										break;
									case 1:
										System.out.println("El espect�culo tiene hueco para ser a�adido");
										Espectaculos espectaculoAlta = new Espectaculos(idEspectaculo, nombreEspectaculo, fechaInicio, fechaFin);
										filas = bdespectaculos.a�adir_Espectaculo(espectaculoAlta);
										if(filas == -1) {
											System.out.println("Problemas t�cnicos");
										}else {
											System.out.println("Espect�culo a�adido");
										}
										break;
									case 2:
										System.out.println("Problemas t�cnicos");
										break;
								}
							case 2:
								System.out.println("Introduzca la id del espect�culo a borrar");
								int idBorrar = sc.nextInt();
								Espectaculos espectaculoBorrar = bdespectaculos.buscarEspectaculo(idBorrar);
								if(espectaculoBorrar == null) {
									System.out.println("El espectaculo no se ha encontrado en el sistema");
								}else {
									bdespectaculos.borrar_Espectaculo(espectaculoBorrar);
								}

							}
							break;
						}
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
							System.out.println("Problemas t�cnicos");
							break;

						}
						break;

					}

				}

			} else {
				opcion = 0;

				while (opcion != 3) {
					System.out.println("Introduce opci�n");
					System.out.println("1.Mandar informe");
					System.out.println("2.Vender entrada");
					opcion = sc.nextInt();

					switch (opcion) {
					case 1:
						System.out.println("Introduce numero horas");
						int horas = sc.nextInt();
						filas = 0;
						filas = bdhoras.a�adir_parte_horas(usuario.getDni(), LocalDate.now(), horas,
								usuario.getPrecioHora());
						switch (filas) {
						case 1:
							System.out.println("Parte horas a�adido");
							break;
						case 0:
							System.out.println("Parte de horas no a�adido");
							break;
						case -1:
							System.out.println("Problemas t�cnicos");
							break;

						}
						break;

					case 2:
						System.out.println("");

					}

				} // cierre while

			}

		}

	}

	public static LocalDate fechaformateada(String fecha) throws DateTimeParseException {
		DateTimeFormatter fechaFormateada = DateTimeFormatter.ofPattern("dd/LL/yyyy");

		try {
			LocalDate fechaInicio = LocalDate.parse(fecha, fechaFormateada);
			return fechaInicio;

		} catch (DateTimeParseException e) {
			System.out.println("Formato incorrecto");
			return null;
		}
	}
}
