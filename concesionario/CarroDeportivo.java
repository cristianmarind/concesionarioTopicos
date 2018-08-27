package concesionario;

public class CarroDeportivo extends Carro{
	final String seguro = "Plan conduce mejor";
	final double valorHora = 1000;
	
	public CarroDeportivo(String p, String m, String c, String n) {
		this.placa = p;
		this.marca = m;
		this.color = c;
		this.nroPuestos = n;
		this.dispinible = true;
	}
	
	@Override
	public double getValor(int nroHoras) {
		// TODO Auto-generated method stub
		return (nroHoras+10)*valorHora;
	}
	
	@Override
	public String getSeguro() {
		// TODO Auto-generated method stub
		return seguro;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "DEPORTIVO";
	}
	

}
