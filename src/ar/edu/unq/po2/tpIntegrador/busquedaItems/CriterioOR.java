package ar.edu.unq.po2.tpIntegrador.busquedaItems;

import java.util.List;

import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.IItem;
import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.Sistema;

public class CriterioOR extends Busqueda{
	
	private List<ICriterio> criterios;

	public CriterioOR(Sistema sistema, List<ICriterio> criterios) {
		super(sistema);
		if (criterios.size() < 3) {
			this.criterios = criterios;
		}
	}
	
	public CriterioOR(Sistema sistema) {
		super(sistema);
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
	
	@Override
	public List<IItem> filtrar() {
		
		return this.unionDeCriterios();
		
	}
	
	
	public List<IItem> unionDeCriterios() {
		
		List<IItem> criterioUno = this.criterios.get(0).filtrar();
		List<IItem> criterioDos = this.criterios.get(1).filtrar();
		
		criterioUno.addAll(criterioDos);
		
		return criterioUno;
	}
	
}
