package ar.edu.unq.po2.tpIntegrador.notificaciones;


import java.time.LocalDate;

import ar.edu.unq.po2.tpIntegrador.state.Entregado;
import ar.edu.unq.po2.tpIntegrador.state.Pedido;

public class GeneradorDeFactura implements ISuscriptora {
	
	@Override
	public void actualizar(Pedido pedido) {
		if(pedido.getEstado() instanceof Entregado) {
			new ComprobanteFiscal("A", 22, LocalDate.now(), "20-00000001",
					pedido.montoTotal());
		}
	}
}

