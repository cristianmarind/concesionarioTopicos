package concesionario;

import java.util.ArrayList;

import concesionario.FabricaCarro.CarType;

public class Concesionario {
	private static Concesionario concesionario;
	private final Administrador admin = new Administrador("Admin", "admin", "admin");
	private ArrayList<Cliente> clientes;
	private FabricaCarro fabrica;
	private ArrayList<Prestamo> prestamos;
	private ArrayList<Carro> carros;
	
	private Concesionario() {
		clientes = new ArrayList<Cliente>();
		prestamos = new ArrayList<Prestamo>();
		carros = new ArrayList<Carro>();
		fabrica = new FabricaCarro();
		//Entrando los datos iniciales al sistema
		clientes.add(new Cliente("Profe", "profe", "1152965735", 10000000000.00, "profe"));
		agregarCarro(admin.getUsername(),admin.getContraseña(), "FAMILIAR", "KJS858", "Montero Mitsubishi", "Rojo", "4");
		agregarCarro(admin.getUsername(),admin.getContraseña(), "FAMILIAR", "KJS859", "Montero Mitsubishi", "Rojo", "4");
		agregarCarro(admin.getUsername(),admin.getContraseña(), "DEPORTIVO", "LÑO999", "Lamborghini", "Negro", "2");
		agregarCarro(admin.getUsername(),admin.getContraseña(), "DEPORTIVO", "LÑO998", "Lamborghini", "Negro", "2");
		agregarCarro(admin.getUsername(),admin.getContraseña(), "ESTANDAR", "PFG252", "Chevrolet spark", "Azul", "4");
		agregarCarro(admin.getUsername(),admin.getContraseña(), "ESTANDAR", "PFG253", "Chevrolet spark", "Azul", "4");
	}
	
	public String agregarCarro(String adminUsername, String adminPassword, String typeCar, 
								String placa, String marca, String color, String nroPuestos) {
		if(!Validador.isAdmin(admin, adminUsername, adminPassword)) {
			return "Debe de loguearse como admin";
		}
		FabricaCarro.CarType type = Validador.isTypeCar(typeCar);
		if(type == null) {
			return "Debe de elejir un tipo de carro correcto";
		}
		if(!Validador.plateIsValid(placa, carros)) {
			return "La placa ya esta en uso";
		}
		Carro newCar = fabrica.getCarro(type, placa, marca, color, nroPuestos);
		carros.add(newCar);
		return "Se a insertado el carro con exito";
	}
	
	public static Concesionario getInstance() {
		if(concesionario == null) {
			concesionario = new Concesionario();
		}
		return concesionario;
	}
	
	public String prestar(String clientUsername, String clientPassword, String placa, int nroHoras) {
		Carro carro = null;
		Cliente cliente = Validador.isClient(clientUsername, clientPassword, clientes);
		if(cliente == null) {
			return "Debes de iniciar sesion con un cliente valido";
		}
		if(nroHoras <= 10) {
			return "Debes de prestarlo por mas de 10 horas";
		}
		for (Carro item : carros) {
			if(item.getPlaca().equals(placa)) {
				carro = item;
				if(!carro.isDispinible()) {
					return "El carro no esta disponible";
				}
				break;
			}
		}
		if(carro == null) {
			return "La placa que ingreso esta erronea";
		}
		if(!Validador.loanIsValid(cliente, carro, nroHoras)) {
			return "No tiene suficiente saldo";
		}
		if(!carro.isDispinible()) {
			return "El carro no esta disponible";
		}
		Prestamo p = new Prestamo(cliente, carro, nroHoras, carro.getValor(nroHoras));
		prestamos.add(p);
		carro.setDispinible(false);
		return "Presto el carro con exito";
	}
	
	public String regresarCarro(String adminUsername, String adminPassword, String placa) {
		Carro carro = null;
		if(!Validador.isAdmin(admin, adminUsername, adminPassword)) {
			return "Debe de loguearse como admin";
		}
		for (Carro item : carros) {
			if(item.getPlaca().equals(placa)) {
				carro = item;
				if(carro.isDispinible()) {
					return "El carro marcado no esta prestado actualmente, revisar";
				}
				break;
			}
		}
		if(carro == null) {
			return "La placa proporcionada esta erronea";
		}
		carro.setDispinible(true);
		return "El carro se entrego correctamente";
	}
	
	public String agregarCliente(String adminUsername, String adminPassword, Cliente cliente) {
		if(!Validador.isAdmin(admin, adminUsername, adminPassword)) {
			return "Debe de loguearse como admin";
		}
		if(cliente == null) {
			return "Se creo mal el cliente, vuelva a intentar";
		}
		Cliente aux = Validador.isClient(cliente.getUsername(), cliente.getContraseña(), clientes);
		if(aux != null) {
			return "El cliente ya existe";
		}
		clientes.add(cliente);
		return "Se inserto el usuario correctamente";
	}
	
	public boolean isClient(String clientUsername, String clientPassword) {
		Cliente cliente = Validador.isClient(clientUsername, clientPassword, clientes);
		if(cliente == null) {
			return false;
		}
		return true;
	}
	
	public boolean isAdmin(String adminUsername, String adminPassword) {
		if(Validador.isAdmin(admin, adminUsername, adminPassword)) {
			return true;
		}
		return false;
	}
	
	public ArrayList<Carro> getCarros(){
		return carros;
	}
	
	public ArrayList<Cliente> getClientes(){
		return clientes;
	}
}
