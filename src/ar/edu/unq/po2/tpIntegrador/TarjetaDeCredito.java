package ar.edu.unq.po2.tpIntegrador;

import java.time.LocalDate;

public class TarjetaDeCredito extends MetodoDePago {
	
	private int numeroTarjeta;
	private int CVV;
	private LocalDate fechaVencimiento;
	private IValidacionTarjetaDeCredito validacion;

	@Override
	public void validarDatos(Pedido pedido) {


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


	}

}
