package ar.edu.unq.po2.tpIntegrador.busquedaItems;

import java.util.List;

import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.IItem;

public class CriterioPorNombre implements ICriterio {
	
	private String nombre;

	@Override
	public List<IItem> filtrar(List<IItem> items) {
		return items.stream().filter(item -> item.getNombre().contains(this.getNombre().toLowerCase())).toList();
	}
	
	public CriterioPorNombre(String nombre) {
		super();
		this.nombre = nombre.toLowerCase();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
