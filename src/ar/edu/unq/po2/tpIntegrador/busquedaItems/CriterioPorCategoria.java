package ar.edu.unq.po2.tpIntegrador.busquedaItems;

import java.util.List;

import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.Categoria;
import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.IItem;
import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.Sistema;

public class CriterioPorCategoria extends Busqueda {
	
	private Categoria categoria;

	public CriterioPorCategoria(Sistema sistema) {
		super(sistema);
	}	
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public List<IItem> filtrar() {
		return super.filtrar().stream().filter(item -> item.getCategoria().equals(this.getCategoria())).toList();
	}

}
