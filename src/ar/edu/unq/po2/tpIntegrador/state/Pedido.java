package ar.edu.unq.po2.tpIntegrador.state;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.IItem;
import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.Sistema;
import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.Usuario;
import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.Venta;
import ar.edu.unq.po2.tpIntegrador.envio.IFormaDeEnvio;
import ar.edu.unq.po2.tpIntegrador.notificaciones.INotificador;
import ar.edu.unq.po2.tpIntegrador.notificaciones.IObservador;
import ar.edu.unq.po2.tpIntegrador.notificaciones.Notificador;
import ar.edu.unq.po2.tpIntegrador.pago.Comprobante;
import ar.edu.unq.po2.tpIntegrador.pago.MetodoDePago;

public class Pedido implements INotificador {
	
	private IEstado estado;
	private Usuario usuario;
	private ArrayList<IItem> carritoDeCompras = new ArrayList<IItem>();
	private ArrayList<NotaDeCredito> notasDeCredito = new ArrayList<NotaDeCredito>();
	private List<IObservador> observadores = new ArrayList<IObservador>();
	private IFormaDeEnvio formaDeEnvio;
	private MetodoDePago metodoDePago;
	private Comprobante comprobanteDePago;
	private Notificador notificador;
	//visitor
	private Sistema sistema;

	
	public Pedido(Usuario usuario, ArrayList<IItem> items) {
		super();
		this.estado = new Borrador(this);
		this.usuario = usuario;
		this.carritoDeCompras = items;
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
		notificador.notificarASuscriptores(this);
	}
	
	public void agregarItemACarrito(IItem item) {
		
		if (item.getStock() > 0) {
			this.carritoDeCompras.add(item);
		}
	}
	
	public void quitarItemDeCarrito(IItem item) {
		 this.carritoDeCompras.remove(item);
	}
	
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
	
	// Nota Yami: agrego entregarPedido() que faltaba
	
	public void entregarPedido() {
	    estado.entregarPedido();
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
	
	public void registrarNotaDeCredito(NotaDeCredito notaDeCredito) {
		notasDeCredito.add(notaDeCredito);
	}
	
	public Double montoTotalPedidoMasEnvio() {
		return this.montoTotal() + calcularValorDeEnvio(this);
	}

	public Double montoTotal() {

		return carritoDeCompras.stream().mapToDouble(i -> i.precioFinal()).sum();	
	}

	public IFormaDeEnvio getFormaDeEnvio() {
		return formaDeEnvio;
	}

	public void setFormaDeEnvio(IFormaDeEnvio formaDeEnvio) {
		this.formaDeEnvio = formaDeEnvio;
	}

	public Double calcularValorDeEnvio(Pedido pedido) {
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

	public void setMetodoDePago(MetodoDePago metodoDePago) {
		this.metodoDePago = metodoDePago;
	}
	
	// Nota Yami: agrego set 
	public void setSistema(Sistema sistema) {
	    this.sistema = sistema;
	}
	
	public void registrarComprobante(Comprobante comprobante) {
		this.comprobanteDePago = comprobante;
	}
	
	//visitor

	public void registrarVentaEnSistema(Venta venta) {
		this.sistema.registrarVenta(venta);
	}
	
	// Nota Yami: agrego get para poder testear
	public Comprobante getComprobanteDePago() {
	    return comprobanteDePago;
	}

	@Override
	public void agregarObservador(IObservador observador) {
		this.observadores.add(observador);
	}

	@Override
	public void quitarObservador(IObservador observador) {
		this.observadores.remove(observador);
	}

	@Override
	public void notificar() {
		this.observadores.stream().forEach(obs -> obs.actualizar(this));
	}

	public String getMailUsuario() {
		return this.getUsuario().getEmail();
	}


	public String infoEstadoActual() {
		return this.getEstado().infoEstado();
	}
	
	
}
