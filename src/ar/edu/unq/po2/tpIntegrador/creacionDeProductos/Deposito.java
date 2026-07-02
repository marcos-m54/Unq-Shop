package ar.edu.unq.po2.tpIntegrador.creacionDeProductos;

import java.util.ArrayList;

public class Deposito {
	
	private String nombre;
	private ArrayList<IItem> items = new ArrayList<IItem>();
	
	public Deposito(String nombre, ArrayList<IItem> items) {
		this.nombre = nombre;
		this.items = items;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<IItem> getItems() {
		return items;
	}

	public void setItem(IItem item) {
		this.items.add(item);
	}
	
	public int getStockDe(IItem item) {
		return item.getStock();
	}
}
