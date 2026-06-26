package ar.edu.unq.po2.tpIntegrador.busquedaItems;

import java.util.List;
import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.IItem;


public interface ICriterio {

	public List<IItem> filtrar(List<IItem> items);
	
}
