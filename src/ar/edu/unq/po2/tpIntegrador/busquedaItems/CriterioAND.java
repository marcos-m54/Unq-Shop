package ar.edu.unq.po2.tpIntegrador.busquedaItems;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.IItem;

public class CriterioAND implements ICriterio{
	
	private List<ICriterio> criterios = new ArrayList<ICriterio>();
	
	public CriterioAND(List<ICriterio> criterios) {
		super();
		if (criterios.size() < 3) {
			this.criterios = criterios;
		}
	}
	
	public CriterioAND() {
		super();
	}
	
	public List<ICriterio> getCriterios() {
		return criterios;
	}

	public void setCriterios(List<ICriterio> criterios) {
		this.criterios = criterios;
	}
	
	@Override
	public void agregarCriterio(ICriterio criterioBusqueda) {
		if (criterios.size() < 3) {
			criterios.add(criterioBusqueda);
		}
	}
	@Override
	public void sacarCriterio(ICriterio criterioBusqueda) {
		if (criterios.size() > 0) {
			criterios.remove(criterioBusqueda);
		}
	}	
	
	public List<IItem> filtrar(List<IItem> itemsDeCatalogo) {
		
		return this.interseccionItems(itemsDeCatalogo);
		
	}
	
	public List<IItem> interseccionItems(List<IItem> itemsDeCatalogo) {
		
		List<IItem> criterioUno = this.criterios.get(0).filtrar(itemsDeCatalogo);
		List<IItem> criterioDos = this.criterios.get(1).filtrar(itemsDeCatalogo);
			
		return criterioUno.stream()
                .filter(item -> criterioDos.contains(item))
                .collect(Collectors.toCollection(ArrayList::new));
	}
		
}
