package ar.edu.unq.po2.tpIntegrador.pago;

import java.time.LocalDate;

import ar.edu.unq.po2.tpIntegrador.state.Pedido;

public class TarjetaDeCredito extends MetodoDePago {
	
	private int numeroTarjeta;
	private int CVV;
	private LocalDate fechaVencimiento;
	private IValidacionTarjetaDeCredito validacion;

	// Set y Get
	public IValidacionTarjetaDeCredito getValidacion() {
		return validacion;
	}

	public void setValidacion(IValidacionTarjetaDeCredito validacion) {
		this.validacion = validacion;
	}
	
	@Override
	public void validarDatos(Pedido pedido) {
		validacion.esValida(this);
	}

	@Override
	public void reservarFondos(Pedido pedido) {
		validacion.tienePreAutorizacion(this);
	}

	@Override
	public void ejecutarTransacción(Pedido pedido) {
		validacion.ejecutarTransferenciaInmediata(this);
	}

	public void notificarResultado(Pedido pedido) {
	}
}
