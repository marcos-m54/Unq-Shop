package ar.edu.unq.po2.tpIntegrador;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ItemTest {
	
	Producto celular;
	Producto televisor;
	Producto arrocera;
	Producto hornoElectrico;
	Producto bicicleta;
	Producto camiseta;
	
	//Atributo colorAzul;

	@BeforeEach
	void setUp() throws Exception {
		
		celular = new Producto("unSKU","nombre","marca","precio","descuento","stock","peso","descripcion","categoria");
		televisor = new Producto();
		arrocera = new Producto();
		hornoElectrico = new Producto();
		bicicleta = new Producto();
		camiseta = new Producto();
		
		//colorAzul = new Atributo("color", "azul");
	}
	
	
	@Test
	void calculosDePreciosFinalConDescuentoTest() 

	}
	@Test
	void agregarAtributosDinamicosTest() {
	//	televisor.agregarAtributo("color", "azul");
	//	assertEquals(televisor.getAtributos(), List.of(colorAzul));
	}
	
	
}