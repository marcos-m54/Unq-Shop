package ar.edu.unq.po2.tpIntegrador.creacionDeProductos;

public class Atributo {
	
	private String nombre;
	private String descripcion;
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String nombreP) {
		nombre = nombreP;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Atributo(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
}
