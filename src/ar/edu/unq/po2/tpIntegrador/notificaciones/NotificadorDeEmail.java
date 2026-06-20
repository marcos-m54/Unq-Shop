package ar.edu.unq.po2.tpIntegrador.notificaciones;

import ar.edu.unq.po2.tpIntegrador.state.Pedido;
import ar.edu.unq.po2.tpIntegrador.state.Confirmado;

public class NotificadorDeEmail implements ISuscriptor {

	@Override
	public void actualizar(Pedido pedido) {
		if (pedido.getEstado() instanceof Confirmado ) {
			
		}
		
	}
	
	

}
