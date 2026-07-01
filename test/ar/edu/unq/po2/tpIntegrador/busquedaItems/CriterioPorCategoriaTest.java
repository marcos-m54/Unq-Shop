package ar.edu.unq.po2.tpIntegrador.busquedaItems;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.IItem;
import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.Sistema;

class CriterioPorCategoriaTest {
	
	
	ICriterio busquedaElectrodomestico;
	ICriterio busquedaDeportes;
	ICriterio Indumentaria;
	
	Sistema sistema;
	ArrayList<IItem> itemsMock;
	
	IItem motorolaG5;
	IItem bicicleta;
	IItem freidora;
	IItem remera;
	IItem hornoElectrico;
	
	
	

	@BeforeEach
	void setUp() throws Exception {
		
		
		
		
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
