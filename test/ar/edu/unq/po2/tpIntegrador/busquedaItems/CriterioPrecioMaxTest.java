package ar.edu.unq.po2.tpIntegrador.busquedaItems;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.IItem;

class CriterioPrecioMaxTest {

	ICriterio busquedaPrecioMax;
	
	IItem motorolaG5;
	IItem bicicleta;
	IItem freidora;
	IItem remera;
	IItem hornoElectrico;
	IItem heladera;
	IItem pelotaDeVoley;
	IItem tvLed;
	IItem pantalonLevi;
	IItem camisetaArg;
	
	ArrayList<IItem> itemsMock;
	
	@BeforeEach
	void setUp(){
		
		itemsMock = spy(new ArrayList<IItem>());
		
		busquedaPrecioMax = new CriterioPrecioMax(20000.00);
		
		motorolaG5 = mock(IItem.class);
		bicicleta = mock(IItem.class);
		freidora = mock(IItem.class);
		remera = mock(IItem.class);
		hornoElectrico = mock(IItem.class);
		heladera = mock(IItem.class);
		pelotaDeVoley = mock(IItem.class);
		tvLed = mock(IItem.class);
		pantalonLevi = mock(IItem.class);
		camisetaArg = mock(IItem.class);
		
		when(motorolaG5.precioFinal()).thenReturn(150000.00);
		when(bicicleta.precioFinal()).thenReturn(100000.00);
		when(freidora.precioFinal()).thenReturn(19000.00);
		when(remera.precioFinal()).thenReturn(10000.00);
		when(hornoElectrico.precioFinal()).thenReturn(90000.00);
		when(heladera.precioFinal()).thenReturn(99999.00);
		when(pelotaDeVoley.precioFinal()).thenReturn(5000.00);
		when(tvLed.precioFinal()).thenReturn(150000.00);
		when(pantalonLevi.precioFinal()).thenReturn(30000.00);
		when(camisetaArg.precioFinal()).thenReturn(19000.00);

		itemsMock.add(motorolaG5);
		itemsMock.add(bicicleta);
		itemsMock.add(freidora);
		itemsMock.add(remera);
		itemsMock.add(hornoElectrico);
		itemsMock.add(heladera);
		itemsMock.add(pelotaDeVoley);
		itemsMock.add(tvLed);
		itemsMock.add(pantalonLevi);
		itemsMock.add(camisetaArg);		
	}

	@Test
	void itemsPrecioMaxIgualAVeinteMilTest() {
		assertEquals(busquedaPrecioMax.filtrar(itemsMock).size(),4);
	}

}
