package ar.edu.unq.po2.tpIntegrador.busquedaItems;

import java.util.List;

import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.IItem;

public class CriterioPorDisponibilidad implements ICriterio {
	
		
	public CriterioPorDisponibilidad() {
		super();
	}

	public List<IItem> filtrar(List<IItem> itemsDeCatalogo) {
		
		return itemsDeCatalogo.stream().filter(item -> item.getStock() > 0).toList();
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
