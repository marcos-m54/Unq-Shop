package ar.edu.unq.po2.tpIntegrador.state;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
 
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
 
import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.IItem;
import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.Usuario;
import ar.edu.unq.po2.tpIntegrador.envio.IFormaDeEnvio;
//import ar.edu.unq.po2.tpIntegrador.notificaciones.Notificador;
import ar.edu.unq.po2.tpIntegrador.pago.MetodoDePago;
import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.Sistema;
 
class BorradorTest {
 
	Pedido pedido;
	Usuario usuario;
	IItem itemMock;
	Sistema sistemaMock;
	
	@BeforeEach
	void setUp() throws Exception {
		usuario = mock(Usuario.class);
		itemMock = mock(IItem.class);
 
		pedido = new Pedido(usuario, new ArrayList<IItem>());

	//	pedido.setNotificador(new Notificador());
		
		// La disponibilidad de stock ahora la resuelve el Sistema, no el item
		sistemaMock = mock(Sistema.class);
		pedido.setSistema(sistemaMock);
	}
 
	@Test
	void unPedidoNuevoArrancaEnEstadoBorrador() {
		assertTrue(pedido.getEstado() instanceof Borrador);
	}
 
	@Test
	void enBorradorSePuedeAgregarUnItemConStock() {
		when(sistemaMock.hayStockDisponibleDe(itemMock)).thenReturn(true);

		pedido.getEstado().agregarItem(itemMock);

		assertTrue(pedido.getItems().contains(itemMock));
	}
 
	@Test
	void enBorradorNoSeAgregaUnItemSinStock() {
		when(sistemaMock.hayStockDisponibleDe(itemMock)).thenReturn(false);

		pedido.getEstado().agregarItem(itemMock);

		assertFalse(pedido.getItems().contains(itemMock));
	}
 
	@Test
	void enBorradorSePuedeQuitarUnItem() {
		when(sistemaMock.hayStockDisponibleDe(itemMock)).thenReturn(true);
		pedido.getEstado().agregarItem(itemMock);

		pedido.getEstado().quitarItem(itemMock);

		assertFalse(pedido.getItems().contains(itemMock));
	}
 
	// BORRADOR --> CONFIRMADO 
 
	@Test
	void confirmarPedidoSinFormaDeEnvioNoCambiaDeEstado() {
		pedido.confirmarPedido();
 
		assertTrue(pedido.getEstado() instanceof Borrador);
	}
 
	@Test
	void confirmarPedidoConFormaDeEnvioPasaAConfirmado() {
		IFormaDeEnvio envioMock = mock(IFormaDeEnvio.class);
		MetodoDePago pagoMock = mock(MetodoDePago.class);
 
		pedido.setFormaDeEnvio(envioMock);
		pedido.setMetodoDePago(pagoMock);
 
		pedido.confirmarPedido();
 
		assertTrue(pedido.getEstado() instanceof Confirmado);
	}
 
	// BORRADOR --> CANCELADO
 
	@Test
	void cancelarPedidoEnBorradorPasaACancelado() {
		pedido.cancelarPedido();
 
		assertTrue(pedido.getEstado() instanceof Cancelado);
	}
	
	@Test
	void prepararPedidoEnBorradorNoCambiaDeEstado() {
		pedido.prepararPedido();
		assertTrue(pedido.getEstado() instanceof Borrador);
	}
 
	@Test
	void enviarPedidoEnBorradorNoCambiaDeEstado() {
		pedido.enviarPedido();
		assertTrue(pedido.getEstado() instanceof Borrador);
	}
}
 