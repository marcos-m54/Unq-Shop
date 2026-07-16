package ar.edu.unq.po2.tpIntegrador.creacionDeProductos;

// import java.util.ArrayList;

import java.util.HashMap;
import java.util.Map;

public class Deposito {
	
	private String nombre;
	// private ArrayList<IItem> items = new ArrayList<IItem>();
	private Map<IItem, Integer> stock = new HashMap<>();
	
	/*public Deposito(String nombre, ArrayList<IItem> items) {
		this.nombre = nombre;
		this.items = items;
	}*/
	
	public Deposito(String nombre) {
        this.nombre = nombre;
    }
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	// Stock
	// Agrega stock de un item a este deposito
    public void agregarStock(IItem item, int cantidad) {
        stock.put(item, stock.getOrDefault(item, 0) + cantidad);
    }
    
    // Devuelve el stock de un item en ESTE deposito
    public int getStockDe(IItem item) {
        return stock.getOrDefault(item, 0);
    }
 
    // Decrementa el stock de un item en ESTE deposito
    public void decrementarStock(IItem item) {
        int actual = getStockDe(item);
        if (actual > 0) {
            stock.put(item, actual - 1);
        }
    }
    
    // Incrementa el stock de un item en ESTE deposito
    public void incrementarStock(IItem item) {
        stock.put(item, getStockDe(item) + 1);
    }
    
    public Map<IItem, Integer> getStock() {
        return stock;
    }

	/*public ArrayList<IItem> getItems() {
		return items;
	}

	public void setItem(IItem item) {
		this.items.add(item);
	}
	
	public int getStockDe(IItem item) {
		return item.getStock();
	}*/
}
