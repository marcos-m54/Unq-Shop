package ar.edu.unq.po2.tpIntegrador;

import static org.junit.jupiter.api.Assertions.*;

import org.mockito.InOrder;
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
		
		
	}

	@Test
	void pedidoBasicoConProductosSinPaquetes() {
		
		
		//Cuando se inicia el pedido, el estado inicial es BORRADOR
		//Camila agrega el auricularGueimer y la TV
		
		when(auricularGueimer.getStock()).thenReturn(5);
		when(tvDe200PulgadasSamsung.getStock()).thenReturn(5);
		when(arrocera.getStock()).thenReturn(0);
		
		pedidoTest.agregarItem(auricularGueimer);
		pedidoTest.agregarItem(tvDe200PulgadasSamsung);		

		InOrder orden = inOrder(spyItems);
		orden.verify(spyItems).add(auricularGueimer);
		orden.verify(spyItems).add(tvDe200PulgadasSamsung);
		
		assertEquals(pedidoTest.getItems().contains(auricularGueimer), true);
		assertEquals(pedidoTest.getItems().contains(tvDe200PulgadasSamsung), true);
		
		verify(auricularGueimer, atLeast(1)).getStock();	
		verify(tvDe200PulgadasSamsung, atLeast(1)).getStock();	
		
		//cuando intenta agregar la arrocera que esta fuera de stock, 
		//no se agrega a la lista del carrito
		
		pedidoTest.agregarItem(arrocera);
		assertEquals(pedidoTest.getItems().size(),2);
			
		
		
		
		
		
		
		
	}

}
