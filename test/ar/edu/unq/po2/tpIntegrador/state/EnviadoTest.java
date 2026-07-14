package ar.edu.unq.po2.tpIntegrador.state;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
 
import java.util.ArrayList;
 
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
 
import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.IItem;
import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.Usuario;
//import ar.edu.unq.po2.tpIntegrador.notificaciones.Notificador;
 
class EnviadoTest {
 
	Pedido pedido;
	Usuario usuario;
	IItem itemMock;
 
	@BeforeEach
	void setUp() throws Exception {
		usuario = mock(Usuario.class);
		when(usuario.getNombreUsuario()).thenReturn("Juana Perez");
 
		itemMock = mock(IItem.class);
		when(itemMock.getStock()).thenReturn(3);
		when(itemMock.precioFinal()).thenReturn(1000.0);
 
		ArrayList<IItem> items = new ArrayList<>();
		items.add(itemMock);
 
		pedido = new Pedido(usuario, items);
		//pedido.setNotificador(new Notificador());
 
		pedido.setEstado(new Enviado(pedido));
	}
 
	@Test
	void enEnviadoNoSePuedenAgregarItems() {
		IItem itemNuevoMock = mock(IItem.class);
		when(itemNuevoMock.getStock()).thenReturn(10);
 
		pedido.getEstado().agregarItem(itemNuevoMock);
 
		assertFalse(pedido.getItems().contains(itemNuevoMock));
	}
 
	@Test
	void enEnviadoNoSePuedenQuitarItems() {
		pedido.getEstado().quitarItem(itemMock);
 
		assertTrue(pedido.getItems().contains(itemMock));
	}

	// ENVIADO --> ENTREGADO
 
	@Test
	void entregarPedidoDesdeEnviadoPasaAEntregado() {
		pedido.entregarPedido();
 
		assertTrue(pedido.getEstado() instanceof Entregado);
	}
 
	// ENVIADO --> CANCELADO
 
	@Test
	void cancelarPedidoDesdeEnviadoPasaACancelado() {
		pedido.cancelarPedido();
 
		assertTrue(pedido.getEstado() instanceof Cancelado);
	}
 
	@Test
	void cancelarPedidoDesdeEnviadoGeneraNotaDeCreditoSoloDelProducto() {
		// Enunciado: "si pasa a cancelado, solo se reembolsa el costo del producto pero no del envio". 
		// Por eso el monto de la nota de credito deberia ser pedido.montoTotal()
		pedido.cancelarPedido();
 
		assertEquals(1, pedido.getNotasDeCredito().size());
		
		Double montoDeLaNota = pedido.getNotasDeCredito().get(0).getMonto();
		assertEquals(1000.0, montoDeLaNota);
	}
 
	@Test
	void cancelarPedidoDesdeEnviadoNoReponeStock() {
		pedido.cancelarPedido();
 
		verify(itemMock, never()).incrementarStock();
	}

	@Test
	void confirmarPedidoDesdeEnviadoNoCambiaDeEstado() {
		pedido.confirmarPedido();
		assertTrue(pedido.getEstado() instanceof Enviado);
	}
 
	@Test
	void prepararPedidoDesdeEnviadoNoCambiaDeEstado() {
		pedido.prepararPedido();
		assertTrue(pedido.getEstado() instanceof Enviado);
	}
 
	@Test
	void enviarPedidoDesdeEnviadoNoCambiaDeEstado() {
		pedido.enviarPedido();
		assertTrue(pedido.getEstado() instanceof Enviado);
	}
}