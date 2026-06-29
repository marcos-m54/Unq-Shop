package ar.edu.unq.po2.tpIntegrador.state;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
 
import java.util.ArrayList;
 
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
 
import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.IItem;
import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.Usuario;
import ar.edu.unq.po2.tpIntegrador.envio.IFormaDeEnvio;
import ar.edu.unq.po2.tpIntegrador.notificaciones.Notificador;
 
class ConfirmadoTest {
 
	Pedido pedido;
	Usuario usuario;
	IItem itemMock;
	IFormaDeEnvio envioMock;
 
	@BeforeEach
	void setUp() throws Exception {
		usuario = mock(Usuario.class);
		when(usuario.getNombreUsuario()).thenReturn("Juana Perez");
 
		itemMock = mock(IItem.class);
		when(itemMock.getStock()).thenReturn(3);
		when(itemMock.precioFinal()).thenReturn(1000.0);
 
		ArrayList<IItem> items = new ArrayList<>();
		items.add(itemMock);
		
		IFormaDeEnvio envioMock = mock(IFormaDeEnvio.class);
		when(envioMock.calcularValorDelEnvio(any())).thenReturn(200.0);
 
		pedido = new Pedido(usuario, items);
		pedido.setNotificador(new Notificador());
		pedido.setFormaDeEnvio(envioMock);
 
		pedido.setEstado(new Confirmado(pedido));
	}
 
	@Test
	void enConfirmadoNoSePuedenAgregarItems() {
		IItem itemNuevoMock = mock(IItem.class);
		when(itemNuevoMock.getStock()).thenReturn(10);
 
		pedido.getEstado().agregarItem(itemNuevoMock);
 
		assertFalse(pedido.getItems().contains(itemNuevoMock));
	}
 
	@Test
	void enConfirmadoNoSePuedenQuitarItems() {
		pedido.getEstado().quitarItem(itemMock);
 
		assertTrue(pedido.getItems().contains(itemMock));
	}

	// CONFIRMADO --> EN PREPARACION
 
	@Test
	void prepararPedidoDesdeConfirmadoPasaAEnPreparacion() {
		pedido.prepararPedido();
 
		assertTrue(pedido.getEstado() instanceof EnPreparacion);
	}
 
	// CONFIRMADO --> CANCELADO
	
	@Test
	void cancelarPedidoDesdeConfirmadoPasaACancelado() {
		pedido.cancelarPedido();
 
		assertTrue(pedido.getEstado() instanceof Cancelado);
	}
 
	@Test
	void cancelarPedidoDesdeConfirmadoReponeElStock() {
		pedido.cancelarPedido();
 
		// Verifico que se llamo a incrementarStock(), repone las unidades que se habian descontado al confirmar
		verify(itemMock).incrementarStock();
	}
 
	@Test
	void cancelarPedidoDesdeConfirmadoDeberiaGenerarNotaDeCredito() {
		// Nota Yami:
		// El enunciado dice que al cancelar desde Confirmado se reembolsa tanto el costo del producto como el del envio. 
		// Deberia generarse una NotaDeCredito, igual que en EnPreparacion.cancelarPedido()

		pedido.cancelarPedido();
 
		assertEquals(1, pedido.getNotasDeCredito().size());
		
		Double montoDeLaNota = pedido.getNotasDeCredito().get(0).getMonto();
		assertEquals(1200.0, montoDeLaNota);
	}

	@Test
	void confirmarPedidoDesdeConfirmadoNoCambiaDeEstado() {
		pedido.confirmarPedido();
		assertTrue(pedido.getEstado() instanceof Confirmado);
	}
 
	@Test
	void entregarPedidoDesdeConfirmadoNoCambiaDeEstado() {
		pedido.entregarPedido();
		assertTrue(pedido.getEstado() instanceof Confirmado);
	}
 
	@Test
	void enviarPedidoDesdeConfirmadoNoCambiaDeEstado() {
		pedido.enviarPedido();
		assertTrue(pedido.getEstado() instanceof Confirmado);
	}
}


