package ar.edu.unq.po2.tpIntegrador.creacionDeProductos;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SistemaTest {

	Sistema sistema;
	IItem itemMock;
	IItem otroItemMock;
	Sucursal sucursalMock;
	Sucursal otraSucursalMock;

	@BeforeEach
	void setUp() throws Exception {
		sistema = new Sistema();

		itemMock = mock(IItem.class);
		otroItemMock = mock(IItem.class);

		sucursalMock = mock(Sucursal.class);
		otraSucursalMock = mock(Sucursal.class);
	}

	@Test
	void sistemaSeCreaSinItemsNiSucursales() {
		assertTrue(sistema.getCatalogo().isEmpty());
		assertTrue(sistema.getSucursales().isEmpty());
	}

	@Test
	void agregarItemLoSumaAlCatalogo() {
		sistema.agregarItem(itemMock);

		assertEquals(1, sistema.getCatalogo().size());
		assertTrue(sistema.getCatalogo().contains(itemMock));
	}

	@Test
	void agregarVariosItemsQuedanTodosEnElCatalogo() {
		sistema.agregarItem(itemMock);
		sistema.agregarItem(otroItemMock);

		assertEquals(2, sistema.getCatalogo().size());
	}

	@Test
	void sacarItemLoQuitaDelCatalogo() {
		sistema.agregarItem(itemMock);
		sistema.agregarItem(otroItemMock);

		sistema.sacarItem(itemMock);

		assertEquals(1, sistema.getCatalogo().size());
		assertFalse(sistema.getCatalogo().contains(itemMock));
		assertTrue(sistema.getCatalogo().contains(otroItemMock));
	}

	@Test
	void sacarUnItemQueNoEstaNoRompeNiAfectaElCatalogo() {
		sistema.agregarItem(itemMock);

		sistema.sacarItem(otroItemMock);

		assertEquals(1, sistema.getCatalogo().size());
	}

	@Test
	void setSucursalAgregaUnaSucursalALaLista() {
		sistema.setSucursal(sucursalMock);

		assertEquals(1, sistema.getSucursales().size());
		assertTrue(sistema.getSucursales().contains(sucursalMock));
	}

	@Test
	void getSucursalesDevuelveTodasLasSucursalesAgregadas() {
		sistema.setSucursal(sucursalMock);
		sistema.setSucursal(otraSucursalMock);

		assertEquals(2, sistema.getSucursales().size());
		assertTrue(sistema.getSucursales().contains(sucursalMock));
		assertTrue(sistema.getSucursales().contains(otraSucursalMock));
	}
}
