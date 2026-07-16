package ar.edu.unq.po2.tpIntegrador.state;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
 
import java.util.ArrayList;
 
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
 
import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.IItem;
import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.Usuario;
import ar.edu.unq.po2.tpIntegrador.envio.IFormaDeEnvio;
import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.Sistema;
import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.Deposito;
//import ar.edu.unq.po2.tpIntegrador.notificaciones.Notificador;
 
class EnPreparacionTest {
 
	Pedido pedido;
	Usuario usuario;
	IItem itemMock;
	IFormaDeEnvio envioMock;
	Sistema sistemaMock;
	Deposito depositoMock;
	
	@BeforeEach
	void setUp() throws Exception {
		usuario = mock(Usuario.class);
		when(usuario.getNombreUsuario()).thenReturn("Juana Perez");
 
		itemMock = mock(IItem.class);
		when(itemMock.getPrecioBase()).thenReturn(1000.0);
		when(itemMock.precioFinal()).thenReturn(1000.0);
 
		ArrayList<IItem> items = new ArrayList<>();
		items.add(itemMock);
		
		envioMock = mock(IFormaDeEnvio.class);
		when(envioMock.calcularValorDelEnvio(any())).thenReturn(200.0);
 
		pedido = new Pedido(usuario, items);
	//	pedido.setNotificador(new Notificador());
		pedido.setFormaDeEnvio(envioMock);
		
		// EnPreparacion.cancelarPedido() repone stock via sistema.getDepositoDelItem(item).incrementarStock(item)
		sistemaMock = mock(Sistema.class);
		depositoMock = mock(Deposito.class);
		when(sistemaMock.getDepositoDelItem(itemMock)).thenReturn(depositoMock);
		pedido.setSistema(sistemaMock);
 
		pedido.setEstado(new EnPreparacion(pedido));
	}
 
	@Test
	void enPreparacionNoSePuedenAgregarItems() {
		IItem itemNuevoMock = mock(IItem.class);
 
		pedido.getEstado().agregarItem(itemNuevoMock);
 
		assertFalse(pedido.getItems().contains(itemNuevoMock));
	}
 
	@Test
	void enPreparacionNoSePuedenQuitarItems() {
		pedido.getEstado().quitarItem(itemMock);
 
		assertTrue(pedido.getItems().contains(itemMock));
	}

	// EN PREPARACION --> ENVIADO
 
	@Test
	void enviarPedidoDesdeEnPreparacionPasaAEnviado() {
		pedido.enviarPedido();
 
		assertTrue(pedido.getEstado() instanceof Enviado);
	}

	//  EN PREPARACION --> CANCELADO

	@Test
	void cancelarPedidoDesdeEnPreparacionPasaACancelado() {
		pedido.cancelarPedido();
 
		assertTrue(pedido.getEstado() instanceof Cancelado);
	}
 
	@Test
	void cancelarPedidoDesdeEnPreparacionReponeElStock() {
		pedido.cancelarPedido();
 
		verify(depositoMock).incrementarStock(itemMock);
	}
 
	@Test
	void cancelarPedidoDesdeEnPreparacionGeneraNotaDeCreditoConProductoYEnvio() {
		// Enunciado: "si se cancela, se repone el stock y se reembolsa tanto el costo de los productos como el del envio".
		// EnPreparacion usa montoTotalPedidoMasEnvio() 
		pedido.cancelarPedido();
 
		assertEquals(1, pedido.getNotasDeCredito().size());

		Double montoDeLaNota = pedido.getNotasDeCredito().get(0).getMonto();
		assertEquals(1200.0, montoDeLaNota);
	}

	@Test
	void confirmarPedidoDesdeEnPreparacionNoCambiaDeEstado() {
		pedido.confirmarPedido();
		assertTrue(pedido.getEstado() instanceof EnPreparacion);
	}
 
	@Test
	void entregarPedidoDesdeEnPreparacionNoCambiaDeEstado() {
		pedido.entregarPedido();
		assertTrue(pedido.getEstado() instanceof EnPreparacion);
	}
 
	@Test
	void prepararPedidoDesdeEnPreparacionNoCambiaDeEstado() {
		pedido.prepararPedido();
		assertTrue(pedido.getEstado() instanceof EnPreparacion);
	}
}
 