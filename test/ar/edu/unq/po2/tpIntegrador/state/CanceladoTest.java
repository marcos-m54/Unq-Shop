package ar.edu.unq.po2.tpIntegrador.state;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
 
import java.util.ArrayList;
 
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
 
import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.IItem;
import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.Usuario;
//import ar.edu.unq.po2.tpIntegrador.notificaciones.Notificador;
 
class CanceladoTest {
 
	Pedido pedido;
	Usuario usuario;
	IItem itemMock;
 
	@BeforeEach
	void setUp() throws Exception {
		usuario = mock(Usuario.class);
		itemMock = mock(IItem.class);
		when(itemMock.getStock()).thenReturn(3);
 
		ArrayList<IItem> items = new ArrayList<>();
		items.add(itemMock);
 
		pedido = new Pedido(usuario, items);
		//pedido.setNotificador(new Notificador());
 
		//pedido.setEstado(new Cancelado(pedido));
	}
 
	@Test
	void enCanceladoNoSePuedenAgregarItems() {
		IItem itemNuevoMock = mock(IItem.class);
		when(itemNuevoMock.getStock()).thenReturn(10);
 
		pedido.getEstado().agregarItem(itemNuevoMock);
 
		assertFalse(pedido.getItems().contains(itemNuevoMock));
	}
 
	@Test
	void enCanceladoNoSePuedenQuitarItems() {
		pedido.getEstado().quitarItem(itemMock);
 
		assertTrue(pedido.getItems().contains(itemMock));
	}
 
	@Test
	void confirmarPedidoDesdeCanceladoNoCambiaDeEstado() {
		pedido.confirmarPedido();
		assertTrue(pedido.getEstado() instanceof Cancelado);
	}
 
	@Test
	void cancelarPedidoDesdeCanceladoNoCambiaDeEstado() {
		pedido.cancelarPedido();
		assertTrue(pedido.getEstado() instanceof Cancelado);
	}
 
	@Test
	void prepararPedidoDesdeCanceladoNoCambiaDeEstado() {
		pedido.prepararPedido();
		assertTrue(pedido.getEstado() instanceof Cancelado);
	}
 
	@Test
	void enviarPedidoDesdeCanceladoNoCambiaDeEstado() {
		pedido.enviarPedido();
		assertTrue(pedido.getEstado() instanceof Cancelado);
	}
 
	@Test
	void entregarPedidoDesdeCanceladoNoCambiaDeEstado() {
		pedido.entregarPedido();
		assertTrue(pedido.getEstado() instanceof Cancelado);
	}
}
 