package principal;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

import bbdd.*;
import modelos.Admin;
import modelos.Empleado;
import modelos.Espectaculos;
import modelos.ParteHoras;

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
			System.out.println("2.Iniciar sesión");
			opcion = sc.nextInt();
			sc.nextLine();
		}

		switch (opcion) {
		case 1:
			System.out.println("1.Solicitar entradas");
			System.out.println("2.Solicitar reserva entradas");
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
					System.out.println("1.Alta espectáculo/Borrar Espectaculo/Listar espectáculos");
					System.out.println("2.Alta/Baja alquiler sala");
					System.out.println("3.Revisar informe de horas");
					System.out.println("4.Revisar facturación por mes");
					System.out.println("5.Alta Empleado");
					System.out.println("6.Salir programa");
					opcion = sc.nextInt();
					sc.nextLine();

					switch (opcion) {
					case 1:
						opcion = 0;
						while (opcion != 4) {
							System.out.println("1.Alta espectáculo");
							System.out.println("2.Borrar espectáculo");
							System.out.println("3.Listar espectáculos");
							System.out.println("4.Salir");
							opcion = sc.nextInt();
							sc.nextLine();
							switch (opcion) {
							case 1:
								System.out.println("Introduce idEspectaculo");
								int idEspectaculo = sc.nextInt();
								sc.nextLine();
								System.out.println("Introduce nombre de espectáculo");
								String nombreEspectaculo = sc.nextLine();
								LocalDate fechaInicio = null;
								while (fechaInicio == null) {
									System.out.println("Introduce fecha inicio en el siguiente formato dd/LL/yyyy");
									String fechaAnotada = sc.nextLine();
									fechaInicio = fechaformateada(fechaAnotada);
									
								}
								LocalDate fechaFin = null;
								while (fechaFin == null) {
									System.out.println("Introduce fecha fin en el siguiente formato dd/LL/yyyy");
									String fechaAnotada2 = sc.nextLine();
									fechaFin = fechaformateada(fechaAnotada2);
									
								}
								int validarFecha = bdespectaculos.buscarFecha(fechaInicio, fechaFin);
								switch(validarFecha) {
									case 0:
										System.out.println("El espectáculo se solapa con otro");
										break;
									case 1:
										System.out.println("El espectáculo tiene hueco para ser añadido");
										Espectaculos espectaculoAlta = new Espectaculos(idEspectaculo, nombreEspectaculo, fechaInicio, fechaFin);
										filas = bdespectaculos.añadir_Espectaculo(espectaculoAlta);
										if(filas == -1) {
											System.out.println("Problemas técnicos");
										}else {
											System.out.println("Espectáculo añadido");
										}
										break;
									case 2:
										System.out.println("Problemas técnicos");
										break;
								}
							case 2:
								System.out.println("Introduzca la id del espectáculo a borrar");
								int idBorrar = sc.nextInt();
								Espectaculos espectaculoBorrar = bdespectaculos.buscarEspectaculo(idBorrar);
								if(espectaculoBorrar == null) {
									System.out.println("El espectaculo no se ha encontrado en el sistema");
								}else {
									bdespectaculos.borrar_Espectaculo(espectaculoBorrar);
								}
								break;
							case 3:
								Vector <Espectaculos> listarEspectaculos = bdespectaculos.listarEspectaculos();
								for(int i=0;i<listarEspectaculos.size();i++) {
									System.out.println(listarEspectaculos.get(i).toString());

								}
								break;
							case 4:
								break;
							}
							
						}
					case 2:

						break;
					case 3:
						System.out.println("Introduzca el mes del cuál quiere sacar el parte de horas");
						int mes = sc.nextInt();
						sc.nextLine();
						System.out.println("Introduzca el dni del empleado del cuál quiere listar las horas");
						String dniListar = sc.nextLine();
						Vector <ParteHoras> parteMes = bdhoras.Listar_parte_horas_mes_dni(mes,dniListar);
						if(parteMes == null) {
							System.out.println("Fallo del sistema");
						}else {
							double salario=0;
							int horas=0;
							for(int i=0;i<parteMes.size();i++) {
								salario=+parteMes.get(i).getSalario();
								horas=+parteMes.get(i).getHoras();
							}
							System.out.println("Al empleado con dni: "+dniListar+"le corresponden: ");
							System.out.println(salario+" euros por");
							System.out.println(horas+" horas.");
						}
						
						break;
					case 4:
						
						
						
						
						
						break;
					case 5:
						System.out.println("Introduce dniEmpleado");
						String dniEmpleado = sc.nextLine();
						System.out.println("Introduce nombreEmpleado");
						String nombreEmpleado = sc.nextLine();
						System.out.println("Introduce apellidoEmpleado");
						String apellidoEmpleado = sc.nextLine();
						System.out.println("Introduce oficio Empleado");
						String oficio = sc.nextLine();
						LocalDate fechaAlta = LocalDate.now();
						System.out.println("Introduce contraseña");
						String contraseña = sc.nextLine();
						System.out.println("Introduce precio hora");
						double precioHora = sc.nextDouble();
						Empleado alta = new Empleado(dniEmpleado, nombreEmpleado, apellidoEmpleado, oficio, fechaAlta, contraseña, precioHora);
						filas = 0;
						filas = bdempleado.añadir_Empleado(alta);
						if(filas == -1) {
							System.out.println("Problemas técnicos");
						}else {
							System.out.println("Empleado añadido");
						}
						break;
					
						
						/*System.out.println("Introduce dni empleado");
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
						break;*/
					case 6:
						System.out.println("Saliendo programa");
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
						filas = bdhoras.añadir_parte_horas(usuario.getDni(), LocalDate.now(), horas,
								usuario.getPrecioHora());
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

					case 2:
						System.out.println("Vender entrada");
						

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
