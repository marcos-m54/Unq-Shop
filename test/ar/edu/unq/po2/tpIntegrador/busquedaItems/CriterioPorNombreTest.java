package ar.edu.unq.po2.tpIntegrador.busquedaItems;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.mockito.InOrder;
import org.mockito.Mock;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.IItem;
import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.Sistema;

class CriterioPorNombreTest {
	
	ICriterio busquedaMotorola;
	ICriterio busquedaMotorolaMAYUS;
	
	ICriterio busquedaSamsung;
	ICriterio busquedaSamsungMAYUS;
	
	ICriterio busquedaPhone;
	ICriterio busquedaPhoneMAYUS;
	
	ICriterio busquedaTCL;
	ICriterio busquedaTCLminus;
	
	Sistema sistema;
	ArrayList<IItem> itemsMock;
	
	IItem motorolaG5;
	IItem samsungS20;
	IItem iphoneXL;
	IItem SonyXperiaPlay;
	IItem motorolaG20;
	IItem motorolaG9999;
	IItem iphone11;
	IItem iphone5c;
	IItem samsungJ2;
	IItem samsungJ7;	
	IItem samsungA30;
	IItem samsungA33;
	
	
	@BeforeEach
	void setUp() throws Exception {
	
		
		itemsMock = spy(new ArrayList<IItem>());
		sistema = mock(Sistema.class);
		
		busquedaMotorola = new CriterioPorNombre("moto");
		busquedaMotorolaMAYUS = new CriterioPorNombre("MOTO");
		
		busquedaSamsung = new CriterioPorNombre("sung");		
		busquedaSamsungMAYUS = new CriterioPorNombre("SUNG");
		
		busquedaPhone = new CriterioPorNombre("phone");
		busquedaPhoneMAYUS = new CriterioPorNombre("PHONE");
				
		busquedaTCL = new CriterioPorNombre("TCL");
		busquedaTCLminus = new CriterioPorNombre("minus");


		
		motorolaG5 = mock(IItem.class);
		samsungS20 = mock(IItem.class);
		iphoneXL = mock(IItem.class);
		SonyXperiaPlay = mock(IItem.class);
		motorolaG20 = mock(IItem.class);
		motorolaG9999 = mock(IItem.class);
		iphone11 = mock(IItem.class);
		iphone5c = mock(IItem.class);
		samsungJ2 = mock(IItem.class);
		samsungJ7 = mock(IItem.class);
		samsungA30 = mock(IItem.class);
		samsungA33 = mock(IItem.class);
		
		when(motorolaG5.getNombre()).thenReturn("Motorola g5");
		when(samsungS20.getNombre()).thenReturn("Samsung S20");
		when(iphoneXL.getNombre()).thenReturn("Iphone XL");
		when(SonyXperiaPlay.getNombre()).thenReturn("Sony Xperia Play");
		when(motorolaG20.getNombre()).thenReturn("Motorola g20");
		when(motorolaG9999.getNombre()).thenReturn("Motorola g9999");
		when(iphone11.getNombre()).thenReturn("Iphone 11");
		when(iphone5c.getNombre()).thenReturn("Iphone 5C");
		when(samsungJ2.getNombre()).thenReturn("Samsung J2");
		when(samsungJ7.getNombre()).thenReturn("Samsung J7");
		when(samsungA30.getNombre()).thenReturn("Samsung A30");
		when(samsungA33.getNombre()).thenReturn("Samsung A33");

		
		itemsMock.add(motorolaG5);
		itemsMock.add(samsungS20);
		itemsMock.add(iphoneXL);
		itemsMock.add(SonyXperiaPlay);
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
	void busquedaDeProductosQueContienenMoto() {
		
		//al buscar "moto" obtengo 3 items que coinciden con esa cadena
		assertEquals(busquedaMotorola.filtrar(itemsMock).size(),3);
			
	}
	
	@Test
	void busquedaDeProductosQueContienenMOTO() {
			
		//al buscar "MOTO" todo en mayuscula tambien obtengo 3 items
		assertEquals(busquedaMotorolaMAYUS.filtrar(itemsMock).size(),3);
			
	}

	@Test
	void busquedaDeProductosQueContienenSung() {
		
		//al buscar "sung" obtengo 5 resultados
		assertEquals(busquedaSamsung.filtrar(itemsMock).size(),5);

	}
	
	@Test
	void busquedaDeProductosQueContienenPhone() {
		
		//al buscar "phone" obtengo 3 resultados
		assertEquals(busquedaPhone.filtrar(itemsMock).size(),3);
		
	}
	
	@Test 
	void busquedaDeProductosQueContienenTCL(){
		
		//al buscar "TCL" obtengo 0 resultados
		assertEquals(busquedaTCL.filtrar(itemsMock).size(),0);
		
	}

}
