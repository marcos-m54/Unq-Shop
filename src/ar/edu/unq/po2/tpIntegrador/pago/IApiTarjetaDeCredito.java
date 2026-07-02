package ar.edu.unq.po2.tpIntegrador.pago;

public interface IApiTarjetaDeCredito {
	
	public boolean esValida(TarjetaDeCredito tarjeta);
	
	public boolean tienePreAutorizacion(TarjetaDeCredito tarjeta);
	
	public void ejecutarTransferenciaInmediata(TarjetaDeCredito tarjeta);
	
}
