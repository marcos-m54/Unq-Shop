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

// Nota Yami: El enunciado dice "crea el comprobante fiscal", no "registrarlo". A diferencia del cupon de pago y el comprobante CBU que si dicen
//"generarlo y registrarlo", aca solo se crea el objeto. Me parece un dato interesante para dejarlo constatado.
