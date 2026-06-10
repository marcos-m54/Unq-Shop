package ar.edu.unq.po2.tpIntegrador;

import java.util.ArrayList;

public class Paquete implements IItem {
	
	public String nombre;
	public String descripcion;
	public int descuento;
	public ArrayList<Producto> productos;
	
	public Paquete(String nombre, String descripcion, int descuento, ArrayList<Producto> productos) {
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
	public Double getPrecioBaseCalculado() {
		return this.productos.stream()
									 .mapToDouble(p -> p.getPrecioBaseCalculado())
									 .sum();
	}
	
	public Double precioFinal() {
		return getPrecioBaseCalculado() - this.getDescuento(); //revisar
	}
	
	public void agregarProducto(Producto producto) {
		this.productos.add(producto);
	}
	
	public void quitarProducto(Producto producto) {
		this.productos.remove(producto);
	}
	
	
	

}
