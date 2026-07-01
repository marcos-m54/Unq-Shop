package ar.edu.unq.po2.tpIntegrador.busquedaItems;

import java.util.List;

import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.IItem;

public class CriterioNOT implements ICriterio {
	
	private ICriterio criterioANegar;

	public List<IItem> filtrar(List<IItem> itemsDeCatalogo) {	
		
		return itemsDeCatalogo.stream().filter(item -> !this.getCriterioANegar().filtrar(itemsDeCatalogo).contains(item)).toList(); 
	}
	
	public CriterioNOT(ICriterio criterioANegar) {
		super();
		this.criterioANegar = criterioANegar;
	}

	public ICriterio getCriterioANegar() {
		return criterioANegar;
	}
	
}
