package ar.edu.unq.po2.tpIntegrador.creacionDeProductos;

public interface IItem {
	
	public String getNombre();
	
	public String getDescripcion();
	
	public Double getPeso();
	
	public Double getPrecioBase();
	
	public Double precioFinal();
	
	// public int getStock();
	
	public Categoria getCategoria();

	// public void decrementarStock();

	// public void incrementarStock();
	
	// Stock: Estos metodos ya no tienen sentido porque ahora el stock vive en el deposito
}
