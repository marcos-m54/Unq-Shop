package ar.edu.unq.po2.tpIntegrador;

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
		return this.getPrecioBase() * (1 - this.getDescuento()); 
		
	}
	
	public void agregarItem(IItem unItem) {
		productos.add(unItem);
	}
	
	public void quitarItem(IItem unItem) {
		productos.remove(unItem);
	}


}
