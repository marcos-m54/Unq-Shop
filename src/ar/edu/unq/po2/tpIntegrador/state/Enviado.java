package ar.edu.unq.po2.tpIntegrador.state;

import java.time.LocalDate;

import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.IItem;

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
		pedido.setEstado(new Entregado(pedido));
	
	}

	@Override
	public void cancelarPedido() {
		pedido.setEstado(new Cancelado(pedido));
		pedido.registrarNotaDeCredito(new NotaDeCredito(pedido.getUsuario().getNombreUsuario(), LocalDate.now(), pedido.montoTotal()));
	}

	@Override
	public void prepararPedido() {
		// TODO Auto-generated method stub
	}

	@Override
	public void enviarPedido() {
	}

	@Override
	public String infoEstado() {
		return "Enviado";
	}
}
