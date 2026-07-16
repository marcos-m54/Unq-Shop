package ar.edu.unq.po2.tpIntegrador.busquedaItems;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.Categoria;
import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.IItem;

class CriterioPorCategoriaTest {
	
	
	ICriterio busquedaElectrodomestico;
	ICriterio busquedaDeportes;
	ICriterio busquedaIndumentaria;
		
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
	
	Categoria electrodomestico;
	Categoria indumentaria;
	Categoria deportes;
	
	ArrayList<IItem> itemsMock;
	

	@BeforeEach
	void setUp() {
		
		
		itemsMock = spy(new ArrayList<IItem>());

		electrodomestico = mock(Categoria.class);
		indumentaria = mock(Categoria.class);
		deportes = mock(Categoria.class);
		
		busquedaElectrodomestico = new CriterioPorCategoria(electrodomestico);
		busquedaDeportes = new CriterioPorCategoria(deportes);
		busquedaIndumentaria = new CriterioPorCategoria(indumentaria);
		
		
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
		
		when(motorolaG5.getCategoria()).thenReturn(electrodomestico);
		when(bicicleta.getCategoria()).thenReturn(deportes);
		when(freidora.getCategoria()).thenReturn(electrodomestico);
		when(remera.getCategoria()).thenReturn(indumentaria);
		when(hornoElectrico.getCategoria()).thenReturn(electrodomestico);
		when(heladera.getCategoria()).thenReturn(electrodomestico);
		when(pelotaDeVoley.getCategoria()).thenReturn(deportes);
		when(tvLed.getCategoria()).thenReturn(electrodomestico);
		when(pantalonLevi.getCategoria()).thenReturn(indumentaria);
		when(camisetaArg.getCategoria()).thenReturn(indumentaria);

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
	void busquedaDeItemsConCategoriaElectrodomestico() {
		assertEquals(busquedaElectrodomestico.filtrar(itemsMock).size(), 5);
	}
	
	@Test
	void busquedaDeItemsConCategoriaDeportes() {
		assertEquals(busquedaDeportes.filtrar(itemsMock).size(), 2);
	}

	
	@Test
	void busquedaDeItemsConCategoriaIndumentaria() {
		assertEquals(busquedaIndumentaria.filtrar(itemsMock).size(), 3);
	}
	
	@Test
	void noPuedoAgregarCriteriosDeBusquedaPorqueEsCriterioSimple() {
		ICriterio criterioCategoria = new CriterioPorCategoria(deportes);
	    ICriterio otroCriterio = mock(ICriterio.class);
	    
	    UnsupportedOperationException excepcionLanzada = assertThrows(
	            UnsupportedOperationException.class, 
	            () -> {
	                criterioCategoria.agregarCriterio(otroCriterio);
	            }
	     );
	    
	    assertEquals("No puede agregar, es un criterio simple", excepcionLanzada.getMessage());
	}
	
	
	@Test
	void noPuedoSacarCriteriosDeBusquedaPorqueEsCriterioSimple() {
	
		ICriterio criterioCategoria = new CriterioPorCategoria(deportes);
	    ICriterio otroCriterio = mock(ICriterio.class);
	    
	    UnsupportedOperationException excepcionLanzada = assertThrows(
	            UnsupportedOperationException.class, 
	            () -> {
	            	criterioCategoria.sacarCriterio(otroCriterio);
	            }
	     );
	    
	    assertEquals("No puede sacar, es un criterio simple", excepcionLanzada.getMessage());
	}

}


