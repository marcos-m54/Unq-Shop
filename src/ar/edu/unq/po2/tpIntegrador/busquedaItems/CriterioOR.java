package ar.edu.unq.po2.tpIntegrador.busquedaItems;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.IItem;

public class CriterioOR implements ICriterio{
	
	private List<ICriterio> criterios = new ArrayList<ICriterio>();

	public CriterioOR(List<ICriterio> criterios) {
		super();
		if (criterios.size() < 3) {
			this.criterios = criterios;
		}
	}
	
	public CriterioOR() {
		super();
	}

	public List<ICriterio> getCriterios() {
		return criterios;
	}

	public void setCriterios(List<ICriterio> criterios) {
		this.criterios = criterios;
	}
	
	public void agregarCriterioBusqueda(ICriterio criterioBusqueda) {
		if (criterios.size() < 3) {
			criterios.add(criterioBusqueda);
		}
	}
	
	public void sacarCriterioBusqueda(ICriterio criterioBusqueda) {
		criterios.remove(criterioBusqueda);
	}	
	
	public List<IItem> filtrar(List<IItem> itemsDeCatalogo) {
		
		return this.unionDeCriterios(itemsDeCatalogo);
		
	}
	
	
	public List<IItem> unionDeCriterios(List<IItem> itemsDeCatalogo) {
		
		List<IItem> criterioUno = this.criterios.get(0).filtrar(itemsDeCatalogo);
		List<IItem> criterioDos = this.criterios.get(1).filtrar(itemsDeCatalogo);
		
		criterioUno.addAll(criterioDos);
		
		return criterioUno;
	}
	
}
