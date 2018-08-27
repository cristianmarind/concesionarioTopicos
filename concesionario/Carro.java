package concesionario;

public abstract class Carro {
	protected String placa;
	protected String marca;
	protected String color;
	protected String nroPuestos;
	protected boolean dispinible;
	
	public boolean isDispinible() {
		return dispinible;
	}

	public void setDispinible(boolean dispinible) {
		this.dispinible = dispinible;
	}

	public abstract double getValor(int nroHoras);

	public String getPlaca() {
		return placa;
	}


	public void setPlaca(String placa) {
		this.placa = placa;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getNroPuestos() {
		return nroPuestos;
	}


	public void setNroPuestos(String nroPuestos) {
		this.nroPuestos = nroPuestos;
	}


	public abstract String getSeguro();
	
	public abstract String getType();
}
