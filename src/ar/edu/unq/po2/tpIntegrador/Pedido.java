package ar.edu.unq.po2.tpIntegrador;

import java.util.ArrayList;
import java.util.Random;

public class Pedido {
	
	private IEstado estado;
	private Usuario usuario;
	private ArrayList<IItem> carritoDeCompras = new ArrayList<IItem>();
	private ArrayList<NotaDeCredito> notasDeCredito = new ArrayList<NotaDeCredito>();
	private IFormaDeEnvio formaDeEnvio;
	private MetodoDePago metodoDePago;

	
	public Pedido(Usuario usuario, ArrayList<IItem> productosOPaquetes) {
		super();
		this.estado = new Borrador(this);
		this.usuario = usuario;
		this.carritoDeCompras = productosOPaquetes;
	}

	
	public Pedido(Usuario usuario) {
		super();
		this.estado = new Borrador(this);
		this.usuario = usuario;
	}

	public ArrayList<IItem> getItems() {
		return carritoDeCompras;
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
	protected void agregarItemACarrito(IItem item) {
		
		if (item.getStock() > 0) {
			this.carritoDeCompras.add(item);
		}

	}
	
	protected void quitarItemDeCarrito(IItem item) {
		 this.carritoDeCompras.remove(item);
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
		
		for (IItem item: carritoDeCompras) {
			item.decrementarStock();
		}
		
	}

	public void incrementarStockItems() {
		for (IItem item: carritoDeCompras) {
			item.incrementarStock();
		}
		
	}
	
	//


	public void registrarNotaDeCredito(NotaDeCredito notaDeCredito) {
		notasDeCredito.add(notaDeCredito);
	}


	public Double montoDeReembolsoDeItems() {

		return carritoDeCompras.stream().mapToDouble(i -> i.precioFinal()).sum();
		
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
		return this.carritoDeCompras.stream().mapToDouble(i -> i.getPeso()).sum();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void realizarPago() {
		this.metodoDePago.procesarPago(this);
	}
	
	
	public MetodoDePago getMetodoDePago() {
		return metodoDePago;
	}


	public void setMetodoDePago(MetodoDePago metodoDePago) {
		this.metodoDePago = metodoDePago;
	}
	


}
