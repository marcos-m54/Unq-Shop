package ar.edu.unq.po2.tpIntegrador.notificaciones;


import java.time.LocalDate;

import ar.edu.unq.po2.tpIntegrador.state.Entregado;
import ar.edu.unq.po2.tpIntegrador.state.Pedido;

public class GeneradorDeFactura implements ISuscriptora {
	
	private IMailSender email;
	
	@Override
	public void actualizar(Pedido pedido) {
		if(pedido.infoEstadoActual().equals("Entregado")) {
			
			email.enviarMail(pedido.getMailUsuario(), "Su factura de compra - Unq-Shop", null);
		//new ComprobanteFiscal("A", 22, LocalDate.now(), "20-00000001",
		}
	}
}

