package ar.edu.unq.po2.tpIntegrador.pago;
import ar.edu.unq.po2.tpIntegrador.state.Pedido;


public abstract class MetodoDePago {

	public final void procesarPago(Pedido pedido) { //metodo plantilla
		validarDatos(pedido);
		reservarFondos(pedido);
		ejecutarTransacción(pedido);
		notificarResultado(pedido);
	}
	
	public abstract void validarDatos(Pedido pedido);
	public abstract void reservarFondos(Pedido pedido);  
	public abstract void ejecutarTransacción(Pedido pedido);
	
	
	public void notificarResultado(Pedido pedido) {
		
	} 

}
