package ar.edu.unq.po2.tpIntegrador.busquedaItems;

import java.util.List;

import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.IItem;
import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.Sistema;

public abstract class Busqueda implements ICriterio {
	
	private Sistema sistema;

	public Sistema getSistema() {
		return sistema;
	}

	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}

	public Busqueda(Sistema sistema) {
		super();
		this.sistema = sistema;
	}
	
	public List<IItem> catalogo(){
		return sistema.getCatalogo();
	}
	
	@Override
	public List<IItem> filtrar() {
		return sistema.getCatalogo();
	}

}
