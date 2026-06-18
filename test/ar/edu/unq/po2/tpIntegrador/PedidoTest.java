package ar.edu.unq.po2.tpIntegrador;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PedidoTest {
	
	Pedido pedidoTest;
	Pedido pedidoTestB;
	
	Producto iPhoneXXXL;
	Producto auricularGueimer;
	Producto tvDe200PulgadasSamsung;
	Producto arrocera;
	
	Usuario camilaDeBanfield;
	Usuario PedroDeLanus;
	
	
	

	@BeforeEach
	void setUp() throws Exception {
		
		pedidoTest  = new Pedido(camilaDeBanfield);
		pedidoTestB = new Pedido(PedroDeLanus);
		
		iPhoneXXXL = mock(Producto.class);
		auricularGueimer = mock(Producto.class);
		tvDe200PulgadasSamsung = mock(Producto.class);
		arrocera = mock(Producto.class);
		
		
	}

	@Test
	void pedidoBasicoConProductosSinPaquetes() {
		
		//Cuando se inicia el pedido, el estado inicial es BORRADOR
		//Camila agrega el auricularGueimer y la TV
		
		when(auricularGueimer.getStock()).thenReturn(5);
		when(tvDe200PulgadasSamsung.getStock()).thenReturn(5);
		
		pedidoTest.agregarItem(auricularGueimer);
		pedidoTest.agregarItem(tvDe200PulgadasSamsung);
		
		//verificando que a los productos se le pregunte 
		//por el stock al menos una vez
		
		verify(auricularGueimer, atLeast(1)).getStock();	
		verify(tvDe200PulgadasSamsung, atLeast(1)).getStock();	
		
		assertEquals(pedidoTest.getItems().size(),2);
		assertEquals(pedidoTest.getItems().contains(auricularGueimer), true);
		assertEquals(pedidoTest.getItems().contains(tvDe200PulgadasSamsung), true);

		//cuando intenta agregar la arrocera que esta fuera de stock, 
		//no se agrega a la lista del carrito
		
		when(arrocera.getStock()).thenReturn(0);
		pedidoTest.agregarItem(arrocera);
		assertEquals(pedidoTest.getItems().size(),2);
		
		
	}

}
