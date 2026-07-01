package ar.edu.unq.po2.tpIntegrador.creacionDeProductos;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

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

		deposito = new Deposito("Deposito Central", new ArrayList<>());
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
	void elDepositoSeCreaSinItemsSiSeLePasaUnaListaVacia() {
		assertTrue(deposito.getItems().isEmpty());
	}

	@Test
	void setItemAgregaUnItemALaListaDeItems() {
		deposito.setItem(itemMock);

		assertEquals(1, deposito.getItems().size());
		assertTrue(deposito.getItems().contains(itemMock));
	}

	@Test
	void setItemVariasVecesAcumulaTodosLosItems() {
		deposito.setItem(itemMock);
		deposito.setItem(otroItemMock);

		assertEquals(2, deposito.getItems().size());
	}

	@Test
	void getStockDeDevuelveElStockQueReportaElItem() {
		when(itemMock.getStock()).thenReturn(7);

		assertEquals(7, deposito.getStockDe(itemMock));
	}

	@Test
	void getStockDeDevuelveCeroSiElItemNoTieneStock() {
		when(itemMock.getStock()).thenReturn(0);

		assertEquals(0, deposito.getStockDe(itemMock));
	}
}