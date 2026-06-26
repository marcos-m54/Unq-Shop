package ar.edu.unq.po2.tpIntegrador.envio;

import ar.edu.unq.po2.tpIntegrador.state.Pedido;
import java.util.concurrent.ThreadLocalRandom;


public class EnvioEstandar implements IFormaDeEnvio {
	
	private ICorreoArgentina correoArgentina;
	

	@Override
	public Double calcularValorDelEnvio(Pedido pedido) {
		return correoArgentina.estimarEnvio(pedido.calcularValorDeEnvio(pedido), pedido.getUsuario().getDireccion());
	}

	@Override
	public int estimacionDiasDeEnvio(Pedido pedido) {
		return ThreadLocalRandom.current().nextInt(5, 8);
	}

}
