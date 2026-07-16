package ar.edu.unq.po2.tpIntegrador.busquedaItems;

import java.util.List;

import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.IItem;

public class CriterioPorNombre implements ICriterio{
	
	private String nombre;

	@Override
	public List<IItem> filtrar(List<IItem> itemsDeCatalogo) {
		return itemsDeCatalogo.stream().filter(item -> item.getNombre().toLowerCase().contains(this.getNombre().toLowerCase())).toList();
	}
	
	public CriterioPorNombre(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public void agregarCriterio(ICriterio unCriterio) {
		throw new UnsupportedOperationException("No puede agregar, es un criterio simple");
		
	}

	@Override
	public void sacarCriterio(ICriterio unCriterio) {
		throw new UnsupportedOperationException("No puede sacar, es un criterio simple");
		
	}
	
}
