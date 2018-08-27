package concesionario;

public class CarroFamiliar extends Carro{
	final String seguro = "Plan autos clasico";
	final double valorHora = 800;
	
	public CarroFamiliar(String p, String m, String c, String n) {
		this.placa = p;
		this.marca = m;
		this.color = c;
		this.nroPuestos = n;
		this.dispinible = true;
	}
	
	@Override
	public double getValor(int nroHoras) {
		// TODO Auto-generated method stub
		return (nroHoras+5)*valorHora;
	}

	@Override
	public String getSeguro() {
		// TODO Auto-generated method stub
		return seguro;
	}
	
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "FAMILIAR";
	}

}
