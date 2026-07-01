package ar.edu.unq.po2.tpIntegrador.notificaciones;

import ar.edu.unq.po2.tpIntegrador.state.Cancelado;
import ar.edu.unq.po2.tpIntegrador.state.Pedido;

public class Fidelizacion implements ISuscriptora {
	
	private IMailSender mailsender;
	
	// Nota Yami: agrego constructor
	public Fidelizacion(IMailSender mailsender) {
	    this.mailsender = mailsender;
	}

	@Override
	public void actualizar(Pedido pedido) {
		if (pedido.getEstado() instanceof Cancelado) {
			String direccionDestino = pedido.getUsuario().getEmail();
			
			mailsender.enviarMail(direccionDestino, "¡DESCUENTO!", "Si compras en las proximas 24 horas, tenes un descuento del 5%");
		}
	}
}
