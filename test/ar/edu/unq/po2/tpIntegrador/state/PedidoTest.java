package ar.edu.unq.po2.tpIntegrador.state;

import static org.junit.jupiter.api.Assertions.*;


import org.mockito.InOrder;

import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.IItem;
import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.Producto;
import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.Usuario;
import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.Sistema;

import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PedidoTest {
	
	Pedido pedidoTest;
	Pedido pedidoTestB;
	
	ArrayList<IItem> spyItems;

	Producto iPhoneXXXL;
	Producto auricularGueimer;
	Producto tvDe200PulgadasSamsung;
	Producto arrocera;
	
	Usuario camilaDeBanfield;
	Usuario pedroDeLanus;
	
	Sistema sistemaMock;

	@BeforeEach
	void setUp() throws Exception {
		
		
		camilaDeBanfield =  mock(Usuario.class);
		pedroDeLanus =  mock(Usuario.class);
		
		iPhoneXXXL = mock(Producto.class);
		auricularGueimer = mock(Producto.class);
		tvDe200PulgadasSamsung = mock(Producto.class);
		arrocera = mock(Producto.class);
		
		spyItems = spy(new ArrayList<IItem>());
		
		pedidoTest  = new Pedido(camilaDeBanfield, spyItems);
		pedidoTestB = new Pedido(pedroDeLanus, spyItems);
		
		// La disponibilidad de stock ahora la resuelve el Sistema, no el item
		sistemaMock = mock(Sistema.class);
		pedidoTest.setSistema(sistemaMock);
		pedidoTestB.setSistema(sistemaMock);
		
	}

	@Test
	void pedidoBasicoConProductosSinPaquetes() {
		
		
		//Cuando se inicia el pedido, el estado inicial es BORRADOR
		//Camila agrega el auricularGueimer y la TV
		
		when(sistemaMock.hayStockDisponibleDe(auricularGueimer)).thenReturn(true);
		when(sistemaMock.hayStockDisponibleDe(tvDe200PulgadasSamsung)).thenReturn(true);
		when(sistemaMock.hayStockDisponibleDe(arrocera)).thenReturn(false);
		
		pedidoTest.agregarItemACarrito(auricularGueimer);
		pedidoTest.agregarItemACarrito(tvDe200PulgadasSamsung);		

		InOrder orden = inOrder(spyItems);
		orden.verify(spyItems).add(auricularGueimer);
		orden.verify(spyItems).add(tvDe200PulgadasSamsung);
		
		assertEquals(pedidoTest.getItems().contains(auricularGueimer), true);
		assertEquals(pedidoTest.getItems().contains(tvDe200PulgadasSamsung), true);
		
		verify(sistemaMock, atLeast(1)).hayStockDisponibleDe(auricularGueimer);
		verify(sistemaMock, atLeast(1)).hayStockDisponibleDe(tvDe200PulgadasSamsung);
		
		//cuando intenta agregar la arrocera que esta fuera de stock, 
		//no se agrega a la lista del carrito
		
		pedidoTest.agregarItemACarrito(arrocera);
		assertEquals(pedidoTest.getItems().size(),2);
		
	}

}
