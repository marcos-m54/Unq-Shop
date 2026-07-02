package ar.edu.unq.po2.tpIntegrador.envio;

import ar.edu.unq.po2.tpIntegrador.state.Pedido;
import java.util.concurrent.ThreadLocalRandom;


public class EnvioEstandar implements IFormaDeEnvio {
	
	private ICorreoArgentina correoArgentina;

	public EnvioEstandar(ICorreoArgentina correoArgentina) {
		super();
	    this.correoArgentina = correoArgentina;
	}

	public ICorreoArgentina getCorreoArgentina() {
	    return correoArgentina;
	}

	public void setCorreoArgentina(ICorreoArgentina correoArgentina) {
	    this.correoArgentina = correoArgentina;
	}
	
	@Override
	public Double calcularValorDelEnvio(Pedido pedido) {
		return correoArgentina.estimarEnvio(pedido.pesoTotalDePedido(),
				pedido.getUsuario().getDireccion());
	}

	@Override
	public int estimacionDiasDeEnvio(Pedido pedido) {
		return ThreadLocalRandom.current().nextInt(5, 8);
	}
}
