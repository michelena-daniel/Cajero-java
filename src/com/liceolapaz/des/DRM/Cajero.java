package com.liceolapaz.des.DRM;
import java.util.Scanner;

public class Cajero {	
	private static double saldo;
	public static void main(String[] args) {
		//while para ejecutar el reinicio al menú
		CuentaBancaria cuenta = null;
		double cantidad = 0;
		while(true) {		
		// mostrar menú
		escribirMenu();
		// pedir opcion
		pedirOpcion();
		// leer opcion
		int opcion = leerOpcion();
		// comprobar opcion		
		switch(opcion){
		//si la opcion es 0, salir
		case 0:
			System.out.println("\r\nGracias por su visita.");
			System.exit(0);
		//si la oopcion es 1, mostrar un nuevo menú
		case 1: 
			mostrarSubmenu();
			// pedir y leer opcion del submenú
			pedirOpcion();
			int opcionSubmenu = leerOpcion();
			switch(opcionSubmenu) {
			// en caso de cancelación volver al menú
			case 0:
				break;
			// pedimos que el usuario introduzca el saldo y creamos la nueva cuenta
			case 1:
				// escribir cual será el saldo inicial
				pedirSaldo();
				// leer saldo introducido
				saldo = leerSaldo();
				if (saldo < 0){
					System.out.println("\r\nLa cantidad no debe ser negativa.");
					break;
				}
				// crear cuenta
				cuenta = new CuentaNormal(saldo);
				break;
			case 2:
				// escribir cual será el saldo inicial
				pedirSaldo();				
				// leer saldo introducido
				saldo = leerSaldo();
				// crear cuenta
				cuenta = new CuentaPremium(saldo);
				break;
			default:
				System.out.println("\r\nEsta opción no es válida");
				break;			
			}
			break;
		case 2:
			// si la cuenta no está activa mostrar mensaje de error y reiniciar
			if(cuenta==null) {
				System.out.println("Debe elegir una cuenta para poder realizar este servicio.");
				break;
			}
			// pedir valor a ingresar
			System.out.println("\r\nEscriba la cantidad de dinero que desea ingresar: ");	
			// leer la cantidad introducida
			cantidad = leerSaldo();
			// ingresar cantidad
			cuenta.ingresarDinero(cantidad);
			// mostrar saldo actual
			System.out.println("El saldo de su cuenta es " + cuenta.consultarSaldo()+"€");
			break;
		case 3:
			// si la cuenta no está activa mostrar mensaje de error y reiniciar
			if(cuenta==null) {
				System.out.println("\r\nDebe elegir una cuenta para poder realizar este servicio.");
				break;
			}
			// pedir valor a retirar
			System.out.println("\r\nEscriba la cantidad de dinero que desea retirar (€): ");
			// leer la cantidad introducida
			cantidad = leerSaldo();
			// retirar cantidad
			cuenta.retirarDinero(cantidad);
			// mostrar saldo actual
			System.out.println("\r\nEl saldo de su cuenta es " + cuenta.consultarSaldo()+"€");
			break;
		case 4:
			if(cuenta==null) {
				System.out.println("\r\nPor favor, elija una cuenta para realizar esta acción.");
				break;
			}
			System.out.println("\r\nEl saldo de su cuenta es " + cuenta.consultarSaldo()+"€");
			break;
		default:
			System.out.println("\r\nEsta opción no es válida");
			break;			
		}
	}
	}
	
	private static double leerSaldo() {
			Scanner scan = new Scanner(System.in);
			return scan.nextDouble();
	}
    private static void pedirSaldo() {
		System.out.print("\r\nEscriba el saldo inicial (€): ");
		
	}
    private static void mostrarSubmenu() {
		System.out.println("\r\nTipo de cuenta\r\n" +
				"1. Cuenta normal\r\n" +
				"2. Cuenta Premium\r\n" +
				"0. Cancelar");		
	}
    private static int leerOpcion() {
		Scanner scan = new Scanner(System.in);		
		return scan.nextInt();
	}
    private static void pedirOpcion() {
		System.out.print("\r\nEscoja una opción: ");
	}
    private static void escribirMenu() {
		System.out.println("\r\nBANCO\r\n" + 
				"1. Crear cuenta\r\n" + 
				"2. Ingresar dinero\r\n" + 
				"3. Retirar dinero\r\n" + 
				"4. Consultar saldo\r\n" + 
				"0. Salir");		
	}
}
