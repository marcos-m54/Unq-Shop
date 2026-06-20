package ar.edu.unq.po2.tpIntegrador.envio;

import ar.edu.unq.po2.tpIntegrador.state.Pedido;

public class RetiroEnSucursal implements IFormaDeEnvio {

	@Override
	public Float calcularValorDelEnvio(Pedido pedido) {
		return 0.0f;
	}

}
