package ar.edu.unq.po2.tpIntegrador.busquedaItems;

import java.util.List;

import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.IItem;
import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.Sistema;

public class CriterioPrecioMax extends Busqueda{
	
	private Double precioMax;
	
	public CriterioPrecioMax(Sistema sistema, Double precioMax) {
		super(sistema);
		this.precioMax = precioMax;
	}
	
	@Override
	public List<IItem> filtrar() {
		return super.filtrar().stream().filter(item -> item.precioFinal() <= this.getPrecioMax()).toList();
	}

	public Double getPrecioMax() {
		return precioMax;
	}

	public void setPrecioMax(Double precioMax) {
		this.precioMax = precioMax;
	}

}
