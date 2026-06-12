package ar.edu.unq.po2.tpIntegrador;

import java.util.ArrayList;

public class Sistema {
	
	private ArrayList<IItem> productos = new ArrayList<IItem>(); 


	public void agregarProductoOPaquete(IItem item) {
		productos.add(item);
	}
	
	public void sacarProductoOPaquete(IItem item) {
		productos.remove(item);
	}
	
	/*
	
	public void nuevoPedido{}
	 
	*/
	
	/* metodo para obtener el catalogo? 
	 
	public Catalogo getCatalogo() {
		return this.catalogo;
		
	}
	*/
	
}
