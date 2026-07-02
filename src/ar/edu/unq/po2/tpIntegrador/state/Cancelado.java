package ar.edu.unq.po2.tpIntegrador.state;

import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.IItem;

public class Cancelado implements IEstado {

	public Cancelado(Pedido pedido) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void agregarItem(IItem item) {
		// TODO Auto-generated method stub
	}

	@Override
	public void quitarItem(IItem item) {
		// TODO Auto-generated method stub
	}

	@Override
	public void confirmarPedido() {
		// TODO Auto-generated method stub
	}

	@Override
	public void cancelarPedido() {
		// TODO Auto-generated method stub
	}

	@Override
	public void prepararPedido() {
		// TODO Auto-generated method stub
	}

	@Override
	public void enviarPedido() {
		// TODO Auto-generated method stub
	}

	@Override
	public void entregarPedido() {
		// TODO Auto-generated method stub
	}
}
