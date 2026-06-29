package ar.edu.unq.po2.tpIntegrador.state;

import java.time.LocalDate;

import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.IItem;

public class Confirmado implements IEstado {
	
	private Pedido pedido;

	public Confirmado(Pedido pedido) {
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

	// Nota Yami: agregue el registrar nota de credito.
	@Override
	public void cancelarPedido() {
		pedido.setEstado(new Cancelado(pedido));
		pedido.incrementarStockItems();
		pedido.registrarNotaDeCredito(new NotaDeCredito(pedido.getUsuario().getNombreUsuario(), LocalDate.now(), pedido.montoTotalPedidoMasEnvio()));
	}

	@Override
	public void prepararPedido() {
		pedido.setEstado(new EnPreparacion(pedido));
	}

	@Override
	public void enviarPedido() {
		// TODO Auto-generated method stub
	}



}
