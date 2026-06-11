package ar.edu.unq.po2.tpIntegrador;

import java.util.ArrayList;

public class Producto implements IItem {
	
	private String SKU;
	private String nombre;
	private String marca;
	private Double precio;
	private int descuento;
	private int stock;
	private Double peso;
	private String descripcion;
	private ArrayList<Atributo> atributos = new ArrayList<Atributo>();
	private Categoria categoria;
	
	public Producto(String sKU, String nombre, String marca, Double precio, int descuento, int stock, Double peso,
			String descripcion, ArrayList<Atributo> atributo) {
		
		this.SKU = sKU;
		this.nombre = nombre;
		this.marca = marca;
		this.precio = precio;
		this.descuento = descuento;
		this.stock = stock;
		this.peso = peso;
		this.descripcion = descripcion;
		this.atributos = atributo;
		
	}
	
	public String getSKU() {
		return SKU;
	}

	public void setSKU(String sKU) {
		SKU = sKU;
	}
	
	@Override
	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String nombreP) {
		nombre = nombreP;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}


	@Override
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	
	public void agregarAtributo(String nombre, String descripcion) {
		this.atributos.add(new Atributo(nombre, descripcion));
	}
	
	@Override
	public Double getPrecioBase() {
		return precio;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public ArrayList<Atributo> getAtributos() {
		return atributos;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	

}
