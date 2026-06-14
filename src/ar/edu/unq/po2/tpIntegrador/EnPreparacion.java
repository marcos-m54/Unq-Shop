package ar.edu.unq.po2.tpIntegrador;

import java.time.LocalDate;

public class EnPreparacion implements IEstado {
	
	private Pedido pedido;

	public EnPreparacion(Pedido pedido) {
		this.pedido = pedido;
	}
	
	public Pedido getPedido() {
		return pedido;
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
		pedido.incrementarStockItems();
		pedido.registrarNotaDeCredito(new NotaDeCredito(pedido.getNombreUsuario(), LocalDate.now(), pedido.montoDeReembolsoDeItems()));

	}

	@Override
	public void prepararPedido() {
		// TODO Auto-generated method stub

	}

	@Override
	public void enviarPedido() {
		pedido.setEstado(new Enviado(pedido));

	}
	
	


}
