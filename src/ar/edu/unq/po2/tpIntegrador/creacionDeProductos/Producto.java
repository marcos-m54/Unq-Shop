package ar.edu.unq.po2.tpIntegrador.creacionDeProductos;

import java.util.ArrayList;

public class Producto implements IItem {
	
	private String SKU;
	private String nombre;
	private String marca;
	private Double precioBase;
	private int descuento;
	private int stock;
	private Double peso;
	private String descripcion;
	private ArrayList<Atributo> atributos = new ArrayList<Atributo>();
	private Categoria categoria;
	
	public Producto(String sKU, String nombre, String marca, Double precioBase, int descuento, int stock, Double peso,
			String descripcion, ArrayList<Atributo> atributo) {
		
		this.SKU = sKU;
		this.nombre = nombre;
		this.marca = marca;
		this.precioBase = precioBase;
		this.descuento = descuento;
		this.stock = stock;
		this.peso = peso;
		this.descripcion = descripcion;
		this.atributos = atributo;
		
	}
	
	/*
	 private Producto(Builder builder) {
		this.SKU = builder.SKU;
		this.nombre = builder.nombre;
		this.marca = builder.marca;
		this.precioBase = builder.precioBase;
		this.descuento = builder.descuento;
		this.stock = builder.stock;
		this.peso = builder.peso;
		this.descripcion = builder.descripcion;
		this.categoria = builder.categoria;
		this.atributos = builder.atributos;
	} 
	 */
	
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
	
	
	@Override
	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	@Override
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
		return precioBase;
	}

	public void setPrecio(Double precioBase) {
		this.precioBase = precioBase;
	}
	
	@Override
	public Double precioFinal() {
		return this.getPrecioBase() - ( (this.getPrecioBase() * this.getDescuento() / 100) );
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
	
	//nuevo
	
	@Override
	public void decrementarStock() {
		stock-= 1;
		
	}

	@Override
	public void incrementarStock() {
		stock+=1;
		
	}

	/*
	public static class Builder {

		// Enunciado: Sku y nombre son obligatorios
		private String SKU;
		private String nombre;

		private String marca = "";
		private Double precioBase = 0.0;
		private int descuento = 0;
		private int stock = 0;
		private Double peso = 0.0;
		private String descripcion = "";
		private Categoria categoria;
		private ArrayList<Atributo> atributos = new ArrayList<>();

		public Builder(String sku, String nombre) {
			this.SKU = sku;
			this.nombre = nombre;
		}

		public Builder marca(String marca) {
			this.marca = marca;
			return this;
		}

		public Builder precioBase(Double precioBase) {
			this.precioBase = precioBase;
			return this;
		}

		public Builder descuento(int descuento) {
			this.descuento = descuento;
			return this;
		}

		public Builder stock(int stock) {
			this.stock = stock;
			return this;
		}

		public Builder peso(Double peso) {
			this.peso = peso;
			return this;
		}

		public Builder descripcion(String descripcion) {
			this.descripcion = descripcion;
			return this;
		}

		public Builder categoria(Categoria categoria) {
			this.categoria = categoria;
			return this;
		}

		public Builder atributo(String nombre, String descripcion) {
			this.atributos.add(new Atributo(nombre, descripcion));
			return this;
		}

		public Producto build() {
			return new Producto(this);
		}
	} 
	*/
}
