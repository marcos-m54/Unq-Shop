package ar.edu.unq.po2.tpIntegrador.envio;

import ar.edu.unq.po2.tpIntegrador.state.Pedido;

public class EnvioEstandar implements IFormaDeEnvio {
	
	private ICorreoArgentina correoArgentina;
	
	//cree un objeto de usuario para el pedido que contiene un objeto direccion

	@Override
	public Double calcularValorDelEnvio(Pedido pedido) {
		return correoArgentina.estimarEnvio(pedido.calcularValorDeEnvio(pedido), pedido.getUsuario().getDireccion());
	}

}
