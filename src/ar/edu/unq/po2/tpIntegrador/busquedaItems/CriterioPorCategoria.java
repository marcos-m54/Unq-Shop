package ar.edu.unq.po2.tpIntegrador.busquedaItems;

import java.util.List;

import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.Categoria;
import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.IItem;

public class CriterioPorCategoria implements ICriterio {
	
	private Categoria categoria;

	public CriterioPorCategoria(Categoria categoria) {
		super();
		this.categoria = categoria;
	}	
	
	public Categoria getCategoria() {
		return categoria;
	}

	public List<IItem> filtrar(List<IItem> itemsDeCatalogo) {
		return itemsDeCatalogo.stream().filter(item -> item.getCategoria().equals(this.getCategoria())).toList();
	}

	@Override
	public void agregarCriterio(ICriterio unCriterio) {
		throw new UnsupportedOperationException("No puede agregar, es un criterio simple");
	}

	@Override
	public void sacarCriterio(ICriterio unCriterio) {
		throw new UnsupportedOperationException("No puede sacar, es un criterio simple");
	}

}
