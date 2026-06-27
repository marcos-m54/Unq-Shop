package ar.edu.unq.po2.tpIntegrador.creacionDeProductos;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.tpIntegrador.busquedaItems.CriterioBusqueda;
import ar.edu.unq.po2.tpIntegrador.busquedaItems.ICriterio;

public class Sistema {
		
	private ArrayList<IItem> catalogo = new ArrayList<IItem>(); 
	private ArrayList<Sucursal> sucursales = new ArrayList<Sucursal>();
	private CriterioBusqueda busquedaCatalogo;
	


	public ArrayList<IItem> getCatalogo() {
		return catalogo;
	}

	public void setCatalogo(ArrayList<IItem> catalogo) {
		this.catalogo = catalogo;
	}

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
	
	public ArrayList<IItem> busqueda() {
		return ;
	}
	
	/*
	
	public void nuevoPedido{}
	 
	*/
	

	
}
