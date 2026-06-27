package ar.edu.unq.po2.tpIntegrador.busquedaItems;

import java.util.List;

import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.IItem;
import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.Sistema;

public class CriterioPorNombre extends Busqueda{
	
	private String nombre;

	@Override
	public List<IItem> filtrar() {
		return super.filtrar().stream().filter(item -> item.getNombre().contains(this.getNombre().toLowerCase())).toList();
	}
	
	public CriterioPorNombre(Sistema sistema, String nombre) {
		super(sistema);
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
