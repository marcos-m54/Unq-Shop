package ar.edu.unq.po2.tpIntegrador;

public class Borrador implements IEstado {
	
	private Pedido pedido;
	
	public Borrador(Pedido pedido) {
		this.pedido = pedido;
	}
	

	@Override
	public void agregarItem(IItem item) {
		pedido.agregarItem(item);

	}

	@Override
	public void quitarItem(IItem item) {
		pedido.quitarItem(item);

	}

	@Override
	public void confirmarPedido() {
		pedido.setEstado(new Confirmado(pedido));
		pedido.decrementarStockItems();

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
