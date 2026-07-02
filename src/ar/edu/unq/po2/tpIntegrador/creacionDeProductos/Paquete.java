package ar.edu.unq.po2.tpIntegrador.creacionDeProductos;

import java.util.ArrayList;

public class Paquete implements IItem {
	

	public String nombre;
	public String descripcion;
	public int descuento;
	public ArrayList<IItem> productos = new ArrayList<IItem>();
	
	public Paquete(String nombre, String descripcion, int descuento, ArrayList<IItem> productos) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.descuento = descuento;
		this.productos = productos;
	}

	@Override
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}
	
	@Override
	public Double getPrecioBase() {
		return this.productos.stream()
									 .mapToDouble(p -> p.getPrecioBase())
									 .sum();
	}
	
	@Override
	public Double getPeso() {
		return this.productos.stream()
									 .mapToDouble(p -> p.getPeso())
									 .sum();
	}
	
	@Override
	public Double precioFinal() {
		return this.getPrecioBase() * (1 - this.getDescuento()/ 100.0);
		
	}
	
	public void agregarItem(IItem unItem) {
		productos.add(unItem);
	}
	
	public void quitarItem(IItem unItem) {
		productos.remove(unItem);
	}
	
	//nuevo


	@Override
	public void incrementarStock() {
		productos.stream().forEach(producto -> producto.incrementarStock());
	}
	
	@Override
	public void decrementarStock() {
	    this.productos.stream().forEach(producto -> producto.decrementarStock());
	}
	
	@Override
	public int getStock() {
	    return this.productos.stream()
	                            .mapToInt(p -> p.getStock())
	                            .min()
	                            .orElse(0);
	}

	@Override
	public Categoria getCategoria() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/* 
	
	 * Dejo comentado lo viejo por las dudas
	
	@Override
	public void decrementarStock() {
		if (this.hayStockDeTodosLosItems()) {
			this.productos.stream().forEach(producto -> producto.decrementarStock());
		}
	}

	 public boolean hayStockDeTodosLosItems() {
		return this.productos.stream().allMatch(producto -> producto.getStock() > 0);
	}

	@Override
	public int getStock() {
		 if (this.hayStockDeTodosLosItems()) {
			return 1;
		 }
			else return 0;
		} 
	*/
	
}
