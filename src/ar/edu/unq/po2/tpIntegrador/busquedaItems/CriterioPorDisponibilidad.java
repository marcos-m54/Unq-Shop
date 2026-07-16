package ar.edu.unq.po2.tpIntegrador.busquedaItems;

import java.util.List;

import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.IItem;
import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.Sistema;

public class CriterioPorDisponibilidad implements ICriterio {
	
	private Sistema sistema;	
		
	public CriterioPorDisponibilidad(Sistema sistema) {
		super();
		this.sistema = sistema;
	}

	public List<IItem> filtrar(List<IItem> itemsDeCatalogo) {
		
		// return itemsDeCatalogo.stream().filter(item -> item.getStock() > 0).toList();
		
		return itemsDeCatalogo.stream()
			    .filter(item -> sistema.hayStockDisponibleDe(item))
			    .toList();
	}

}
