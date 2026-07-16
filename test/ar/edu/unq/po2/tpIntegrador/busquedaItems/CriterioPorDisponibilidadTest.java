package ar.edu.unq.po2.tpIntegrador.busquedaItems;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.IItem;
import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.Sistema;

class CriterioPorDisponibilidadTest {
	
	ICriterio busquedaDisponibilidad;
	Sistema sistemaMock;
	
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
	void setUp() {
		
		itemsMock = spy(new ArrayList<IItem>());
		
		sistemaMock = mock(Sistema.class);
		busquedaDisponibilidad = new CriterioPorDisponibilidad(sistemaMock);
		
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
		
		when(sistemaMock.hayStockDisponibleDe(motorolaG5)).thenReturn(false);
		when(sistemaMock.hayStockDisponibleDe(bicicleta)).thenReturn(true);
		when(sistemaMock.hayStockDisponibleDe(freidora)).thenReturn(true);
		when(sistemaMock.hayStockDisponibleDe(remera)).thenReturn(true);
		when(sistemaMock.hayStockDisponibleDe(hornoElectrico)).thenReturn(true);
		when(sistemaMock.hayStockDisponibleDe(heladera)).thenReturn(true);
		when(sistemaMock.hayStockDisponibleDe(pelotaDeVoley)).thenReturn(true);
		when(sistemaMock.hayStockDisponibleDe(tvLed)).thenReturn(false);
		when(sistemaMock.hayStockDisponibleDe(pantalonLevi)).thenReturn(false);
		when(sistemaMock.hayStockDisponibleDe(camisetaArg)).thenReturn(false);

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
	void itemsQueTienenStockTest() {
		assertEquals(6, busquedaDisponibilidad.filtrar(itemsMock).size());
	}
	
	@Test
	void siNingunItemTieneStockDisponibleDevuelveListaVacia() {
		ArrayList<IItem> soloSinStock = new ArrayList<>();
		soloSinStock.add(motorolaG5);
		soloSinStock.add(tvLed);
		assertTrue(busquedaDisponibilidad.filtrar(soloSinStock).isEmpty());
	}
    
	void noPuedoAgregarCriteriosDeBusquedaPorqueEsCriterioSimple() {
		ICriterio criterioDisponibilidad = new CriterioPorDisponibilidad(sistemaMock);
	    ICriterio otroCriterio = mock(ICriterio.class);
	    
	    UnsupportedOperationException excepcionLanzada = assertThrows(
	            UnsupportedOperationException.class, 
	            () -> {
	                criterioDisponibilidad.agregarCriterio(otroCriterio);
	    });
	
	    assertEquals("No puede agregar, es un criterio simple", excepcionLanzada.getMessage());
	
	}   
	


	@Test
	void noPuedoSacarCriteriosDeBusquedaPorqueEsCriterioSimple() {
	
		ICriterio criterioDisponibilidad = new CriterioPorDisponibilidad(sistemaMock);
	    ICriterio otroCriterio = mock(ICriterio.class);
	    
	    UnsupportedOperationException excepcionLanzada = assertThrows(
	            UnsupportedOperationException.class, 
	            () -> {
	            	criterioDisponibilidad.sacarCriterio(otroCriterio);
	    });
	    
	    assertEquals("No puede sacar, es un criterio simple", excepcionLanzada.getMessage());
		}
	}
