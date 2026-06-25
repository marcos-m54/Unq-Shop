package ar.edu.unq.po2.tpIntegrador.state;

import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.IItem;

public class Borrador implements IEstado {
	
	private Pedido pedido;
	
	public Borrador(Pedido pedido) {
		this.pedido = pedido;
	}
	

	@Override
	public void agregarItem(IItem item) {
		pedido.agregarItemACarrito(item);

	}

	@Override
	public void quitarItem(IItem item) {
		pedido.quitarItemDeCarrito(item);

	}

	@Override
	public void confirmarPedido() {
		if (pedido.getFormaDeEnvio() != null) {
			
		pedido.realizarPago();
		pedido.setEstado(new Confirmado(pedido));
		pedido.decrementarStockItems();
				
		}
	
	}

	@Override
	public void cancelarPedido() {
		pedido.setEstado(new Cancelado(pedido));

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
