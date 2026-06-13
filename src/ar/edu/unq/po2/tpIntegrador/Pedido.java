package ar.edu.unq.po2.tpIntegrador;

import java.util.ArrayList;

public class Pedido {
	
	private IEstado estado;
	private ArrayList<IItem> items;
	
	public Pedido(IEstado estado) {
		
		this.estado = new Borrador(this);
		this.items = new ArrayList<IItem>();
	}
	
	public IEstado getEstado() {
		return estado;
	}
	
	public void setEstado(IEstado estado) {
		this.estado = estado;
	}

	public ArrayList<IItem> getItems() {
		return items;
	}
	
	//revisar 
	 void agregarItem(IItem item) {
		this.items.add(item);
	}
	
	 void quitarItem(IItem item) {
		 this.items.remove(item);
	}
	 //
	
	public void confirmarPedido() {
		estado.confirmarPedido();
	}
	
	public void cancelarPedido() {
		estado.cancelarPedido();
	}
	
	public void prepararPedido() {
		estado.prepararPedido();
	}
	
	public void enviarPedido() {
		estado.enviarPedido();
		
	}
	
	public void decrementarStockItems() {
		
		for (IItem item: items) {
			item.decrementarStock();
		}
		
	}

	public void incrementarStockItems() {
		for (IItem item: items) {
			item.incrementarStock();
		}
		
	}

	public void reembolsarCostoItems() {
		// TODO Auto-generated method stub
		
	}

	public void reembolsarCostoEnvio() {
		// TODO Auto-generated method stub
		
	}
	
	

}
