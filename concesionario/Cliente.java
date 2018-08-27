package concesionario;

public class Cliente {
	private String nombre;
	private String username;
	private String cedula;
	private double saldo;
	private String contrase�a;
	
	public Cliente(String nombre, String username, String cedula, double saldo, String contrase�a) {
		this.nombre = nombre;
		this.setUsername(username);
		this.cedula = cedula;
		this.saldo = saldo;
		this.contrase�a = contrase�a;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public String getContrase�a() {
		return contrase�a;
	}
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
