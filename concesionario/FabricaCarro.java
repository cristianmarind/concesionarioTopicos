package concesionario;

public class FabricaCarro {
	public enum CarType {
		FAMILIAR, ESTANDAR, DEPORTIVO
    }
	public Carro getCarro(CarType typeCar, String placa, String marca, String color, String nroPuestos) {
		Carro carro = null;
		switch(typeCar) {
			case FAMILIAR:
				carro = new CarroFamiliar(placa, marca, color, nroPuestos);
				break;
			case ESTANDAR:
				carro = new CarroEstandar(placa, marca, color, nroPuestos);
				break;
			case DEPORTIVO:
				carro = new CarroDeportivo(placa, marca, color, nroPuestos);
				break;
			default:
				System.out.println("El tipo de carro esta incorrecto");
		}
		return carro;
	}
}
