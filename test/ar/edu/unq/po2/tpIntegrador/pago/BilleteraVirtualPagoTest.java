package ar.edu.unq.po2.tpIntegrador.pago;

import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.IItem;
import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.Usuario;
import ar.edu.unq.po2.tpIntegrador.state.Pedido;

class BilleteraVirtualPagoTest {

	Pedido pedido;
	BilleteraVirtual billetera;
	IvalidacionBilleteraVirtual validacionMock;

	@BeforeEach
	void setUp() throws Exception {

		Usuario usuario = new Usuario("Juana Perez", "juana@mail.com", "Calle Falsa 123");
		pedido = new Pedido(usuario, new ArrayList<IItem>());

		validacionMock = mock(IvalidacionBilleteraVirtual.class);

		billetera = new BilleteraVirtual();
		billetera.setValidacion(validacionMock);
	}

	@Test
	void procesarPagoLlamaALosPasosEnElOrdenCorrecto() {

		when(validacionMock.tieneSaldoSuficiente(billetera)).thenReturn(true);

		billetera.procesarPago(pedido);

		verify(validacionMock).tieneSaldoSuficiente(billetera);
		verify(validacionMock).bloquearSaldo(billetera);
		verify(validacionMock).acreditarSaldo(billetera);
		verify(validacionMock).crearNotificacionPush(billetera);

		InOrder orden = inOrder(validacionMock);
		orden.verify(validacionMock).tieneSaldoSuficiente(billetera);
		orden.verify(validacionMock).bloquearSaldo(billetera);
		orden.verify(validacionMock).acreditarSaldo(billetera);
		orden.verify(validacionMock).crearNotificacionPush(billetera);
	}

	@Test
	void validarDatosDelegaEnLaValidacion() {
		billetera.validarDatos(pedido);
		verify(validacionMock).tieneSaldoSuficiente(billetera);
	}

	@Test
	void reservarFondosDelegaEnLaValidacion() {
		billetera.reservarFondos(pedido);
		verify(validacionMock).bloquearSaldo(billetera);
	}

	@Test
	void ejecutarTransaccionDelegaEnLaValidacion() {
		billetera.ejecutarTransacción(pedido);
		verify(validacionMock).acreditarSaldo(billetera);
	}

	@Test
	void notificarResultadoDelegaEnLaValidacion() {
		billetera.notificarResultado(pedido);
		verify(validacionMock).crearNotificacionPush(billetera);
	}

	@Test
	void siNuncaSeProcesaElPagoNoSeLlamaNingunaValidacion() {
		verify(validacionMock, never()).tieneSaldoSuficiente(any());
		verify(validacionMock, never()).bloquearSaldo(any());
		verify(validacionMock, never()).acreditarSaldo(any());
		verify(validacionMock, never()).crearNotificacionPush(any());
	}
}
