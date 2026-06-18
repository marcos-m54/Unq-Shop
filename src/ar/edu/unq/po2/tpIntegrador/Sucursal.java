package ar.edu.unq.po2.tpIntegrador;

import java.util.Map;

public class Sucursal {
	
	private String nombre;
	private Map<Producto, Integer> inventario;
	
	public Sucursal(String nombre, Map<Producto, Integer> inventario) {
		this.setNombre(nombre);
		this.inventario = inventario;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int stockDe(IItem item) {
		return inventario.get(item);
		 
	}
	
	

}
