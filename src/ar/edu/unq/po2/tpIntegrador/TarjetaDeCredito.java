package ar.edu.unq.po2.tpIntegrador;

import java.time.LocalDate;

public class TarjetaDeCredito extends MetodoDePago {
	
	private int numeroTarjeta;
	private int CVV;
	private LocalDate fechaVencimiento;
	private IValidacionTarjetaDeCredito validacion;

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
