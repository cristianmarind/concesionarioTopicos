package concesionario;

import java.util.ArrayList;

public class Validador {
	public static boolean isAdmin(Administrador admin, String username, String password) {
		if(admin.getUsername().equals(username) && admin.getContraseña().equals(password)) {
			return true;
		}
		return false;
	}
	
	public static Cliente isClient(String username, String password, ArrayList<Cliente> clientes){
		for (Cliente cliente : clientes) {
			if(cliente.getUsername().equals(username) && cliente.getContraseña().equals(password)) {
				return cliente;
			}
		}
		return null;
	}
	
	public static FabricaCarro.CarType isTypeCar(String type) {
		for (FabricaCarro.CarType item : FabricaCarro.CarType.values()) {
			if(type.equals(item.toString())) {
				return item;
			}
		}
		return null;
	}
	
	public static boolean plateIsValid(String plate, ArrayList<Carro> carros) {
		for (Carro carro : carros) {
			if(plate.equals(carro.getMarca())) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean loanIsValid(Cliente cliente, Carro car, int nroHoras) {
		if(cliente.getSaldo() >= car.getValor(nroHoras)) {
			return true;
		}
		return false;
	}
	
}
