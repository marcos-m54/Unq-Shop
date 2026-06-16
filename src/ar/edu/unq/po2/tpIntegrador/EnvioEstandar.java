package ar.edu.unq.po2.tpIntegrador;

public class EnvioEstandar implements IFormaDeEnvio {
	
	private ICorreoArgentino correoArgentino;
	
	//cree un objeto de usuario para el pedido que contiene un objeto direccion

	@Override
	public Double calcularValorDelEnvio(Pedido pedido) {
		return correoArgentino.estimarEnvio(pedido.calcularValorDeEnvio(pedido), pedido.getUsuario().getDireccion());
	}

}
