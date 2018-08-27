package concesionario;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
	private static String username;
	private static String password;
	
	
	public static void main(String[] args) {
		Scanner sci = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
		Scanner scd = new Scanner(System.in);
		Concesionario concesionario = Concesionario.getInstance();
		System.out.println("Bienvenido al concesionario");
		System.out.println("");
		System.out.println("//Cuenta de administrador (username, password) = (admin, admin)");
		System.out.println("//Cuenta de cliente (username, password) = (profe, profe)");
		System.out.println("");
		boolean isLogged = false;
		boolean isAdmin = false;
		boolean continuar = true;
		int input = 0;
		do {
			System.out.println("");
			System.out.println("Si desea loguearse oprima la tecla (1) seguida de un enter");
			System.out.println("Si desea salir oprima otra tecla seguida de un enter");
			System.out.print("Escriba aquí: ");
			System.out.println("");
			try {
				input = sci.nextInt();
			}catch(InputMismatchException e) {
				input = 0;
			}
			if(input == 1) {
				do {
					System.out.print("Username: ");
					username = sc.nextLine();
					System.out.print("Password: ");
					password = sc.nextLine();
					isAdmin  = concesionario.isAdmin(username, password);
					if(concesionario.isClient(username , password) || isAdmin){
						isLogged = true;
						System.out.println("");
						do {
							System.out.println("Si desea ver los carros oprima (1)");
							if(!isAdmin) {
								System.out.println("Si desea prestar un carro oprima (2)");
							}else{
								System.out.println("Si desea agregar un carro oprima (3)");
								System.out.println("Si desea registrar la devolución de un carro oprima (4)");
								System.out.println("Si desea registrar un cliente oprima (5)");
								System.out.println("Si deseal listar los clientes oprima (6)");
							}
							System.out.println("Si desea salir oprima (0)");
							System.out.print("Escriba acá: ");
							try {
								input = sci.nextInt();
							}catch(InputMismatchException e) {
								input = 0;
							}
							switch(input){
								case 1:
									System.out.println("");
									for (Carro car : concesionario.getCarros()) {
										System.out.println("Tipo: "+car.getType());
										System.out.println("Marca: "+car.getPlaca());
										System.out.println("Placa: "+car.getMarca());
										System.out.println("Color: "+car.getColor());
										System.out.println("Seguro: "+car.getSeguro());
										System.out.println("Minimo valor prestamo (10 horas): "+car.getValor(10));
										System.out.println("¿Esta Disponible?: "+car.isDispinible());
										System.out.println("");
									}
									break;
								case 2:
									String placa = "";
									int nroHoras = 0;
									System.out.println("");
									System.out.print("Ingrese la placa del carro: ");
									placa = sc.nextLine();
									System.out.println("Ingrese el número de horas que lo va a utilizar: ");
									try {
										nroHoras = sci.nextInt();
									}catch(InputMismatchException e) {
										nroHoras = 0;
									}
									System.out.println(concesionario.prestar(username, password, placa, nroHoras));
									System.out.println("");
									break;
								case 3:
									System.out.println("");
									System.out.println("Ingrese el tipo de carro:");
									for (FabricaCarro.CarType item : FabricaCarro.CarType.values()) {
										System.out.println("     "+item.toString());
									}
									System.out.print("Escriba acá: ");
									String typeCar = sc.nextLine();
									System.out.println("Ingrese la placa: ");
									String placa2 = sc.nextLine();
									System.out.println("Ingrese la marca: ");
									String marca = sc.nextLine();
									System.out.println("Ingrese el color: ");
									String color = sc.nextLine();
									System.out.println("Ingrese el numero de puestos: ");
									String nroPuestos = sc.nextLine();
									System.out.println(concesionario.agregarCarro(username, password, typeCar, placa2, marca, color, nroPuestos));
									System.out.println("");
									break;
								case 4:
									System.out.println("");
									System.out.println("Ingrese la placa: ");
									String placa3 = sc.nextLine();
									System.out.println(concesionario.regresarCarro(username, password, placa3));
									System.out.println("");
									break;
								case 5:
									System.out.print("Ingrese el nombre del cliente: ");
									String nombre = sc.nextLine();
									System.out.print("Ingrese el nombre de usuario: ");
									String usernameU = sc.nextLine();
									System.out.print("Ingrese la cedula: ");
									String cedula = sc.nextLine();
									System.out.print("Ingrese el saldo inicial: ");
									double saldo = 0.0;
									try {
										saldo = scd.nextDouble();
									}catch(InputMismatchException e) {
										saldo = 0.0;
									}
									System.out.print("Ingrese la contraseña: ");
									String contraseña = sc.nextLine();
									Cliente cliente = new Cliente(nombre, usernameU, cedula, saldo, contraseña);
									System.out.print(concesionario.agregarCliente(username, password, cliente));
									System.out.print("");
									break;
								case 6:
									System.out.println("");
									for (Cliente client : concesionario.getClientes()) {
										System.out.println("Nombre: "+client.getNombre());
										System.out.println("Username: "+client.getUsername());
										System.out.println("Cedula: "+client.getCedula());
										System.out.println("");
									}
									break;
								default:
									continuar = false;
							}
						}while(continuar);
					}else {
						System.out.println("Ingresaste mal los datos de tu cuenta");
						System.out.println("");
						continuar = false;
					}
				}while(continuar);
				continuar = true;
			}else {
				continuar = false; 
			}
		}while(continuar);
	}

}
