package ar.edu.unq.po2.tpIntegrador.busquedaItems;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.Categoria;
import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.IItem;
import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.Sistema;

class CriterioORTest {
	
	ICriterio precioMax35MilONombreContieneCami;
	ICriterio noDispobileONombreEmpiezaConIp;
	
	IItem xiaomiPocoF1;
	IItem pelotaJabulani;
	IItem camisetaDeMessi;
	IItem pantalonTerceraMarca;
	IItem iphone24;
	IItem iphone2c;
	IItem samsungTVQLED;
	IItem playstation7;	
	IItem steamMachine;
	IItem camisetaFerrari;
	
	Categoria electrodomestico;
	Categoria deporte;
	Categoria indumentaria;
	
	Sistema sistema;
	ArrayList<IItem> itemsMock;

	@BeforeEach
	void setUp() throws Exception {
		
		itemsMock = spy(new ArrayList<IItem>());
		sistema = mock(Sistema.class);
		
		electrodomestico = mock(Categoria.class);
		deporte = mock(Categoria.class);
		indumentaria = mock(Categoria.class);
		
		precioMax35MilONombreContieneCami = new CriterioOR();
		noDispobileONombreEmpiezaConIp = new CriterioOR();
		
		xiaomiPocoF1 = mock(IItem.class);
		pelotaJabulani = mock(IItem.class);
		camisetaDeMessi = mock(IItem.class);
		pantalonTerceraMarca = mock(IItem.class);
		iphone24 = mock(IItem.class);
		iphone2c = mock(IItem.class);
		samsungTVQLED = mock(IItem.class);
		playstation7 = mock(IItem.class);
		steamMachine = mock(IItem.class);
		camisetaFerrari = mock(IItem.class);
		
		when(xiaomiPocoF1.getNombre()).thenReturn("Xiaomi Poco F1");
		when(xiaomiPocoF1.precioFinal()).thenReturn(25000.00);
		//when(xiaomiPocoF1.getStock()).thenReturn(0);
		when(sistema.hayStockDisponibleDe(xiaomiPocoF1)).thenReturn(false);
		when(xiaomiPocoF1.getCategoria()).thenReturn(electrodomestico);
		
		when(pelotaJabulani.getNombre()).thenReturn("Pelota Jabulani");
		when(pelotaJabulani.precioFinal()).thenReturn(5000.00);
		//when(pelotaJabulani.getStock()).thenReturn(145);
		when(sistema.hayStockDisponibleDe(pelotaJabulani)).thenReturn(true);
		when(pelotaJabulani.getCategoria()).thenReturn(deporte);

		when(camisetaDeMessi.getNombre()).thenReturn("Camiseta De Messi");
		when(camisetaDeMessi.precioFinal()).thenReturn(999999.00);
		//when(camisetaDeMessi.getStock()).thenReturn(230);
		when(sistema.hayStockDisponibleDe(camisetaDeMessi)).thenReturn(true);
		when(camisetaDeMessi.getCategoria()).thenReturn(deporte);

		when(pantalonTerceraMarca.getNombre()).thenReturn("Pantalon de tercera marca");
		when(pantalonTerceraMarca.precioFinal()).thenReturn(250.00);
		//when(pantalonTerceraMarca.getStock()).thenReturn(100);
		when(sistema.hayStockDisponibleDe(pantalonTerceraMarca)).thenReturn(true);
		when(pantalonTerceraMarca.getCategoria()).thenReturn(indumentaria);

		when(iphone24.getNombre()).thenReturn("iphone 24");
		when(iphone24.precioFinal()).thenReturn(120000.00);
		//when(iphone24.getStock()).thenReturn(8);
		when(sistema.hayStockDisponibleDe(iphone24)).thenReturn(true);
		when(iphone24.getCategoria()).thenReturn(electrodomestico);

		when(iphone2c.getNombre()).thenReturn("iPhone 2c");
		when(iphone2c.precioFinal()).thenReturn(100000.00);
		//when(iphone2c.getStock()).thenReturn(0);
		when(sistema.hayStockDisponibleDe(iphone2c)).thenReturn(false);
		when(iphone2c.getCategoria()).thenReturn(electrodomestico);

		when(samsungTVQLED.getNombre()).thenReturn("Samsung TV QLED");
		when(samsungTVQLED.precioFinal()).thenReturn(98000.00);
		//when(samsungTVQLED.getStock()).thenReturn(2);
		when(sistema.hayStockDisponibleDe(samsungTVQLED)).thenReturn(true);
		when(samsungTVQLED.getCategoria()).thenReturn(electrodomestico);

		when(playstation7.getNombre()).thenReturn("Playstation 7");
		when(playstation7.precioFinal()).thenReturn(122000.00);
		//when(playstation7.getStock()).thenReturn(10);
		when(sistema.hayStockDisponibleDe(playstation7)).thenReturn(true);
		when(playstation7.getCategoria()).thenReturn(electrodomestico);

		when(steamMachine.getNombre()).thenReturn("Steam Machine");
		when(steamMachine.precioFinal()).thenReturn(352000.00);
		//when(steamMachine.getStock()).thenReturn(12);
		when(sistema.hayStockDisponibleDe(steamMachine)).thenReturn(true);
		when(steamMachine.getCategoria()).thenReturn(electrodomestico);

		when(camisetaFerrari.getNombre()).thenReturn("Camiseta Ferrari");
		when(camisetaFerrari.precioFinal()).thenReturn(55000.00);
		//when(camisetaFerrari.getStock()).thenReturn(18);
		when(sistema.hayStockDisponibleDe(camisetaFerrari)).thenReturn(true);
		when(camisetaFerrari.getCategoria()).thenReturn(indumentaria);
		
		itemsMock.add(xiaomiPocoF1);
		itemsMock.add(pelotaJabulani);
		itemsMock.add(camisetaDeMessi);
		itemsMock.add(pantalonTerceraMarca);
		itemsMock.add(iphone24);
		itemsMock.add(iphone2c);
		itemsMock.add(samsungTVQLED);
		itemsMock.add(playstation7);
		itemsMock.add(steamMachine);
		itemsMock.add(camisetaFerrari);
	
	}

	@Test
	void busquedaConPrecioMax35MilONombreQueContengaCami() {
		
		ICriterio precioMax35MIL = new CriterioPrecioMax(35000.00);
		ICriterio nombreContieneCami = new CriterioPorNombre("cami");
		
		precioMax35MilONombreContieneCami.agregarCriterio(precioMax35MIL);
		precioMax35MilONombreContieneCami.agregarCriterio(nombreContieneCami);
		
		List<IItem> resultado = precioMax35MilONombreContieneCami.filtrar(itemsMock);
		
		assertEquals(5,resultado.size());
		assertEquals(List.of(xiaomiPocoF1, pelotaJabulani, pantalonTerceraMarca, camisetaDeMessi, camisetaFerrari), resultado);
		
	}
	
	@Test 
	void noDisponibleONombreContieneIp() {
		
		ICriterio disponibilidad = new CriterioPorDisponibilidad(sistema);
		ICriterio negacionDisponibilidad = new CriterioNOT(disponibilidad);
		ICriterio nombreContieneIp = new CriterioPorNombre("ip");
		
		noDispobileONombreEmpiezaConIp.agregarCriterio(negacionDisponibilidad);
		noDispobileONombreEmpiezaConIp.agregarCriterio(nombreContieneIp);
	
		List<IItem> resultado = noDispobileONombreEmpiezaConIp.filtrar(itemsMock);
		
		assertEquals(3,resultado.size());
		assertEquals(List.of(xiaomiPocoF1, iphone2c, iphone24), resultado);
		
	}
	
	@Test
	void noSePuedeFiltrarSiElCriterioNoEstaCompleto() {
	    ICriterio filtro1 = mock(ICriterio.class);
	    precioMax35MilONombreContieneCami.agregarCriterio(filtro1); 
	    
	    assertThrows(IndexOutOfBoundsException.class, () -> {
	    	precioMax35MilONombreContieneCami.filtrar(itemsMock);
	    });
	}
	
	@Test
	void alSacarUnCriterioEsteDejaDeSerEjecutado() {
		
	    ICriterio filtro1 = mock(ICriterio.class);
	    ICriterio filtro2 = mock(ICriterio.class);
	    ICriterio filtroNuevo = mock(ICriterio.class);
	    
	    when(filtro1.filtrar(any())).thenReturn(new ArrayList<>());
	    when(filtro2.filtrar(any())).thenReturn(new ArrayList<>());
	    when(filtroNuevo.filtrar(any())).thenReturn(new ArrayList<>());

	    precioMax35MilONombreContieneCami.agregarCriterio(filtro1);
	    precioMax35MilONombreContieneCami.agregarCriterio(filtro2);
	    
	    precioMax35MilONombreContieneCami.sacarCriterio(filtro2);
	    precioMax35MilONombreContieneCami.agregarCriterio(filtroNuevo);
	    
	    precioMax35MilONombreContieneCami.filtrar(itemsMock);
	    
	    verify(filtro1).filtrar(itemsMock);      
	    verify(filtroNuevo).filtrar(itemsMock); 
	    
	    verify(filtro2, never()).filtrar(any()); 
	    
	}

}
