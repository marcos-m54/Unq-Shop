package ar.edu.unq.po2.tpIntegrador.busquedaItems;

import java.util.List;

import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.IItem;
import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.Sistema;

public class CriterioPorDisponibilidad implements ICriterio {
	
	//private Sistema eCommerce;

	@Override
	public List<IItem> filtrar(List<IItem> items) {
		
		return items.stream().filter(item -> item.getStock() > 0).toList();
	}

}
