package ar.edu.unq.po2.tpIntegrador;

public class Usuario {
	
	private String nombreUsuario;
	private Direccion direccion;
	
	public Usuario() {
		super();
	}
	
	public Usuario(String nombreUsuario, Direccion direccion) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.direccion = direccion;
	}
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
}
