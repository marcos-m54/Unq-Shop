package ar.edu.unq.po2.tpIntegrador.notificaciones;

import ar.edu.unq.po2.tpIntegrador.state.Pedido;

public class NovedadesDePedido implements IObservador {

	private IMailSender mail;
	
	@Override
	public void actualizar(Pedido pedido) {
		
		if(this.esEstadoValido(pedido)) {
			mail.enviarMail(pedido.getMailUsuario(), 
							"Detalles de su compra UnqShop", 
							"Gracias por tu compra, tu pedido se encuentra en estado: "+ pedido.infoEstadoActual() + ". ¡Gracias por su compra!");
		}
	}

	public IMailSender getMail() {
		return mail;
	}

	public void setMail(IMailSender mail) {
		this.mail = mail;
	}

	public NovedadesDePedido(IMailSender mail) {
		super();
		this.mail = mail;
	}
	
	public boolean esEstadoValido(Pedido pedido) {
		
		return  pedido.infoEstadoActual().equals("Confirmado") ||
				
				pedido.infoEstadoActual().equals("Enviado") || 
				
				pedido.infoEstadoActual().equals("Entregado"); 
	}
	
	

}
