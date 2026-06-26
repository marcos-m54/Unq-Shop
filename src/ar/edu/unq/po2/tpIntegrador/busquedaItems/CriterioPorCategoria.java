package ar.edu.unq.po2.tpIntegrador.busquedaItems;

import java.util.List;

import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.IItem;

public class CriterioPorCategoria implements ICriterio {
	
	private Categoria categoria;

	@Override
	public List<IItem> filtrar(List<IItem> items) {
		return items.stream().filter(item -> item.get);
	}

}
