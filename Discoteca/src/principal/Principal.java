package principal;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

import bbdd.*;
import excepciones.EspectaculoNoExiste;
import modelos.Admin;
import modelos.Empleado;
import modelos.Entradas;
import modelos.Espectaculos;
import modelos.ParteHoras;

public class Principal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BD_Empleado bdempleado = new BD_Empleado("mysql-properties.xml");
		BD_parte_horas bdhoras = new BD_parte_horas("mysql-properties.xml");
		BD_Espectaculos bdespectaculos = new BD_Espectaculos("mysql-properties.xml");
		BD_Entradas bdentradas = new BD_Entradas("mysql-properties.xml");
		int filas = 0;

		int opcion = 0;
		while (opcion != 1 && opcion != 2) {
			System.out.println("1.Solicitar entrada");
			System.out.println("2.Iniciar sesi�n");
			opcion = sc.nextInt();
			sc.nextLine();
		}

		switch (opcion) {
		case 1://menu cliente
			System.out.println("1.Solicitar entradas");
			System.out.println("2.Solicitar reserva entradas");
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
					System.out.println("1.Alta espect�culo/Borrar Espectaculo/Listar espect�culos");
					System.out.println("2.Alta/Baja alquiler sala");
					System.out.println("3.Revisar informe de horas");
					System.out.println("4.Revisar facturaci�n por mes");
					System.out.println("5.Alta Empleado");
					System.out.println("6.Salir programa");
					opcion = sc.nextInt();
					sc.nextLine();

					switch (opcion) {// Alta espect�culo/Listar espect�culos
					case 1:
						opcion = 0;
						while (opcion != 4) {
							System.out.println("1.Alta espect�culo");
							System.out.println("2.Borrar espect�culo");
							System.out.println("3.Listar espect�culos");
							System.out.println("4.Salir");
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
									System.out.println("Introduce fecha fin en el siguiente formato dd/LL/yyyy");
									String fechaAnotada2 = sc.nextLine();
									fechaFin = fechaformateada(fechaAnotada2);

								}
								System.out.println("Introduzca precio espect�culo");
								double precioEspectaculo = sc.nextDouble();
								System.out.println("Introduzca aforo espect�culo");
								int aforo = sc.nextInt();

								int validarFecha = bdespectaculos.buscarFecha(fechaInicio, fechaFin);
								switch (validarFecha) {
								case 0:
									System.out.println("El espect�culo se solapa con otro");
									break;
								case 1:
									System.out.println("El espect�culo tiene hueco para ser a�adido");
									Espectaculos espectaculoAlta = new Espectaculos(idEspectaculo, nombreEspectaculo,
											fechaInicio, fechaFin, precioEspectaculo, aforo);
									filas = bdespectaculos.a�adir_Espectaculo(espectaculoAlta);
									if (filas == -1) {
										System.out.println("Problemas t�cnicos");
									} else {
										System.out.println("Espect�culo a�adido");
									}
									break;
								case 2:
									System.out.println("Problemas t�cnicos");
									break;
								}
							case 2:
								/*
								 * System.out.println("Introduzca la id del espect�culo a borrar"); int idBorrar
								 * = sc.nextInt(); Espectaculos espectaculoBorrar =
								 * bdespectaculos.buscarEspectaculo(idBorrar); if(espectaculoBorrar == null) {
								 * System.out.println("El espectaculo no se ha encontrado en el sistema"); }else
								 * { bdespectaculos.borrar_Espectaculo(espectaculoBorrar); }
								 */
								break;
							case 3:
								Vector<Espectaculos> listarEspectaculos = bdespectaculos.listarEspectaculos();
								for (int i = 0; i < listarEspectaculos.size(); i++) {
									System.out.println(listarEspectaculos.get(i).toString());

								}
								break;
							case 4:
								System.out.println("Saliendo pantalla espect�culo");
								break;
							}

						}
					case 2:// Alta baja alquiler/sala

						break;
					case 3: // Control del informe de horas
						System.out.println("Introduzca el mes y el a�o del cu�l quiere sacar el parte de horas");
						System.out.println("A�o");
						int ano = sc.nextInt();
						System.out.println("Mes");
						int mes = sc.nextInt();
						sc.nextLine();
						
						sc.nextLine();
						System.out.println("Introduzca el dni del empleado del cu�l quiere listar las horas");
						String dniListar = sc.nextLine();
						Vector<ParteHoras> parteMes = bdhoras.Listar_parte_horas_mes_dni(mes, ano, dniListar);
						if (parteMes == null) {
							System.out.println("Fallo del sistema");
						} else {
							double salario = 0;
							int horas = 0;
							for (int i = 0; i < parteMes.size(); i++) {
								salario = +parteMes.get(i).getSalario();
								horas = +parteMes.get(i).getHoras();
							}
							System.out.println("Al empleado con dni: " + dniListar + "le corresponden: ");
							System.out.println(salario + " euros por");
							System.out.println(horas + " horas.");
						}

						break;
					case 4:// Revisar la facturaci�n mensual
						System.out.println("Introduce el mes");
						int mesf = sc.nextInt();
						System.out.println("Introduce el a�o");
						int anof = sc.nextInt();
						Vector<Entradas> entradas = bdentradas.Listar_entradas_mes(mesf, anof);
						if (entradas == null) {
							System.out.println("Fallo del sistema");
						} else {
							double recaudacion = 0;
							for (int i = 0; i < entradas.size(); i++) {
								try {
									double precioH = bdespectaculos.buscarPrecio(entradas.get(i).getIdEspectaculo());
									 recaudacion = recaudacion+precioH;
									 
								} catch (EspectaculoNoExiste e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							System.out.println("El mes "+mesf+" del a�o "+anof);
							System.out.println("Se recaudaron en total :"+recaudacion);
						}
						
						
						
						
						break;
						
						
						
					case 5:// Dar de alta a un empleado
						System.out.println("Introduce dniEmpleado");
						String dniEmpleado = sc.nextLine();
						System.out.println("Introduce nombreEmpleado");
						String nombreEmpleado = sc.nextLine();
						System.out.println("Introduce apellidoEmpleado");
						String apellidoEmpleado = sc.nextLine();
						System.out.println("Introduce oficio Empleado");
						String oficio = sc.nextLine();
						LocalDate fechaAlta = LocalDate.now();
						System.out.println("Introduce contrase�a");
						String contrase�a = sc.nextLine();
						System.out.println("Introduce precio hora");
						double precioHora = sc.nextDouble();
						Empleado alta = new Empleado(dniEmpleado, nombreEmpleado, apellidoEmpleado, oficio, fechaAlta,
								contrase�a, precioHora);
						filas = 0;
						filas = bdempleado.a�adir_Empleado(alta);
						if (filas == -1) {
							System.out.println("Problemas t�cnicos");
						} else {
							System.out.println("Empleado a�adido");
						}
						break;

					/*
					 * System.out.println("Introduce dni empleado"); String dniBorrar =
					 * sc.nextLine(); filas = 0; filas = bdempleado.borrarEmpleado(dniBorrar);
					 * switch (filas) { case 1: System.out.println("Empleado borrado"); break; case
					 * 0: System.out.println("Empleado no borrado"); break; case -1:
					 * System.out.println("Problemas t�cnicos"); break;
					 * 
					 * } break;
					 */
					case 6:
						System.out.println("Saliendo programa");
						break;
					}

				}

			} else {// Pantalla de empleado
				opcion = 0;

				while (opcion != 3) {
					System.out.println("Introduce opci�n");
					System.out.println("1.Mandar informe");
					System.out.println("2.Vender entrada");
					opcion = sc.nextInt();

					switch (opcion) {
					case 1:// Mandar un informe de horas
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

					case 2:// Vender entradas
						System.out.println("Vender entrada");
						System.out.println("Introduce el n�mero espect�culo");
						int idEntradaEspect = sc.nextInt();
						sc.nextLine();
						try {
							Espectaculos especEntrada = bdespectaculos.buscarEspectaculo(idEntradaEspect);
							if (especEntrada == null) {
								System.out.println("Problemas t�cnicos");
								break;
							} else {
								int numEntrada = bdentradas.numeroEntrada(idEntradaEspect);
								if (especEntrada.getAforo() == numEntrada) {
									System.out.println("El espect�culo tiene el aforo completo");
									break;
								} else {
									System.out.println("Introduce el dni del comprador");
									String dniEntrada = sc.nextLine();
									Entradas altaEntrada = new Entradas(numEntrada, idEntradaEspect, dniEntrada,
											LocalDate.now(), usuario.getDni());
									filas = 0;
									filas = bdentradas.a�adir_Entrada(altaEntrada);
									if (filas == -1) {
										System.out.println("Problemas t�cnicos");
									} else {
										System.out.println("Empleado a�adido");
									}

								}
							}

						} catch (EspectaculoNoExiste e) {
							System.out.println("El espect�culo del que quiere comprar entradas no existe en la BBDD");
							break;
						}

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
