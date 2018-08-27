package concesionario;

public class Prestamo {
	private Cliente cliente;
	private Carro carro;
	private int numeroHoras;
	private double valor;
	
	public Prestamo(Cliente cliente, Carro carro, int numeroDias, double valor) {
		this.cliente = cliente;
		this.carro = carro;
		this.numeroHoras = numeroDias;
		this.valor = valor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public int getNumeroDias() {
		return numeroHoras;
	}

	public void setNumeroDias(int numeroHoras) {
		this.numeroHoras = numeroHoras;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
}
