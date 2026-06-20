package ar.edu.unq.po2.tpIntegrador.envio;

import ar.edu.unq.po2.tpIntegrador.state.Pedido;

public interface IFormaDeEnvio {

	public Float calcularValorDelEnvio(Pedido pedido);
	
}
