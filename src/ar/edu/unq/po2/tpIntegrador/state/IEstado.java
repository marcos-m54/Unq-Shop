package ar.edu.unq.po2.tpIntegrador.state;

import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.IItem;

public interface IEstado {
	
	public void agregarItem(IItem item);
	public void quitarItem(IItem item);
	public void confirmarPedido();
	public void cancelarPedido();
	public void prepararPedido();
	public void enviarPedido();
	public void entregarPedido();
	
}
