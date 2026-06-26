package ar.edu.unq.po2.tpIntegrador.creacionDeProductos;

import ar.edu.unq.po2.tpIntegrador.state.Pedido;

public class Sucursal {
	
	private String nombre;
	private Deposito deposito;
	
	public Sucursal(String nombre, Deposito deposito) {
		this.nombre = nombre;
		this.deposito = deposito;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Deposito getDeposito() {
		return deposito;
	}

	public void setDeposito(Deposito deposito) {
		this.deposito = deposito;
	}
	
	public boolean hayStockDe(IItem item) {
		return this.deposito.getStockDe(item) > 0;
	}
	
	public boolean hayStockDeItemsDePedido (Pedido pedido) {
		return pedido.getItems()
				.stream()
	            .allMatch(item -> this.hayStockDe(item));
	}
	

}
