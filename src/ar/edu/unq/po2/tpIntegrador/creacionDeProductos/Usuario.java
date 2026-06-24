package ar.edu.unq.po2.tpIntegrador.creacionDeProductos;

import ar.edu.unq.po2.tpIntegrador.pago.MetodoDePago;

public class Usuario {
	
	private String nombreUsuario;
	private String email;
	private String direccion;
	//private MedioDePago formaDePago;

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
	/*
	public MetodoDePago getFormaDePago() {
		return formaDePago;
	}
	*/

	public void setFormaDePago(MetodoDePago formaDePago) {
		this.formaDePago = formaDePago;
	}

}
