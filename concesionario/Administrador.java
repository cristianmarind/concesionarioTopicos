package concesionario;

public class Administrador {
	private String nombre;
	private String username;
	private String contrase�a;
	
	public Administrador(String nombre, String username, String contrase�a) {
		this.nombre = nombre;
		this.username = username;
		this.contrase�a = contrase�a;
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
	public String getContrase�a() {
		return contrase�a;
	}
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
}
