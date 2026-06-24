package ar.edu.unq.po2.tpIntegrador.pago;

public interface IValidacionTarjetaDeCredito {
	
	public boolean esValida(TarjetaDeCredito tarjeta);
	
	public boolean tienePreAutorizacion(TarjetaDeCredito tarjeta);
	
	public void ejecutarTransferenciaInmediata(TarjetaDeCredito tarjeta);
	
}
