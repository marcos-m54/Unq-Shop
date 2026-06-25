package ar.edu.unq.po2.tpIntegrador.creacionDeProductos;


public class Usuario {
	
	private String nombreUsuario;
	private String email;
	private String direccion;


	public Usuario(String nombreUsuario, String email, String direccion) {
		this.nombreUsuario = nombreUsuario;
		this.setEmail(email);
		this.setDireccion(direccion);
	}
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
}
