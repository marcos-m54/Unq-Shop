package ar.edu.unq.po2.tpIntegrador.notificaciones;

import ar.edu.unq.po2.tpIntegrador.state.Pedido;

public class Fidelizacion implements IObservador {
	
	private IMailSender mailsender;
	
	public Fidelizacion(IMailSender mailsender) {
	    this.mailsender = mailsender;
	}

	@Override
	public void actualizar(Pedido pedido) {
		
			if(pedido.infoEstadoActual().equals("Cancelado")) {
			
				String direccionDestino = pedido.getUsuario().getEmail();
				
				mailsender.enviarMail(direccionDestino, "Su pedido se ha cancelado. Oportunidad ¡DESCUENTO! si compra en las prox 24hs", "Si compras en las proximas 24 horas, tenes un descuento del 5%");
					
			}
		
	}
}
