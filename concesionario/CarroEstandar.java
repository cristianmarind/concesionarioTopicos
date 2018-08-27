package concesionario;

public class CarroEstandar extends Carro{
	final String seguro = "Plan autos basico";
	final double valorHora = 1000;
	
	public CarroEstandar(String p, String m, String c, String n) {
		this.placa = p;
		this.marca = m;
		this.color = c;
		this.nroPuestos = n;
		this.dispinible = true;
	}

	@Override
	public double getValor(int nroHoras) {
		// TODO Auto-generated method stub
		return nroHoras*valorHora;
	}
	
	@Override
	public String getSeguro() {
		// TODO Auto-generated method stub
		return seguro;
	}
	
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "ESTANDAR";
	}

}
