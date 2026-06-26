package ar.edu.unq.po2.tpIntegrador.pago;

import java.time.LocalDate;

import ar.edu.unq.po2.tpIntegrador.state.Pedido;

public class TarjetaDeCredito extends MetodoDePago {
	
	private long numeroTarjeta;
	private int CVV;
	private LocalDate fechaVencimiento;
	private IApiTarjetaDeCredito api;
	
	public TarjetaDeCredito(int numeroTarjeta, int cVV, LocalDate fechaVencimiento, IApiTarjetaDeCredito api) {
		this.setNumeroTarjeta(numeroTarjeta);
		this.setCVV(cVV);
		this.setFechaVencimiento(fechaVencimiento);
		this.api = api;
	}

	// Set y Get
	public IValidacionTarjetaDeCredito getValidacion() {
		return validacion;
	}

	public void setValidacion(IValidacionTarjetaDeCredito validacion) {
		this.validacion = validacion;
	}
	
	@Override
	public void validarDatos(Pedido pedido) {
		api.esValida(this);


	}

	@Override
	public void reservarFondos(Pedido pedido) {
		api.tienePreAutorizacion(this);

	}

	@Override
	public void ejecutarTransacción(Pedido pedido) {
		api.ejecutarTransferenciaInmediata(this);

	}

	public void notificarResultado(Pedido pedido) {
		
		pedido.registrarComprobante(new CuponDePago(pedido.montoTotal(), this.obtenerMascaraCupon()));
		
	}
	
	//getters y setters

	public long getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(int numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public int getCVV() {
		return CVV;
	}

	public void setCVV(int cVV) {
		CVV = cVV;
	}

	public LocalDate getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(LocalDate fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	
	//
	
	 public String obtenerMascaraCupon() {
	        long ultimosCuatro = this.numeroTarjeta % 10000;
	        return "XXXX-XXXX-XXXX-" + String.format("%04d", ultimosCuatro);
	    }

}
