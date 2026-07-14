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
	
	//observers concretos
	NovedadesDePedido observerNovedades;
	Fidelizacion fidelizacion;
	
	
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
		observerNovedades = new NovedadesDePedido(mailSenderMock);
		fidelizacion = new Fidelizacion(mailSenderMock);
		
	}
 
	@Test
	void notificadorNotificaATodosLosSuscriptores() {
		// Creo dos suscriptores falsos

		IObservador suscriptora1 = mock(IObservador.class);
		IObservador suscriptora2 = mock(IObservador.class);
 
		pedido.agregarObservador(suscriptora1);
		pedido.agregarObservador(suscriptora2);

		// Verifico que ambos recibieron el aviso
		pedido.notificar();
		
		verify(suscriptora1).actualizar(pedido);
		verify(suscriptora2).actualizar(pedido);
	}
 
	@Test
	void notificadorDesuscribirDejaDeNotificarAlSuscriptor() {
		IObservador suscriptoraMock = mock(IObservador.class);
 
		pedido.agregarObservador(suscriptoraMock);
		pedido.quitarObservador(suscriptoraMock);
 
		pedido.notificar();
 
		// Despues de desuscribirse, NO deberia recibir mas notificaciones
		
		verify(suscriptoraMock, never()).actualizar(any());
	}
 
	@Test
	void notificadorSinSuscriptoresNoLlamaANadie() {
		IObservador suscriptoraMock = mock(IObservador.class);
 
		// No suscribimos a nadie
		pedido.notificar();
 
		verify(suscriptoraMock, never()).actualizar(any());
	}
 
	// Enunciado: solo actua ante CONFIRMADO, ENVIADO y ENTREGADO
	@Test
	void notificadorDeEmailEnviaMailCuandoElPedidoEsConfirmado() {

		// Forzamos a estado de pedido confirmado
		pedido.setEstado(new Confirmado(pedido));
 
		observerNovedades.actualizar(pedido);
		
		// Verificamos que mailSender recibio el llamado con los parametros correctos
		verify(mailSenderMock).enviarMail(
			"juana@mail.com",
			"Detalles de su compra UnqShop",
			"Gracias por tu compra, tu pedido se encuentra en estado: Confirmado. ¡Gracias por su compra!"
		);
	}
	@Test
	void notificadorDeEmailEnviaMailCuandoElPedidoEsEnviado() {

		pedido.setEstado(new Enviado(pedido));
 
		observerNovedades.actualizar(pedido);
 
		verify(mailSenderMock).enviarMail(
				"juana@mail.com",
				"Detalles de su compra UnqShop",
				"Gracias por tu compra, tu pedido se encuentra en estado: Enviado. ¡Gracias por su compra!"
		);
	}
 
	@Test
	void notificadorDeEmailEnviaMailCuandoElPedidoEsEntregado() {
		pedido.setEstado(new Entregado(pedido));
  
		observerNovedades.actualizar(pedido);
		
		verify(mailSenderMock).enviarMail(
				"juana@mail.com",
				"Detalles de su compra UnqShop",
				"Gracias por tu compra, tu pedido se encuentra en estado: Entregado. ¡Gracias por su compra!"
		);
	}
 
	@Test
	void notificadorDeEmailEnviaMailCuandoEsCanceladoConCuponDeDescuento() {
		// Si el estado es CANCELADO, no deberia mandar ningun mail
		//NotificadorDeEmail notificadorEmail = new NotificadorDeEmail(mailSenderMock);
		pedido.setEstado(new Cancelado(pedido));
 
		fidelizacion.actualizar(pedido);

		verify(mailSenderMock).enviarMail(
				"juana@mail.com",
				"Su pedido se ha cancelado. Oportunidad ¡DESCUENTO! si compra en las prox 24hs",
				"Si compras en las proximas 24 horas, tenes un descuento del 5%");
		
	}
 
 
	@Test
	void fidelizacionNoEnviaMailSiElPedidoNoEstaCancelado() {
		// Solo actua cuando el pedido esta CANCELADO, no en otros estados
		pedido.setEstado(new Confirmado(pedido));
 
		fidelizacion.actualizar(pedido);
 
		verify(mailSenderMock, never()).enviarMail(any(), any(), any());
	}
 
	// Enunciado: crea el comprobante fiscal cuando el pedido alcanza ENTREGADO
 /*
	@Test
	void generadorDeFacturaActuaSoloEnEstadoEntregado() {
		// Verificamos que no explota cuando el estado es ENTREGADO
		// Nota Yami: como no se guarda el comprobante no puedo hacer mucho mas test. Solo que no rompe
		GeneradorDeFactura generador = new GeneradorDeFactura();
		pedido.setEstado(new Entregado(pedido));
 
		assertDoesNotThrow(() -> generador.actualizar(pedido));
	}*/
}
 
