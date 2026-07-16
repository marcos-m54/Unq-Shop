package ar.edu.unq.po2.tpIntegrador.busquedaItems;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.IItem;

public class CriterioOR implements ICriterio{
	
	private List<ICriterio> criterios = new ArrayList<ICriterio>();
	
	@Override
	public void agregarCriterio(ICriterio criterioBusqueda) {
		if (criterios.size() < 3) {
			criterios.add(criterioBusqueda);
		}
	}
	
	@Override
	public void sacarCriterio(ICriterio criterioBusqueda) {
		criterios.remove(criterioBusqueda);
	}	
	
	public List<IItem> filtrar(List<IItem> itemsDeCatalogo) {
		
		return this.unionDeCriterios(itemsDeCatalogo);
		
	}
	
	
	public List<IItem> unionDeCriterios(List<IItem> itemsDeCatalogo) {
		
		List<IItem> criterioUno = this.criterios.get(0).filtrar(itemsDeCatalogo);
		List<IItem> criterioDos = this.criterios.get(1).filtrar(itemsDeCatalogo);
		
	    List<IItem> resultadoUnion = new ArrayList<>(criterioUno);
	    
	    for (IItem item : criterioDos) {
	        if (!resultadoUnion.contains(item)) {
	            resultadoUnion.add(item);
	        }
	    }
	    
	    return resultadoUnion;
	}
		
	
	
}
