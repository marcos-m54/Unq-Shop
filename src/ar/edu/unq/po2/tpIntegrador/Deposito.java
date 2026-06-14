package ar.edu.unq.po2.tpIntegrador;

import java.util.Map;

public class Deposito {
	
	
	private String nombre;
	private Map<Producto, Integer> inventario;
	
	public Deposito(String nombre, Map<Producto, Integer> inventario) {
		this.nombre = nombre;
		this.inventario = inventario;
	}
	
	/*
	public int getStockDisponible(IItem item) {
		return 
	}
	
	*/
	

	
	

}
