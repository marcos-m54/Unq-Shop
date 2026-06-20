package ar.edu.unq.po2.tpIntegrador;

public class BilleteraVirtual extends MetodoDePago {


	private Double saldo;
	private IvalidacionBilleteraVirtual validacion; 
	

	@Override
	public void validarDatos(Pedido pedido) {
		validacion.tieneSaldoSuficiente(this);

	}

	@Override
	public void reservarFondos(Pedido pedido) {
		validacion.bloquearSaldo(this);

	}

	@Override
	public void ejecutarTransacción(Pedido pedido) {
		validacion.acreditarSaldo(this);

	}

	public void notificarResultado(Pedido pedido) {
		validacion.crearNotificacionPush(this);

	}

}
