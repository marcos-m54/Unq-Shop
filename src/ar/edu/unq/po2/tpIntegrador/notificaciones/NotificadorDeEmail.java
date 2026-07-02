package ar.edu.unq.po2.tpIntegrador.notificaciones;

import ar.edu.unq.po2.tpIntegrador.state.Pedido;
import ar.edu.unq.po2.tpIntegrador.state.Confirmado;
import ar.edu.unq.po2.tpIntegrador.state.Entregado;
import ar.edu.unq.po2.tpIntegrador.state.Enviado;

public class NotificadorDeEmail implements ISuscriptora {
	
	private IMailSender mailsender;

	// Nota Yami: agrego constructor
	public NotificadorDeEmail(IMailSender mailsender) {
	    this.mailsender = mailsender;
	}

	@Override
	public void actualizar(Pedido pedido) {
		
		String direccionDestino = pedido.getUsuario().getEmail();
		
		if (pedido.getEstado() instanceof Confirmado) {
			mailsender.enviarMail(direccionDestino, "¡CONFIRMADO!", "Te avisamos que tu pedido ha sido confirmado.");
		}
		
		else if (pedido.getEstado() instanceof Enviado) {
			mailsender.enviarMail(direccionDestino, "¡ENVIADO!", "Te avisamos que tu pedido ha sido enviado, y esta en camino.");
		}
		
		else if (pedido.getEstado() instanceof Entregado) {
			mailsender.enviarMail(direccionDestino, "¡ENTREGADO!", "Te avisamos que tu pedido ha sido entregado, ¡disfrutalo!");
		}
	}
}
