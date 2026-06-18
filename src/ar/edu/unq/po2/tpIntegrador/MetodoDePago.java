package ar.edu.unq.po2.tpIntegrador;
import java.util.Random;


public abstract class MetodoDePago {

	public final void procesarPago(Pedido pedido) { //metodo plantilla
		validarDatos(pedido);
		reservarFondos(pedido);
		ejecutarTransacción(pedido);
	}
	
	public abstract void validarDatos(Pedido pedido);
	public abstract void reservarFondos(Pedido pedido);  
	public abstract void ejecutarTransacción(Pedido pedido);
	
	//metodo hook
	public void notificarResultado(Pedido pedido) {
		pedido.registrarCodigoTransaccion(new Random());
		
	} 

}
