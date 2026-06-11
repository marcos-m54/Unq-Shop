package ar.edu.unq.po2.tpIntegrador;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ItemTest {
	
	Producto celular;
	Producto televisor;
	Producto arrocera;
	Producto hornoElectrico;
	Producto bicicleta;
	Producto camiseta;

	@BeforeEach
	void setUp() throws Exception {
		
		celular = new Producto();
		televisor = new Producto();
		arrocera = new Producto();
		hornoElectrico = new Producto();
		bicicleta = new Producto();
		camiseta = new Producto();
		
	}
	
	
	@Test
	void calculosDePreciosFinalConDescuentoTest() {
		assertEquals(celular.getPrecio(), 250000);
		assertEquals(celular.getPrecioBaseCalculado(), 260300.00);
	
	}

	
	@Test
	void agregarAtributosDinamicosTest() {
		fail("Not yet implemented");
	}
	
	
}