package ar.edu.unq.po2.tpIntegrador.busquedaItems;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.IItem;

class CriterioPorDisponibilidadTest {
	
	ICriterio busquedaDisponibilidad;
	
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
		
		busquedaDisponibilidad = new CriterioPorDisponibilidad();
		
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
		
		when(motorolaG5.getStock()).thenReturn(0);
		when(bicicleta.getStock()).thenReturn(4);
		when(freidora.getStock()).thenReturn(20);
		when(remera.getStock()).thenReturn(2);
		when(hornoElectrico.getStock()).thenReturn(4);
		when(heladera.getStock()).thenReturn(1);
		when(pelotaDeVoley.getStock()).thenReturn(20);
		when(tvLed.getStock()).thenReturn(0);
		when(pantalonLevi.getStock()).thenReturn(0);
		when(camisetaArg.getStock()).thenReturn(0);

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
		assertEquals(busquedaDisponibilidad.filtrar(itemsMock).size(),6);
	}
	
	@Test
	void noPuedoAgregarCriteriosDeBusquedaPorqueEsCriterioSimple() {
		ICriterio criterioDisponibilidad = new CriterioPorDisponibilidad();
	    ICriterio otroCriterio = mock(ICriterio.class);
	    
	    UnsupportedOperationException excepcionLanzada = assertThrows(
	            UnsupportedOperationException.class, 
	            () -> {
	                criterioDisponibilidad.agregarCriterio(otroCriterio);
	            }
	     );
	    
	    assertEquals("No puede agregar, es un criterio simple", excepcionLanzada.getMessage());
	}
	
	
	@Test
	void noPuedoSacarCriteriosDeBusquedaPorqueEsCriterioSimple() {
	
		ICriterio criterioDisponibilidad = new CriterioPorDisponibilidad();
	    ICriterio otroCriterio = mock(ICriterio.class);
	    
	    UnsupportedOperationException excepcionLanzada = assertThrows(
	            UnsupportedOperationException.class, 
	            () -> {
	            	criterioDisponibilidad.sacarCriterio(otroCriterio);
	            }
	     );
	    
	    assertEquals("No puede sacar, es un criterio simple", excepcionLanzada.getMessage());
	}


}
