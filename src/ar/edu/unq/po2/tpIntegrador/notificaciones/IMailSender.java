package ar.edu.unq.po2.tpIntegrador.notificaciones;

public interface IMailSender {
	
	public void enviarMail (String direccionDestino, String título, String mensaje);

}
