package ar.edu.unq.po2.tpIntegrador.busquedaItems;

import java.util.List;

import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.Categoria;
import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.IItem;

public class CriterioPorCategoria implements ICriterio {
	
	private Categoria categoria;

	public CriterioPorCategoria() {
		super();
	}	
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<IItem> filtrar(List<IItem> itemsDeCatalogo) {
		return itemsDeCatalogo.stream().filter(item -> item.getCategoria().equals(this.getCategoria())).toList();
	}

}
