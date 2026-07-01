package ar.edu.unq.po2.tpIntegrador.busquedaItems;

import java.util.List;

import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.IItem;

public class CriterioPrecioMax implements ICriterio{
	
	private Double precioMax;
	
	public CriterioPrecioMax(Double precioMax) {
		super();
		this.precioMax = precioMax;
	}
	
	@Override
	public List<IItem> filtrar(List <IItem> itemsDeCatalogo) {
		return itemsDeCatalogo.stream().filter(item -> item.precioFinal() <= this.getPrecioMax()).toList();
	}

	public Double getPrecioMax() {
		return precioMax;
	}

}
