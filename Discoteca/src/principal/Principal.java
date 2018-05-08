package principal;

import java.util.*;

public class Principal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int opcion = 0;
		while(opcion != 1 && opcion != 2) {
			System.out.println("1.Solicitar entrada");
			System.out.println("2.Iniciar sesión");
			opcion = sc.nextInt();
			sc.nextLine();
		}
		
		switch(opcion) {
		case 1:
			System.out.println("1.Solicitar entradas");
			System.out.println("2.Solicitar comprar entradas");
		case 2:
			System.out.println("Introduzca usuario");
			String usuario = sc.nextLine();
			System.out.println("Introduce contraseña");
			String password = sc.nextLine();
			System.out.println("Hola");
		
		
		}
		

	}

}
