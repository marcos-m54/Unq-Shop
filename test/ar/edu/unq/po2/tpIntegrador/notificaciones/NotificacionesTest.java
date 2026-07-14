package ar.edu.unq.po2.tpIntegrador.notificaciones;
 
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
 
import java.util.ArrayList;
 
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
 
import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.IItem;
import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.Usuario;
import ar.edu.unq.po2.tpIntegrador.state.Cancelado;
import ar.edu.unq.po2.tpIntegrador.state.Confirmado;
import ar.edu.unq.po2.tpIntegrador.state.Entregado;
import ar.edu.unq.po2.tpIntegrador.state.Enviado;
import ar.edu.unq.po2.tpIntegrador.state.Pedido;
 
class NotificacionesTest {
 
	Pedido pedido;
	Usuario usuario;
	IMailSender mailSenderMock;
	//Notificador notificador;
 
	@BeforeEach
	void setUp() throws Exception {
		// Usuario real
		usuario = new Usuario("Juana Perez", "juana@mail.com", "Calle Falsa 123");
 
		ArrayList<IItem> items = new ArrayList<>();
		pedido = new Pedido(usuario, items);
		// Pedido vacío, solo para tener un contexto de pedido real donde cambiar el estado
 
		// Notificador real, vacío (sin suscriptores). Cada test agrega los suscriptores que necesita.
		//notificador = new Notificador();
		//pedido.setNotificador(notificador);
 
		// Mock del mail sender, externo no implementamos
		mailSenderMock = mock(IMailSender.class);
	}
 
	@Test
	void notificadorNotificaATodosLosSuscriptores() {
		// Creo dos suscriptores falsos
		ISuscriptora suscriptora1 = mock(ISuscriptora.class);
		ISuscriptora suscriptora2 = mock(ISuscriptora.class);
 
		//notificador.suscribir(suscriptora1);
		//notificador.suscribir(suscriptora2);
 
		//notificador.notificarASuscriptores(pedido);
 
		// Verifico que ambos recibieron el aviso
		verify(suscriptora1).actualizar(pedido);
		verify(suscriptora2).actualizar(pedido);
	}
 
	@Test
	void notificadorDesuscribirDejaDeNotificarAlSuscriptor() {
		ISuscriptora suscriptoraMock = mock(ISuscriptora.class);
 
		notificador.suscribir(suscriptoraMock);
		notificador.desuscribir(suscriptoraMock);
 
		notificador.notificarASuscriptores(pedido);
 
		// Despues de desuscribirse, NO deberia recibir mas notificaciones
		verify(suscriptoraMock, never()).actualizar(any());
	}
 
	@Test
	void notificadorSinSuscriptoresNoLlamaANadie() {
		ISuscriptora suscriptoraMock = mock(ISuscriptora.class);
 
		// No suscribimos a nadie
		notificador.notificarASuscriptores(pedido);
 
		verify(suscriptoraMock, never()).actualizar(any());
	}
 
	// Enunciado: solo actua ante CONFIRMADO, ENVIADO y ENTREGADO
	@Test
	void notificadorDeEmailEnviaMailCuandoElPedidoEsConfirmado() {
		NotificadorDeEmail notificadorEmail = new NotificadorDeEmail(mailSenderMock);
		pedido.setEstado(new Confirmado(pedido));
		// Forzamos a estado de pedido confirmado
 
		notificadorEmail.actualizar(pedido);
		
		// Verificamos que mailSender recibio el llamado con los parametros correctos
		verify(mailSenderMock).enviarMail(
			"juana@mail.com",
			"¡CONFIRMADO!",
			"Te avisamos que tu pedido ha sido confirmado."
		);
	}
 
	@Test
	void notificadorDeEmailEnviaMailCuandoElPedidoEsEnviado() {
		NotificadorDeEmail notificadorEmail = new NotificadorDeEmail(mailSenderMock);
		pedido.setEstado(new Enviado(pedido));
 
		notificadorEmail.actualizar(pedido);
 
		verify(mailSenderMock).enviarMail(
			"juana@mail.com",
			"¡ENVIADO!",
			"Te avisamos que tu pedido ha sido enviado, y esta en camino."
		);
	}
 
	@Test
	void notificadorDeEmailEnviaMailCuandoElPedidoEsEntregado() {
		NotificadorDeEmail notificadorEmail = new NotificadorDeEmail(mailSenderMock);
		pedido.setEstado(new Entregado(pedido));
 
		notificadorEmail.actualizar(pedido);
 
		verify(mailSenderMock).enviarMail(
			"juana@mail.com",
			"¡ENTREGADO!",
			"Te avisamos que tu pedido ha sido entregado, ¡disfrutalo!"
		);
	}
 
	@Test
	void notificadorDeEmailNoEnviaMailCuandoElPedidoEsCancelado() {
		// Si el estado es CANCELADO, no deberia mandar ningun mail
		NotificadorDeEmail notificadorEmail = new NotificadorDeEmail(mailSenderMock);
		pedido.setEstado(new Cancelado(pedido));
 
		notificadorEmail.actualizar(pedido);
 
		verify(mailSenderMock, never()).enviarMail(any(), any(), any());
	}
 
	// Enunciado: si se cancela un pedido, envia un cupon de descuento del 5%
	@Test
	void fidelizacionEnviaMailCuandoElPedidoEsCancelado() {
		Fidelizacion fidelizacion = new Fidelizacion(mailSenderMock);
		pedido.setEstado(new Cancelado(pedido));
 
		fidelizacion.actualizar(pedido);
 
		verify(mailSenderMock).enviarMail(
			"juana@mail.com",
			"¡DESCUENTO!",
			"Si compras en las proximas 24 horas, tenes un descuento del 5%"
		);
	}
 
	@Test
	void fidelizacionNoEnviaMailSiElPedidoNoEstaCancelado() {
		// Solo actua cuando el pedido esta CANCELADO, no en otros estados
		Fidelizacion fidelizacion = new Fidelizacion(mailSenderMock);
		pedido.setEstado(new Confirmado(pedido));
 
		fidelizacion.actualizar(pedido);
 
		verify(mailSenderMock, never()).enviarMail(any(), any(), any());
	}
 
	// Enunciado: crea el comprobante fiscal cuando el pedido alcanza ENTREGADO
 
	@Test
	void generadorDeFacturaActuaSoloEnEstadoEntregado() {
		// Verificamos que no explota cuando el estado es ENTREGADO
		// Nota Yami: como no se guarda el comprobante no puedo hacer mucho mas test. Solo que no rompe
		GeneradorDeFactura generador = new GeneradorDeFactura();
		pedido.setEstado(new Entregado(pedido));
 
		assertDoesNotThrow(() -> generador.actualizar(pedido));
	}
}
 