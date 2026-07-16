package ar.edu.unq.po2.tpIntegrador.creacionDeProductos;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DepositoTest {

	Deposito deposito;
	IItem itemMock;
	IItem otroItemMock;

	@BeforeEach
	void setUp() throws Exception {
		itemMock = mock(IItem.class);
		otroItemMock = mock(IItem.class);

		deposito = new Deposito("Deposito Central");
	}

	@Test
	void elDepositoSeCreaConElNombreRecibido() {
		assertEquals("Deposito Central", deposito.getNombre());
	}

	@Test
	void setNombreCambiaElNombreDelDeposito() {
		deposito.setNombre("Deposito Sur");

		assertEquals("Deposito Sur", deposito.getNombre());
	}

	@Test
	void elDepositoSeCreaSinStockRegistrado() {
		assertTrue(deposito.getStock().isEmpty());
	}
	
	@Test
	void getStockDeDevuelveCeroParaUnItemSinStockRegistrado() {
		assertEquals(0, deposito.getStockDe(itemMock));
	}
	
	@Test
	void agregarStockRegistraLaCantidadIndicada() {
		deposito.agregarStock(itemMock, 7);

		assertEquals(7, deposito.getStockDe(itemMock));
	}

	@Test
	void agregarStockVariasVecesAcumulaLaCantidad() {
		deposito.agregarStock(itemMock, 7);
		deposito.agregarStock(itemMock, 3);

		assertEquals(10, deposito.getStockDe(itemMock));
	}

	@Test
	void getStockDeDevuelveElStockQueReportaElItem() {
		deposito.agregarStock(itemMock, 7);

		assertEquals(7, deposito.getStockDe(itemMock));
	}
	
	@Test
	void incrementarStockSumaUnaUnidad() {
		deposito.agregarStock(itemMock, 4);

		deposito.incrementarStock(itemMock);

		assertEquals(5, deposito.getStockDe(itemMock));
	}

	@Test
	void incrementarStockFuncionaAunSinStockPrevioCargado() {
		deposito.incrementarStock(itemMock);

		assertEquals(1, deposito.getStockDe(itemMock));
	}

	@Test
	void decrementarStockRestaUnaUnidad() {
		deposito.agregarStock(itemMock, 4);

		deposito.decrementarStock(itemMock);

		assertEquals(3, deposito.getStockDe(itemMock));
	}

	@Test
	void decrementarStockNoBajaDeCeroSiNoHayStockCargado() {
		deposito.decrementarStock(itemMock);

		assertEquals(0, deposito.getStockDe(itemMock));
	}

	@Test
	void getStockDevuelveElMapaCompletoDeStockPorItem() {
		deposito.agregarStock(itemMock, 5);
		deposito.agregarStock(otroItemMock, 2);

		assertEquals(2, deposito.getStock().size());
		assertEquals(5, deposito.getStock().get(itemMock));
	}
}