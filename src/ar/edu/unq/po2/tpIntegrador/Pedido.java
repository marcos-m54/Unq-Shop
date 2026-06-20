package ar.edu.unq.po2.tpIntegrador;

import java.util.ArrayList;

public class Pedido {
	
	private IEstado estado;
	//quizas haya que hacer una clase de usuario con sus respectivos datos
	private Usuario usuario;
	private ArrayList<IItem> items = new ArrayList<IItem>();
	private ArrayList<NotaDeCredito> notasDeCredito = new ArrayList<NotaDeCredito>();
	private IFormaDeEnvio formaDeEnvio;
	
	
	public Pedido(Usuario usuario, ArrayList<IItem> productosOPaquetes) {
		super();
		this.estado = new Borrador(this);
		this.usuario = usuario;
		this.items = productosOPaquetes;
	}
	
	public Pedido(Usuario usuario) {
		super();
		this.estado = new Borrador(this);
		this.usuario = usuario;
	}

	public ArrayList<IItem> getItems() {
		return items;
	}

	public ArrayList<NotaDeCredito> getNotasDeCredito() {
		return notasDeCredito;
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


	public Double montoDeReembolsoDeItems() {

		return items.stream().mapToDouble(i -> i.precioFinal()).sum();
		
	}

	public IFormaDeEnvio getFormaDeEnvio() {
		return formaDeEnvio;
	}

	public void setFormaDeEnvio(IFormaDeEnvio formaDeEnvio) {
		this.formaDeEnvio = formaDeEnvio;
	}

	public Float calcularValorDeEnvio(Pedido pedido) {
		return this.getFormaDeEnvio().calcularValorDelEnvio(pedido);
	}
	
	public Double pesoTotalDePedido() {
		return this.items.stream().mapToDouble(i -> i.getPeso()).sum();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	


	

	

}
