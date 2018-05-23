package principal;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

import bbdd.*;
import excepciones.EspectaculoNoExiste;
import modelos.Admin;
import modelos.Clientes;
import modelos.Empleado;
import modelos.Entradas;
import modelos.Espectaculos;
import modelos.ParteHoras;
import modelos.Reserva_sala;

// TODO: Auto-generated Javadoc
/**
 * The Class Principal.
 */
public class Principal {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BD_Empleado bdempleado = new BD_Empleado("mysql-properties.xml");
		BD_parte_horas bdhoras = new BD_parte_horas("mysql-properties.xml");
		BD_Espectaculos bdespectaculos = new BD_Espectaculos("mysql-properties.xml");
		BD_Entradas bdentradas = new BD_Entradas("mysql-properties.xml");
		BD_Clientes bdclientes = new BD_Clientes("mysql-properties.xml");
		BD_reserva_sala bdreserva = new BD_reserva_sala("mysql-properties.xml");
		int filas = 0;
		DateTimeFormatter fechaFormateada = DateTimeFormatter.ofPattern("dd/LL/yyyy");

		int opcion = 0;

		while (opcion != 1 && opcion != 2) {
			System.out.println("1.Cliente");
			System.out.println("2.Iniciar sesión");
			opcion = sc.nextInt();
			sc.nextLine();
		}

		switch (opcion) {
		case 1:// menu cliente
			while (opcion != 3) {
				System.out.println("1.Solicitar entradas");
				System.out.println("2.Solicitar reserva sala");
				System.out.println("3.Salir del programa");
				opcion = sc.nextInt();
				sc.nextLine();

				switch (opcion) {

				case 1:/**
						 * Esta función del menú sería interesante para la gestión de la venta de
						 * entradas online El método es una copia de la venta de entradas del empleado,
						 * sería interesante desarrollarlo con usuario y contraseña
						 */
					System.out.println("Vender entrada");
					listarEspectaculosF(bdespectaculos);
					System.out.println("Introduce el número espectáculo");
					int idEntradaEspect = sc.nextInt();
					sc.nextLine();
					LocalDate fecha = null;
					try {
						Espectaculos especEntrada = bdespectaculos.buscarEspectaculo(idEntradaEspect);
						if (especEntrada == null) {
							System.out.println("Problemas técnicos");
							break;
						} else {
							boolean validarFecha = false;
							while (validarFecha == false) {
								System.out.println(
										"Introduce fecha del espectaculo entre " + especEntrada.getFechaInicio() + " y "
												+ especEntrada.getFechaFin() + " en el formato dd/mm/yyyy");
								String fechaEntrada = sc.nextLine();
								try {
									fecha = LocalDate.parse(fechaEntrada, fechaFormateada);
									System.out.println(fecha);
									System.out.println();
									if (!(fecha.isBefore(especEntrada.getFechaInicio())
											|| fecha.isAfter(especEntrada.getFechaFin()))) {
										System.out.println("Fecha correcta");
										validarFecha = true;
									} else {
										System.out.println("Fecha introducida antes o después del espectáculo");
									}

								} catch (DateTimeParseException e) {
									System.out.println("Formato incorrecto");
									sc.nextLine();
									return;
								}

							}
							System.out.println("Introduce el dni del comprador");
							String dniEntrada = sc.nextLine();

							int numEntradas = 4;
							while (numEntradas > 3) {
								System.out.println("Introduce el número de entradas que quieres, 3 como máximo");
								numEntradas = sc.nextInt();
								sc.nextLine();

							}

							for (int i = 0; i < numEntradas; i++) {

								int numEntrada = bdentradas.numeroEntrada(idEntradaEspect, fecha);
								if (especEntrada.getAforo() == numEntrada) {
									System.out.println("El espectáculo tiene el aforo completo");
									break;
								} else {
									numEntrada = numEntrada + 1;
									System.out.println(numEntrada);

									Entradas altaEntrada = new Entradas(numEntrada, idEntradaEspect, dniEntrada, fecha,
											null);
									filas = 0;
									filas = bdentradas.añadir_Entrada(altaEntrada);
									if (filas == -1) {
										System.out.println("Problemas técnicos");
									} else {
										System.out.println("Entrada vendida");
									}

								}
							}
						}

					} catch (EspectaculoNoExiste e) {
						System.out.println("El espectáculo del que quiere comprar entradas no existe en la BBDD");
						break;
					}
					break;
				case 2:

					LocalDate fechaInicioR = null;
					while (fechaInicioR == null) {
						System.out.println("Introduce fecha inicio en el siguiente formato dd/LL/yyyy");
						String fechaAnotada = sc.nextLine();
						fechaInicioR = fechaformateada(fechaAnotada);
						if (fechaInicioR.isBefore(LocalDate.now())) {
							System.out.println("La fecha anotada es anterior a la actual");
							break;
						}

					}

					LocalDate fechaF = null;
					boolean validarFechaF = false;
					while (validarFechaF == false) {
						System.out.println("Introduce fecha fin en el siguiente formato dd/LL/yyyy");
						String fechaAnotada2 = sc.nextLine();
						fechaF = fechaformateada(fechaAnotada2);
						if (fechaF.isBefore(LocalDate.now())) {
							System.out.println("La fecha introducida es anterior a la actual");
							return;
						} else if (fechaF.isBefore(fechaInicioR)) {
							System.out.println("La fecha de fin es superior a la fecha de inicio");
							return;
						}
						validarFechaF = true;

					}
					System.out.println("Introduce dni cliente");
					String dniCliente = sc.nextLine();

					Clientes clienteS = bdclientes.buscarCliente(dniCliente);
					if (clienteS == null) {
						LocalDate fechaN = null;
						while (fechaN == null) {
							System.out.println("Introduzca fecha nacimiento");
							String fechaNacimiento = sc.nextLine();
							fechaN = fechaformateada(fechaNacimiento);
							clienteS = new Clientes(dniCliente, fechaN);
							filas = bdclientes.añadir_Cliente(clienteS);
							if (filas == 0) {
								System.out.println("Cliente añadido");
							} else if (filas == -1) {
								System.out.println("Problemas técnicos");
							} else {
								System.out.println("Cliente añadido");
							}
						}
					}

					Reserva_sala alta = new Reserva_sala(fechaInicioR, fechaF, null, clienteS.getDni());
					bdreserva.añadir_reserva(alta);
					break;

				}

			}
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
					System.out.println("1.Alta espectáculo/Listar espectáculos");
					System.out.println("2.Alta/Listar reservas");
					System.out.println("3.Revisar informe de horas individual/Crear factura");
					System.out.println("4.Revisar venta de entradas mes");
					System.out.println("5.Alta Empleado");
					System.out.println("6.Salir programa");
					opcion = sc.nextInt();
					sc.nextLine();

					switch (opcion) {// Alta espectáculo/Listar espectáculos
					case 1:
						opcion = 0;
						while (opcion != 4) {
							System.out.println("1.Alta espectáculo");
							System.out.println("2.Listar espectáculos");
							System.out.println("3.Listar espectáculos futuros");
							System.out.println("4.Salir");
							opcion = sc.nextInt();
							sc.nextLine();
							switch (opcion) {
							case 1:
								int idEspectaculo = bdespectaculos.buscarMax() + 1;
								System.out.println("Introduce nombre de espectáculo");
								String nombreEspectaculo = sc.nextLine();
								LocalDate fechaInicio = null;
								while (fechaInicio == null) {
									System.out.println("Introduce fecha inicio en el siguiente formato dd/LL/yyyy");
									String fechaAnotada = sc.nextLine();
									fechaInicio = fechaformateada(fechaAnotada);
									if (fechaInicio.isBefore(LocalDate.now())) {
										System.out.println("La fecha anotada es anterior a la actual");
										break;
									}

								}
								LocalDate fechaFin = null;
								boolean validarFechaE = false;
								while (validarFechaE == false) {
									System.out.println("Introduce fecha fin en el siguiente formato dd/LL/yyyy");
									String fechaAnotada2 = sc.nextLine();
									fechaFin = fechaformateada(fechaAnotada2);
									if (fechaFin.isBefore(LocalDate.now())) {
										System.out.println("La fecha introducida es anterior a la actual");
										return;
									} else if (fechaFin.isBefore(fechaInicio)) {
										System.out.println("La fecha de fin es superior a la fecha de inicio");
										return;
									}
									validarFechaE = true;

								}
								System.out.println("Introduzca precio espectáculo");
								double precioEspectaculo = sc.nextDouble();
								System.out.println("Introduzca aforo espectáculo");
								int aforo = sc.nextInt();

								int validarFecha = bdespectaculos.buscarFecha(fechaInicio, fechaFin);
								switch (validarFecha) {
								case 0:
									System.out.println("El espectáculo se solapa con otro");
									break;
								case 1:
									System.out.println("El espectáculo tiene hueco para ser añadido");
									Espectaculos espectaculoAlta = new Espectaculos(idEspectaculo, nombreEspectaculo,
											fechaInicio, fechaFin, precioEspectaculo, aforo);
									filas = bdespectaculos.añadir_Espectaculo(espectaculoAlta);
									if (filas == -1) {
										System.out.println("Problemas técnicos");
									} else {
										System.out.println("Espectáculo añadido");
									}
									break;
								case 2:
									System.out.println("Problemas técnicos");
									break;
								}
								/**
								 * Teniamos pensado crear un método que borrará los espectáculos, aunque a la
								 * hora de codificar nos hemos dado cuenta que se borraría la foreign key de
								 * entradas y de reserva salas, por lo que no tiene sentido borrarlo de la base
								 * de datos. Es importante que se siga manteniendo para así poder controlar un
								 * histórico de facturación que está vinculado tanto a las entradas como a los
								 * espectáculos.
								 * 
								 *
								 *
								 * System.out.println("Introduzca la id del espectáculo a borrar"); int idBorrar
								 * = sc.nextInt(); Espectaculos espectaculoBorrar =
								 * bdespectaculos.buscarEspectaculo(idBorrar); if(espectaculoBorrar == null) {
								 * System.out.println("El espectaculo no se ha encontrado en el sistema"); }else
								 * { bdespectaculos.borrar_Espectaculo(espectaculoBorrar); }
								 */
								break;
							case 3:
								listarEspectaculosF(bdespectaculos);
								break;
							case 4:
								System.out.println("Saliendo pantalla espectáculo");
								break;

							}

						}
					case 2:// Alta baja alquiler/listar reservas
						opcion = 0;
						while (opcion != 3) {
							System.out.println("1.Añadir reserva");
							System.out.println("2.Listar reservas");
							System.out.println("3.Salir ventana");
							opcion = sc.nextInt();
							sc.nextLine();

							switch (opcion) {
							case 1:

								LocalDate fechaInicioR = null;
								while (fechaInicioR == null) {
									System.out.println("Introduce fecha inicio en el siguiente formato dd/LL/yyyy");
									String fechaAnotada = sc.nextLine();
									fechaInicioR = fechaformateada(fechaAnotada);
									if (fechaInicioR.isBefore(LocalDate.now())) {
										System.out.println("La fecha anotada es anterior a la actual");
										break;
									}

								}

								LocalDate fechaF = null;
								boolean validarFechaF = false;
								while (validarFechaF == false) {
									System.out.println("Introduce fecha fin en el siguiente formato dd/LL/yyyy");
									String fechaAnotada2 = sc.nextLine();
									fechaF = fechaformateada(fechaAnotada2);
									if (fechaF.isBefore(LocalDate.now())) {
										System.out.println("La fecha introducida es anterior a la actual");
										return;
									} else if (fechaF.isBefore(fechaInicioR)) {
										System.out.println("La fecha de fin es superior a la fecha de inicio");
										return;
									}
									validarFechaF = true;

								}
								System.out.println("Introduce dni cliente");
								String dniCliente = sc.nextLine();

								Clientes clienteS = bdclientes.buscarCliente(dniCliente);
								if (clienteS == null) {
									LocalDate fechaN = null;
									while (fechaN == null) {
										System.out.println("Introduzca fecha nacimiento");
										String fechaNacimiento = sc.nextLine();
										fechaN = fechaformateada(fechaNacimiento);
										clienteS = new Clientes(dniCliente, fechaN);
										filas = bdclientes.añadir_Cliente(clienteS);
										if (filas == 0) {
											System.out.println("Cliente añadido");
										} else if (filas == -1) {
											System.out.println("Problemas técnicos");
										} else {
											System.out.println("Cliente añadido");
										}
									}
								}

								Reserva_sala alta = new Reserva_sala(fechaInicioR, fechaF, usuario.getDni(),
										clienteS.getDni());
								bdreserva.añadir_reserva(alta);
								break;

							case 2:
								System.out.println("Listando reserva");
								Vector<Reserva_sala> salas = bdreserva.Listar_reserva();
								for (int i = 0; i < salas.size(); i++) {
									System.out.println(salas.get(i).toString());
								}
							case 3:
								System.out.println("Saliendo ventana");
								break;
							}

						}

						break;
					case 3: // Control del informe de horas
						opcion = 0;
						while (opcion != 3) {
							System.out.println("1.Listar parte de horas individual");
							System.out.println("2.Generar archivo con los importes a pagar a cada empleado en el mes");
							System.out.println("3.Salir ventana");
							opcion = sc.nextInt();
							sc.nextLine();
							switch (opcion) {

							case 1:
								System.out
										.println("Introduzca el mes y el año del cuál quiere sacar el parte de horas");
								System.out.println("Introduce el mes");
								String mesfp = sc.nextLine();
								if (mesfp.length() == 1) {
									mesfp = '0' + mesfp;
								}
								System.out.println("Introduce el año");
								String anofp = sc.nextLine();
								String mesAnoP = mesfp + anofp;

								System.out.println("Introduzca el dni del empleado del cuál quiere listar las horas");
								String dniListar = sc.nextLine();
								double[] parteMes = bdhoras.Listar_parte_horas_mes_dni(mesAnoP, dniListar);
								if (parteMes == null) {
									System.out.println("Fallo del sistema");
								} else {

									System.out.println("Al empleado con dni: " + dniListar + "le corresponden: ");
									System.out.println(parteMes[0] + " euros por");
									System.out.println(parteMes[1] + " horas.");
								}
								break;

							case 2:
								System.out
										.println("Introduzca el mes y el año del cuál quiere sacar el archivo");
								System.out.println("Introduce el mes");
								String mestxt = sc.nextLine();
								if (mestxt.length() == 1) {
									mestxt = '0' + mestxt;
								}
								System.out.println("Introduce el año");
								String anotxt = sc.nextLine();
								String mesAnotxt = mestxt + anotxt;
								bdhoras.generarTexto(mesAnotxt);
								
								break;

							}

						}

					case 4:// Revisar la facturación mensual
						System.out.println("Introduce el mes");
						String mesf = sc.nextLine();
						if (mesf.length() == 1) {
							mesf = '0' + mesf;
						}
						System.out.println("Introduce el año");
						String anof = sc.nextLine();
						String mesAno = mesf + anof;
						Vector<Entradas> entradas = bdentradas.Listar_entradas_mes(mesAno);
						if (entradas == null) {
							System.out.println("Fallo del sistema");
						} else {
							double recaudacion = 0;
							for (int i = 0; i < entradas.size(); i++) {
								try {
									System.out.println("Hola");
									double precioH = bdespectaculos.buscarPrecio(entradas.get(i).getIdEspectaculo());
									recaudacion = recaudacion + precioH;

								} catch (EspectaculoNoExiste e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							System.out.println("El mes " + mesf + " del año " + anof);
							System.out.println("Se recaudaron en total :" + recaudacion);
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
						System.out.println("Introduce contraseña");
						String contraseña = sc.nextLine();
						System.out.println("Introduce precio hora");
						double precioHora = sc.nextDouble();
						Empleado alta = new Empleado(dniEmpleado, nombreEmpleado, apellidoEmpleado, oficio, fechaAlta,
								contraseña, precioHora);
						filas = 0;
						filas = bdempleado.añadir_Empleado(alta);
						if (filas == -1) {
							System.out.println("Problemas técnicos");
						} else {
							System.out.println("Empleado añadido");
						}
						break;

					/*
					 * System.out.println("Introduce dni empleado"); String dniBorrar =
					 * sc.nextLine(); filas = 0; filas = bdempleado.borrarEmpleado(dniBorrar);
					 * switch (filas) { case 1: System.out.println("Empleado borrado"); break; case
					 * 0: System.out.println("Empleado no borrado"); break; case -1:
					 * System.out.println("Problemas técnicos"); break;
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
					System.out.println("Introduce opción");
					System.out.println("1.Mandar informe");
					System.out.println("2.Vender entrada");
					opcion = sc.nextInt();

					switch (opcion) {
					case 1:// Mandar un informe de horas
						/**
						 * Solo se puede generar un parte de horas por día estamos controlando por tanto
						 * que la sala solo tiene un espectáculo si quisieramos fichar en distintas
						 * horas habría que insertar un autonúmerico en la tabla de parte_horas
						 */
						System.out.println("Solo se puede generar un parte de horas por día");
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

					case 2:// Vender entradas
						System.out.println("Vender entrada");
						listarEspectaculosF(bdespectaculos);
						System.out.println("Introduce el número espectáculo");
						int idEntradaEspect = sc.nextInt();
						sc.nextLine();
						LocalDate fecha = null;
						try {
							Espectaculos especEntrada = bdespectaculos.buscarEspectaculo(idEntradaEspect);
							if (especEntrada == null) {
								System.out.println("Problemas técnicos");
								break;
							} else {
								boolean validarFecha = false;
								while (validarFecha == false) {
									System.out.println(
											"Introduce fecha del espectaculo entre " + especEntrada.getFechaInicio()
													+ " y " + especEntrada.getFechaFin() + " en el formato dd/mm/yyyy");
									String fechaEntrada = sc.nextLine();
									try {
										fecha = LocalDate.parse(fechaEntrada, fechaFormateada);
										System.out.println(fecha);
										System.out.println();
										if (!(fecha.isBefore(especEntrada.getFechaInicio())
												|| fecha.isAfter(especEntrada.getFechaFin()))) {
											System.out.println("Fecha correcta");
											validarFecha = true;
										} else {
											System.out.println("Fecha introducida antes o después del espectáculo");
										}

									} catch (DateTimeParseException e) {
										System.out.println("Formato incorrecto");
										sc.nextLine();
										return;
									}

								}

								int numEntrada = bdentradas.numeroEntrada(idEntradaEspect, fecha);
								if (especEntrada.getAforo() == numEntrada) {
									System.out.println("El espectáculo tiene el aforo completo");
									break;
								} else {
									numEntrada = numEntrada + 1;
									System.out.println(numEntrada);
									System.out.println("Introduce el dni del comprador");
									String dniEntrada = sc.nextLine();

									Entradas altaEntrada = new Entradas(numEntrada, idEntradaEspect, dniEntrada, fecha,
											usuario.getDni());
									filas = 0;
									filas = bdentradas.añadir_Entrada(altaEntrada);
									if (filas == -1) {
										System.out.println("Problemas técnicos");
									} else {
										System.out.println("Entrada vendida");
									}

								}
							}

						} catch (EspectaculoNoExiste e) {
							System.out.println("El espectáculo del que quiere comprar entradas no existe en la BBDD");
							break;
						}
						break;

					case 3: // Salir del programa
						System.out.println("Saliendo programa");
						break;

					}

				} // cierre while

			}

		}

	}

	/**
	 * Fechaformateada. metodo que formatea fechas
	 * 
	 * @param fecha
	 *            en formato string
	 * @return the local date de la fecha
	 * @throws DateTimeParseException
	 *             the date time parse exception
	 */
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

	/**
	 * Listar espectaculos. lista todos los espectáculos
	 * 
	 * @param bdespectaculos
	 *            the bdespectaculos
	 */
	public static void listarEspectaculos(BD_Espectaculos bdespectaculos) {
		Vector<Espectaculos> listarEspectaculos = bdespectaculos.listarEspectaculos();
		for (int i = 0; i < listarEspectaculos.size(); i++) {
			System.out.println(listarEspectaculos.get(i).toString());

		}
	}

	/**
	 * Listar espectaculos F. lista los espectáculos que son después de la fecha
	 * 
	 * @param bdespectaculos
	 *            espectaculos que son después de la fecha
	 */
	public static void listarEspectaculosF(BD_Espectaculos bdespectaculos) {
		Vector<Espectaculos> listarEspectaculos = bdespectaculos.listarEspectaculos();
		for (int i = 0; i < listarEspectaculos.size(); i++) {
			if (listarEspectaculos.get(i).getFechaFin().isAfter(LocalDate.now())) {
				System.out.println(listarEspectaculos.get(i).toString());
			}
		}
	}

}
