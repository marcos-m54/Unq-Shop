package ar.edu.unq.po2.tpIntegrador;

public class Enviado implements IEstado {
	
	private Pedido pedido;

	public Enviado(Pedido pedido) {
		this.pedido = pedido;
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
	public void entregarPedido() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelarPedido() {
		pedido.setEstado(new Cancelado(pedido));
		pedido.reembolsarCostoItems();

	}

	@Override
	public void prepararPedido() {
		// TODO Auto-generated method stub

	}

	@Override
	public void enviarPedido() {
		pedido.setEstado(new Entregado(pedido));

	}

}
