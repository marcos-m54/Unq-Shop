package ar.edu.unq.po2.tpIntegrador.creacionDeProductos;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpIntegrador.state.Pedido;

class SucursalTest {

	Sucursal sucursal;
	Deposito depositoMock;
	IItem itemConStock;
	IItem itemSinStock;
	Usuario usuario;

	@BeforeEach
	void setUp() throws Exception {
		depositoMock = mock(Deposito.class);
		sucursal = new Sucursal("Sucursal Once", depositoMock);

		itemConStock = mock(IItem.class);
		itemSinStock = mock(IItem.class);

		usuario = new Usuario("Juana Perez", "juana@mail.com", "Calle Falsa 123");
	}

	@Test
	void laSucursalSeCreaConElNombreRecibido() {
		assertEquals("Sucursal Once", sucursal.getNombre());
	}

	@Test
	void setNombreCambiaElNombreDeLaSucursal() {
		sucursal.setNombre("Sucursal Caballito");

		assertEquals("Sucursal Caballito", sucursal.getNombre());
	}

	@Test
	void getDepositoDevuelveElDepositoAsignado() {
		assertEquals(depositoMock, sucursal.getDeposito());
	}

	@Test
	void setDepositoCambiaElDepositoDeLaSucursal() {
		Deposito otroDepositoMock = mock(Deposito.class);

		sucursal.setDeposito(otroDepositoMock);

		assertEquals(otroDepositoMock, sucursal.getDeposito());
	}

	@Test
	void hayStockDeDevuelveTrueSiElDepositoReportaStockPositivo() {
		when(depositoMock.getStockDe(itemConStock)).thenReturn(5);

		assertTrue(sucursal.hayStockDe(itemConStock));
	}

	@Test
	void hayStockDeDevuelveFalseSiElDepositoReportaStockCero() {
		when(depositoMock.getStockDe(itemSinStock)).thenReturn(0);

		assertFalse(sucursal.hayStockDe(itemSinStock));
	}

	@Test
	void hayStockDeItemsDePedidoEsTrueSiHayStockDeTodosLosItems() {
		when(depositoMock.getStockDe(itemConStock)).thenReturn(3);

		ArrayList<IItem> items = new ArrayList<>();
		items.add(itemConStock);

		Pedido pedido = new Pedido(usuario, items);

		assertTrue(sucursal.hayStockDeItemsDePedido(pedido));
	}

	@Test
	void hayStockDeItemsDePedidoEsFalseSiFaltaStockDeAlgunItem() {
		when(depositoMock.getStockDe(itemConStock)).thenReturn(3);
		when(depositoMock.getStockDe(itemSinStock)).thenReturn(0);

		ArrayList<IItem> items = new ArrayList<>();
		items.add(itemConStock);
		items.add(itemSinStock);

		Pedido pedido = new Pedido(usuario, items);

		assertFalse(sucursal.hayStockDeItemsDePedido(pedido));
	}
}
