package ar.edu.unq.po2.tpIntegrador.busquedaItems;

import java.util.List;

import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.IItem;

public class CriterioPrecioMax implements ICriterio{
	
	private Double precioMax;

	@Override
	public List<IItem> filtrar(List<IItem> items) {
		return items.stream().filter(item -> item.precioFinal() <= this.getPrecioMax()).toList();
	}
	
	public CriterioPrecioMax(Double precioMax) {
		super();
		this.precioMax = precioMax;
	}

	public Double getPrecioMax() {
		return precioMax;
	}

	public void setPrecioMax(Double precioMax) {
		this.precioMax = precioMax;
	}

}
