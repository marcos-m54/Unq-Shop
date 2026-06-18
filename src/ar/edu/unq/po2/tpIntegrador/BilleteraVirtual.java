package ar.edu.unq.po2.tpIntegrador;

public class BilleteraVirtual extends MetodoDePago {


	private Double saldo;
	private IvalidacionBilleteraVirtual validacion; 
	

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
		validacion.crearNotificacionPush();

	}

}
