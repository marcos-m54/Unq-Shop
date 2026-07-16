package ar.edu.unq.po2.tpIntegrador.notificaciones;

public interface INotificador {
	
	public void agregarObservador(IObservador observador);
	public void quitarObservador(IObservador observador);
	public void notificar();

}
