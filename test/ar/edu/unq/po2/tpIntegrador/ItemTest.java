package ar.edu.unq.po2.tpIntegrador;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

// import java.util.List;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.Atributo;
import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.Categoria;
import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.Producto;

class ItemTest {
	
	Producto celular;
	Producto televisor;
	Producto freidoraAire;
	Producto hornoElectrico;
	Producto bicicleta;
	Producto camiseta;
	
	Categoria tecnologia;
    Categoria electrodomestico;
    Categoria deportes;
    Categoria indumentaria;
	
	//Atributo colorAzul;

	@BeforeEach
	void setUp() throws Exception {
		
		// Nombre Descripcion
		tecnologia = new Categoria("Tecnologia", "Productos tecnologicos");
        electrodomestico = new Categoria("Electrodomestico", "Articulos del hogar");
        deportes = new Categoria("Deportes", "Articulos deportivos");
        indumentaria = new Categoria("Indumentaria", "Ropa y accesorios");
        
		// Sku, Modelo, Marca, $, Descuento, Stock, Peso, Descripcion
		celular = new Producto("MOTO-G86-256", "Moto G86", "Motorola", 700000.0, 10, 5, 186.0, "Celular gama media", new ArrayList<>());
		televisor = new Producto("Sams-xxx-0001", "Samsung Crystal", "Samsung", 900000.0, 0, 2, 8300.0, "Samsung Crystal 50", new ArrayList<>());
		freidoraAire = new Producto("Atma-Fre-0002", "FR246ABP", "Atma", 190000.0, 10, 10, 5100.0, "Frediora Atma con visor de 6 litros", new ArrayList<>());
		hornoElectrico = new Producto("Atma-Hor-0003", "HGAB4523PI", "Atma", 230000.0, 30, 5, 7500.0, "Horno electrico Atma de 45 litros", new ArrayList<>());
		bicicleta = new Producto("Nord-xxx-0004", "x1.0", "Nordic", 500000.0, 50, 20, 12000.0, "Mountain bick rodado 29", new ArrayList<>());
		camiseta = new Producto("Adid-xxx-005", "Seleccion Argentina", "Adidas", 220000.0, 10, 5, 180.0, "Camiseta titular Seleccion Argentina", new ArrayList<>());
		
		//colorAzul = new Atributo("color", "azul");
	
	
		celular.setCategoria(tecnologia);
        televisor.setCategoria(tecnologia);
        freidoraAire.setCategoria(electrodomestico);
        hornoElectrico.setCategoria(electrodomestico);
        bicicleta.setCategoria(deportes);
        camiseta.setCategoria(indumentaria);
	}
	
	
	@Test
	void productoPrecioBaseSinDescuento() {
	    assertEquals(700000.0, celular.getPrecioBase());
	}
	
	@Test
	void productoPrecioFinalConDescuento() {
	    assertEquals(630000.0, celular.precioFinal());
	}
	
	@Test
	void productoSinDescuentoPrecioFinalIgualBase() {
	    assertEquals(televisor.getPrecioBase(), televisor.precioFinal());
	}
	
	@Test
	void productoConDescuento() {
	    assertEquals(250000.0, bicicleta.precioFinal());
	}

	@Test
	void agregarAtributosDinamicosTest() {
	//	televisor.agregarAtributo("color", "azul");
	//	assertEquals(televisor.getAtributos(), List.of(colorAzul)); 
		
		// Nota de Yami: no supe usar List Of, investigue y funciona comparando equals. Supuestamente deberiamos agregarlo a nuestra clase para que funcione.
	}
	
	void agregarUnAtributoDinamico() {
	    celular.agregarAtributo("color", "azul");
	    
	    Atributo primero = celular.getAtributos().get(0);
	    
	    assertEquals("color", primero.getNombre()); // Nota Yami: Opcion 1: con variable
	    assertEquals("negro", celular.getAtributos().get(0).getDescripcion()); // Nota Yami: Opcion 2: todo en una linea
	}

	@Test
	void agregarYControlarVariosAtributosDinamicos() {
	    televisor.agregarAtributo("alto", "120cm");
	    televisor.agregarAtributo("ancho", "85cm");
	    televisor.agregarAtributo("resolucion", "4K");
	    assertEquals(3, televisor.getAtributos().size());
	}

	@Test
	void losAtributosSonPropioDeCadaProducto() {
	    celular.agregarAtributo("color", "negro");
	    assertTrue(televisor.getAtributos().isEmpty());
	}
	
}