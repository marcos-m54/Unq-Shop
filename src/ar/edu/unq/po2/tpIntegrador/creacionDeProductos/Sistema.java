package ar.edu.unq.po2.tpIntegrador.creacionDeProductos;

import java.util.ArrayList;

public class Sistema {
	
	private ArrayList<IItem> catalogo = new ArrayList<IItem>(); 
	
	private ArrayList<Sucursal> sucursales = new ArrayList<Sucursal>();


	public void agregarItem(IItem item) {
		catalogo.add(item);
	}
	
	public void sacarItem(IItem item) {
		catalogo.remove(item);
	}

	public ArrayList<Sucursal> getSucursales() {
		return sucursales;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursales.add(sucursal);
	}

	
	
	/*
	
	public void nuevoPedido{}
	 
	*/
	

	
}
