package ar.edu.unq.po2.tpIntegrador.pago;

import static org.mockito.Mockito.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.IItem;
import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.Usuario;
import ar.edu.unq.po2.tpIntegrador.state.Pedido;

class TranferenciaBancariaPagoTest {

	Pedido pedido;
	TransferenciaBancaria transferencia;
	IApiTransferenciaBancaria validacionMock;

	@BeforeEach
	void setUp() throws Exception {

		Usuario usuario = new Usuario("Juana Perez", "juana@mail.com", "Calle Falsa 123");
		pedido = new Pedido(usuario, new ArrayList<IItem>());

		validacionMock = mock(IApiTransferenciaBancaria.class);

		transferencia = new TransferenciaBancaria("UnCVU", "UnAlias", validacionMock);
	}

	@Test
	void procesarPagoLlamaALosPasosEnElOrdenCorrecto() {

		when(validacionMock.sonDatosValidos(transferencia)).thenReturn(true);

		transferencia.procesarPago(pedido);

		verify(validacionMock).sonDatosValidos(transferencia);
		verify(validacionMock).ejecutarTransferencia(transferencia);
		// no hice reservarFondos porque no es necesario para transferencia (transferencia directa)

		InOrder orden = inOrder(validacionMock);
		orden.verify(validacionMock).sonDatosValidos(transferencia);
		orden.verify(validacionMock).ejecutarTransferencia(transferencia);
	}

	@Test
	void validarDatosDelegaEnLaValidacion() {
		transferencia.validarDatos(pedido);
		verify(validacionMock).sonDatosValidos(transferencia);
	}

	@Test
	void ejecutarTransaccionDelegaEnLaValidacion() {
		transferencia.ejecutarTransacción(pedido);
		verify(validacionMock).ejecutarTransferencia(transferencia);
	}

	@Test
	void reservarFondosNoLlamaANingunMetodoDeLaValidacion() {
		// Como en el enunciado dice que es una tranferencia directa, no es necesario reservar fondos
		// el mock no deberia recibir llamados al ejecutar este paso.
		transferencia.reservarFondos(pedido);

		verifyNoInteractions(validacionMock);
	}

	@Test
	void siNuncaSeProcesaElPagoNoSeLlamaNingunaValidacion() {
		verify(validacionMock, never()).sonDatosValidos(any());
		verify(validacionMock, never()).ejecutarTransferencia(any());
	}
	
	@Test
	void notificarResultadoRegistraUnComprobanteConDatosCorrectos() {
	    transferencia.notificarResultado(pedido);

	    Comprobante comprobante = pedido.getComprobanteDePago();

	    assertNotNull(comprobante);
	    assertTrue(comprobante instanceof ComprobanteCBU);
	}
}
