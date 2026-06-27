package ar.edu.unq.po2.tpIntegrador.busquedaItems;

import java.util.List;

import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.IItem;
import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.Sistema;

public class CriterioPorDisponibilidad extends Busqueda {
	
		
	public CriterioPorDisponibilidad(Sistema sistema) {
		super(sistema);
	}

	@Override
	public List<IItem> filtrar() {
		
		return super.filtrar().stream().filter(item -> item.getStock() > 0).toList();
	}

}
