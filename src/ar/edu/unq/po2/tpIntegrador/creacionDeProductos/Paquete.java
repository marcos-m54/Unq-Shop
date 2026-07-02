package ar.edu.unq.po2.tpIntegrador.creacionDeProductos;

import java.util.ArrayList;

public class Paquete implements IItem {
	
	private String nombre;
	private String descripcion;
	private int descuento;
	private ArrayList<IItem> productos = new ArrayList<IItem>();
	private Categoria categoria;
	
	public Paquete(String nombre, String descripcion, int descuento, ArrayList<IItem> productos) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.descuento = descuento;
		this.productos = productos;
		this.categoria = null;
	}
	
	public Paquete(String nombre, String descripcion, int descuento, ArrayList<IItem> productos, Categoria categoria) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.descuento = descuento;
		this.productos = productos;
		this.categoria = categoria;
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
		return categoria;
	}
	
	
	
	/*
	@Override
	public Categoria getCategoria() {
	
		return categoria;
	}
	
	*/
	
}