package concesionario;

public class Administrador {
	private String nombre;
	private String username;
	private String contraseña;
	
	public Administrador(String nombre, String username, String contraseña) {
		this.nombre = nombre;
		this.username = username;
		this.contraseña = contraseña;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
}
