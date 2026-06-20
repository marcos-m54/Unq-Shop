package ar.edu.unq.po2.tpIntegrador;

public class TransferenciaBancaria extends MetodoDePago {
	
	private int CBUorCVU;
	private String alias; 
	private IvalidacionTransferenciaBancaria validacion; 

	@Override
	public void validarDatos(Pedido pedido) {
		validacion.sonDatosValidos(this);

	}

	@Override
	public void reservarFondos(Pedido pedido) {
		// TODO Auto-generated method stub

	}

	@Override
	public void ejecutarTransacción(Pedido pedido) {
		validacion.ejecutarTransferencia(this);

	}

	
	public void notificarResultado(Pedido pedido) {
		// TODO Auto-generated method stub

	}

}
