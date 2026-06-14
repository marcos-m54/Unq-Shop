package ar.edu.unq.po2.tpIntegrador;

import java.util.ArrayList;

public class Pedido {
	
	private IEstado estado;
	private String nombreUsuario;
	private ArrayList<IItem> items = new ArrayList<IItem>();
	private ArrayList<NotaDeCredito> notasDeCredito = new ArrayList<NotaDeCredito>();
	
	public Pedido(IEstado estado) {
		
		this.estado = new Borrador(this);

	}
	
	public IEstado getEstado() {
		return estado;
	}
	
	public void setEstado(IEstado estado) {
		this.estado = estado;
	}

	
	//revisar 
	protected void agregarItem(IItem item) {
		
		if (item.getStock() > 0) {
			this.items.add(item);
		}

	}
	
	protected void quitarItem(IItem item) {
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
    
	//ver despues
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
	
	//


	public void registrarNotaDeCredito(NotaDeCredito notaDeCredito) {
		notasDeCredito.add(notaDeCredito);
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public Double montoDeReembolsoDeItems() {

		return items.stream().mapToDouble(i -> i.precioFinal()).sum();
		
	}
	
	




	

}
