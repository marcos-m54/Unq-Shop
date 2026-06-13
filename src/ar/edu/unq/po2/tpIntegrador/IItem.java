package ar.edu.unq.po2.tpIntegrador;

public interface IItem {
	
	public String getNombre();
	
	public String getDescripcion();
	
	public Double getPeso();
	
	public Double getPrecioBase();
	
	public Double precioFinal();

	public void decrementarStock();

	public void incrementarStock();
	
}
