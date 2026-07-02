package ar.edu.unq.po2.tpIntegrador.creacionDeProductos;

import java.time.LocalDate;

import ar.edu.unq.po2.tpIntegrador.state.Pedido;

public class Venta {
	
	private LocalDate fecha;
	private Pedido pedido;
	
	public Venta(LocalDate fecha, Pedido pedido) {
		this.setFecha(fecha);
		this.setPedido(pedido);
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	

	

}
