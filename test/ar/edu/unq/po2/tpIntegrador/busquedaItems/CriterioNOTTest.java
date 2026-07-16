package ar.edu.unq.po2.tpIntegrador.busquedaItems;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.Categoria;
import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.IItem;
import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.Sistema;

class CriterioNOTTest {
	
	ICriterio noDisponible;
	ICriterio noContieneMotoONoestaDisponible;
	ICriterio contieneMoto;
	
		
	IItem motorolaG5;
	IItem samsungS20;
	IItem motorolaG20;
	IItem motorolaG9999;
	IItem iphone11;
	IItem iphone5c;
	IItem samsungJ2;
	IItem samsungJ7;	
	IItem samsungA30;
	IItem samsungA33;
	
	Categoria electrodomestico;
	
	Sistema sistema;
	ArrayList<IItem> itemsMock;

	@BeforeEach
	void setUp() throws Exception {
		
		itemsMock = spy(new ArrayList<IItem>());
		sistema = mock(Sistema.class);
		electrodomestico = mock(Categoria.class);
		
		
		noDisponible = new CriterioNOT(new CriterioPorDisponibilidad());
		contieneMoto = new CriterioPorNombre("moto");
		noContieneMotoONoestaDisponible = new CriterioOR();
		
		motorolaG5 = mock(IItem.class);
		samsungS20 = mock(IItem.class);
		motorolaG20 = mock(IItem.class);
		motorolaG9999 = mock(IItem.class);
		iphone11 = mock(IItem.class);
		iphone5c = mock(IItem.class);
		samsungJ2 = mock(IItem.class);
		samsungJ7 = mock(IItem.class);	
		samsungA30 = mock(IItem.class);
		samsungA33 = mock(IItem.class);
		
		when(motorolaG5.getNombre()).thenReturn("Motorola g5");
		when(motorolaG5.precioFinal()).thenReturn(23000.00);
		when(motorolaG5.getStock()).thenReturn(20);
		when(motorolaG5.getCategoria()).thenReturn(electrodomestico);
		
		when(samsungS20.getNombre()).thenReturn("Samsung S20");
		when(samsungS20.precioFinal()).thenReturn(20000.00);
		when(samsungS20.getStock()).thenReturn(1);
		when(samsungS20.getCategoria()).thenReturn(electrodomestico);

		when(motorolaG20.getNombre()).thenReturn("Motorola G20");
		when(motorolaG20.precioFinal()).thenReturn(45000.00);
		when(motorolaG20.getStock()).thenReturn(15);
		when(motorolaG20.getCategoria()).thenReturn(electrodomestico);

		when(motorolaG9999.getNombre()).thenReturn("Motorola G9999");
		when(motorolaG9999.precioFinal()).thenReturn(25000.00);
		when(motorolaG9999.getStock()).thenReturn(5);
		when(motorolaG9999.getCategoria()).thenReturn(electrodomestico);

		when(iphone11.getNombre()).thenReturn("iphone 11");
		when(iphone11.precioFinal()).thenReturn(120000.00);
		when(iphone11.getStock()).thenReturn(8);
		when(iphone11.getCategoria()).thenReturn(electrodomestico);

		when(iphone5c.getNombre()).thenReturn("iPhone 5c");
		when(iphone5c.precioFinal()).thenReturn(15000.00);
		when(iphone5c.getStock()).thenReturn(3);
		when(iphone5c.getCategoria()).thenReturn(electrodomestico);

		when(samsungJ2.getNombre()).thenReturn("Samsung J2");
		when(samsungJ2.precioFinal()).thenReturn(8000.00);
		when(samsungJ2.getStock()).thenReturn(0);
		when(samsungJ2.getCategoria()).thenReturn(electrodomestico);

		when(samsungJ7.getNombre()).thenReturn("Samsung J7");
		when(samsungJ7.precioFinal()).thenReturn(12000.00);
		when(samsungJ7.getStock()).thenReturn(10);
		when(samsungJ7.getCategoria()).thenReturn(electrodomestico);

		when(samsungA30.getNombre()).thenReturn("Samsung A30");
		when(samsungA30.precioFinal()).thenReturn(35000.00);
		when(samsungA30.getStock()).thenReturn(12);
		when(samsungA30.getCategoria()).thenReturn(electrodomestico);

		when(samsungA33.getNombre()).thenReturn("Samsung A33");
		when(samsungA33.precioFinal()).thenReturn(55000.00);
		when(samsungA33.getStock()).thenReturn(18);
		when(samsungA33.getCategoria()).thenReturn(electrodomestico);
		

		itemsMock.add(motorolaG5);
		itemsMock.add(samsungS20);
		itemsMock.add(motorolaG20);
		itemsMock.add(motorolaG9999);
		itemsMock.add(iphone11);
		itemsMock.add(iphone5c);
		itemsMock.add(samsungJ2);
		itemsMock.add(samsungJ7);
		itemsMock.add(samsungA30);
		itemsMock.add(samsungA33);
	
		
	}

	@Test
	void BusquedaQuenoContienePalabraMotoONoestaDisponible() {
		
		ICriterio noContieneMoto = new CriterioNOT(contieneMoto);
		noContieneMotoONoestaDisponible.agregarCriterio(noContieneMoto);
		noContieneMotoONoestaDisponible.agregarCriterio(noDisponible);
		
		List<IItem> resultado = noContieneMotoONoestaDisponible.filtrar(itemsMock);
		
		assertEquals(7, resultado.size());
		assertEquals(List.of(samsungS20, iphone11, iphone5c, samsungJ2, samsungJ7, samsungA30, samsungA33), resultado);
		
		}
	
	
	@Test
	void noPuedoAgregarCriteriosDeBusquedaPorqueEsCriterioSimple() {
		ICriterio criterioNot = new CriterioNOT(contieneMoto);
	    ICriterio otroCriterio = mock(ICriterio.class);
	    
	    UnsupportedOperationException excepcionLanzada = assertThrows(
	            UnsupportedOperationException.class, 
	            () -> {
	                criterioNot.agregarCriterio(otroCriterio);
	            }
	     );
	    
	    assertEquals("No puede agregar, es un criterio simple", excepcionLanzada.getMessage());
	}
	
	
	@Test
	void noPuedoSacarCriteriosDeBusquedaPorqueEsCriterioSimple() {
		
		ICriterio criterioNot = new CriterioNOT(contieneMoto);
	    ICriterio otroCriterio = mock(ICriterio.class);
	    
	    UnsupportedOperationException excepcionLanzada = assertThrows(
	            UnsupportedOperationException.class, 
	            () -> {
	            	criterioNot.sacarCriterio(otroCriterio);
	            }
	     );
	    
	    assertEquals("No puede sacar, es un criterio simple", excepcionLanzada.getMessage());
	}

}
