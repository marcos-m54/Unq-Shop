package ar.edu.unq.po2.tpIntegrador.pago;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;

import org.mockito.InOrder;

import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.IItem;
import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.Usuario;
import ar.edu.unq.po2.tpIntegrador.state.Pedido;

class TarjetaDeCreditoPagoTest {

	Pedido pedido;
	TarjetaDeCredito tarjeta;
	IApiTarjetaDeCredito validacionMock; // Mockea la interfez

	@BeforeEach
	void setUp() throws Exception {
		
		// Creo un usuario xq pedido lo necesita
		Usuario usuario = new Usuario("Juana Perez", "juana@mail.com", "Calle Falsa 123");
		// Creo un pedido vacio xq procesarPago necesita un Pedido como param.
		pedido = new Pedido(usuario, new ArrayList<IItem>());

		// Le pido a Mockito "creame un objeto falso que cumpla con esta interfaz"
		validacionMock = mock(IApiTarjetaDeCredito.class);
		
		// Creo la tarjeta real 
		tarjeta = new TarjetaDeCredito(123456789, 123, LocalDate.of(2027, 12, 1), validacionMock);
	}

	@Test
	void procesarPagoLlamaALosPasosEnElOrdenCorrecto() {
		
		/* 
		 Con los when le enseñas al mock lo que tiene que saber
		 En este caso seria "cuando te preguntan si esta tarjeta es válida, respondé que sí"
		 El when solo esta con los dos primero pero no con tranferenciaInmedianta xq ejecutarTransferenciaInmediata es void (no devuelve nada), 
		 entonces no hay nada que "enseñarle" a responder. Los when solo hacen falta para métodos que devuelven algo (boolean en este caso). 
		*/
		when(validacionMock.esValida(tarjeta)).thenReturn(true);
		when(validacionMock.tienePreAutorizacion(tarjeta)).thenReturn(true);

		// Ejecuta el método real. Esto hace los 3 pasos + el hook.
		tarjeta.procesarPago(pedido);

		// Verifica q llama los 3 pasos 
		// Basicamente es como preguntar"en algún momento te llamaron con esValida(tarjeta)?" Si la respuesta es no, el test falla.
		verify(validacionMock).esValida(tarjeta);
		verify(validacionMock).tienePreAutorizacion(tarjeta);
		verify(validacionMock).ejecutarTransferenciaInmediata(tarjeta);

		// Verificación más estricta, no solo chequeo que se llamaron sino en qué orden.
		InOrder orden = inOrder(validacionMock);
		// Confirmo orden exacto
		orden.verify(validacionMock).esValida(tarjeta);
		orden.verify(validacionMock).tienePreAutorizacion(tarjeta);
		orden.verify(validacionMock).ejecutarTransferenciaInmediata(tarjeta);
		
		// Nota: Verify chequea que los llama pero no chequea el orden, para eso esta inOrden
	}

	@Test
	void validarDatosDelegaEnLaValidacion() {
		tarjeta.validarDatos(pedido);
		verify(validacionMock).esValida(tarjeta);
	}

	@Test
	void reservarFondosDelegaEnLaValidacion() {
		tarjeta.reservarFondos(pedido);
		verify(validacionMock).tienePreAutorizacion(tarjeta);
	}

	@Test
	void ejecutarTransaccionDelegaEnLaValidacion() {
		tarjeta.ejecutarTransacción(pedido);
		verify(validacionMock).ejecutarTransferenciaInmediata(tarjeta);
	}
	
	// Chequeo por separado para acceder mas facil a un posible error

	@Test
	// Esto es para chequear que el mock arranca limpio 
	// never es para chequear que nunca se llamo
	void siNuncaSeProcesaElPagoNoSeLlamaNingunaValidacion() {
		verify(validacionMock, never()).esValida(any());
		verify(validacionMock, never()).tienePreAutorizacion(any());
		verify(validacionMock, never()).ejecutarTransferenciaInmediata(any());
	}
	
	@Test
	void notificarResultadoRegistraUnComprobanteConDatosCorrectos() {
	    tarjeta.notificarResultado(pedido);

	    Comprobante comprobante = pedido.getComprobanteDePago();

	    assertNotNull(comprobante);
	    assertTrue(comprobante instanceof CuponDePago);
	}
	
}
