package ar.edu.unq.po2.tpIntegrador;

public class Producto implements IItem {
	
	private String SKU;
	private String nombre;
	private String marca;
	private Double precio;
	private int descuento;
	private int stock;
	private Double peso;
	private String descripcion; //? 
	
	public Producto(String sKU, String nombre, String marca, Double precio, int descuento, int stock, Double peso,
			String descripcion) {
		
		this.SKU = sKU;
		this.nombre = nombre;
		this.marca = marca;
		this.precio = precio;
		this.descuento = descuento;
		this.stock = stock;
		this.peso = peso;
		this.descripcion = descripcion;
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

	@Override
	public Double getPrecioBaseCalculado() {
		return precio;
	}

}
