package ar.edu.unq.po2.tpIntegrador;

public class TransferenciaBancaria extends MetodoDePago {
	
	private int CBUorCVU;
	private String alias; 
	
	private IvalidacionTransferenciaBancaria validacion; 

	@Override
	public void validarDatos(Pedido pedido) {
		// TODO Auto-generated method stub

	}

	@Override
	public void reservarFondos(Pedido pedido) {
		// TODO Auto-generated method stub

	}

	@Override
	public void ejecutarTransacción(Pedido pedido) {
		// TODO Auto-generated method stub

	}

	
	public void notificarResultado(Pedido pedido) {
		// TODO Auto-generated method stub

	}

}
