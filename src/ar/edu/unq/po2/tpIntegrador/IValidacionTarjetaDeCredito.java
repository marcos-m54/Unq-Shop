package ar.edu.unq.po2.tpIntegrador;


public interface IValidacionTarjetaDeCredito {
	
	public boolean esValida(TarjetaDeCredito tarjeta);
	
	public boolean tienePreAutorizacion(Usuario usuario);
	
	public void ejecutarTransferenciaInmediata();
	
}
