package ar.edu.unq.po2.tpIntegrador.pago;

import ar.edu.unq.po2.tpIntegrador.state.Pedido;

public class BilleteraVirtual extends MetodoDePago {

	private Double saldo;
	private IApiBilleteraVirtual api; 
	
	public BilleteraVirtual(Double saldo, IApiBilleteraVirtual api) {
		this.setSaldo(saldo);
		this.api = api;
	}
	
	// Set y Get
	public IvalidacionBilleteraVirtual getValidacion() {
		return validacion;
	}
	
	public void setValidacion(IvalidacionBilleteraVirtual validacion) {
		this.validacion = validacion;
	}

	@Override
	public void validarDatos(Pedido pedido) {
		api.tieneSaldoSuficiente(this);

	}

	@Override
	public void reservarFondos(Pedido pedido) {
		api.bloquearSaldo(this);

	}

	@Override
	public void ejecutarTransacción(Pedido pedido) {
		api.acreditarSaldo(this);

	}

	public void notificarResultado(Pedido pedido) {
		api.crearNotificacionPush(this);

	}
	
	//getters y setters


	public Double getSaldo() {
		return saldo;
	}


	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
}
