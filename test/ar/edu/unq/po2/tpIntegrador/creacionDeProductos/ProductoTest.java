package ar.edu.unq.po2.tpIntegrador.creacionDeProductos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductoTest {
		
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
					
			celular.setCategoria(tecnologia);
	        televisor.setCategoria(tecnologia);
	        freidoraAire.setCategoria(electrodomestico);
	        hornoElectrico.setCategoria(electrodomestico);
	        bicicleta.setCategoria(deportes);
	        camiseta.setCategoria(indumentaria);
	        
	        /*
	        // Sku Nombre
			celular = new Producto.Builder("MOTO-G86-256", "Moto G86")
					.marca("Motorola")
					.precioBase(700000.0)
					.descuento(10)
					.stock(5)
					.peso(186.0)
					.descripcion("Celular gama media")
					.categoria(tecnologia)
					.build();
	
			televisor = new Producto.Builder("Sams-xxx-0001", "Samsung Crystal")
					.marca("Samsung")
					.precioBase(900000.0)
					.descuento(0)
					.stock(2)
					.peso(8300.0)
					.descripcion("Samsung Crystal 50")
					.categoria(tecnologia)
					.build();
	
			freidoraAire = new Producto.Builder("Atma-Fre-0002", "FR246ABP")
					.marca("Atma")
					.precioBase(190000.0)
					.descuento(10)
					.stock(10)
					.peso(5100.0)
					.descripcion("Freidora Atma con visor de 6 litros")
					.categoria(electrodomestico)
					.build();
	
			hornoElectrico = new Producto.Builder("Atma-Hor-0003", "HGAB4523PI")
					.marca("Atma")
					.precioBase(230000.0)
					.descuento(30)
					.stock(5)
					.peso(7500.0)
					.descripcion("Horno electrico Atma de 45 litros")
					.categoria(electrodomestico)
					.build();
	
			bicicleta = new Producto.Builder("Nord-xxx-0004", "x1.0")
					.marca("Nordic")
					.precioBase(500000.0)
					.descuento(50)
					.stock(20)
					.peso(12000.0)
					.descripcion("Mountain bike rodado 29")
					.categoria(deportes)
					.build();
	
			camiseta = new Producto.Builder("Adid-xxx-005", "Seleccion Argentina")
					.marca("Adidas")
					.precioBase(220000.0)
					.descuento(10)
					.stock(5)
					.peso(180.0)
					.descripcion("Camiseta titular Seleccion Argentina")
					.categoria(indumentaria)
					.build();
	        */
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
		void productoSinAtributosInicialmente() {
			assertTrue(celular.getAtributos().isEmpty());
		}
		
		@Test
		void agregarUnAtributoDinamico() {
		    celular.agregarAtributo("color", "azul");
		    
		    Atributo primero = celular.getAtributos().get(0);
		    
		    assertEquals("color", primero.getNombre()); 
		    assertEquals("azul", primero.getDescripcion());
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
		@Test
		void productoGetNombre() {
		    assertEquals("Moto G86", celular.getNombre());
		}

		@Test
		void productoGetSKU() {
		    assertEquals("MOTO-G86-256", celular.getSKU());
		}

		@Test
		void productoGetMarca() {
		    assertEquals("Motorola", celular.getMarca());
		}

		@Test
		void productoGetStock() {
		    assertEquals(5, celular.getStock());
		}

		@Test
		void productoGetPeso() {
		    assertEquals(186.0, celular.getPeso());
		}

		@Test
		void productoGetCategoria() {
		    assertEquals(tecnologia, celular.getCategoria());
		}

		@Test
		void productoGetDescripcion() {
		    assertEquals("Celular gama media", celular.getDescripcion());
		}

		@Test
		void incrementarStockSumaUnaUnidad() {
		    celular.incrementarStock(); // 5 + 1 = 6
		    assertEquals(6, celular.getStock());
		}

		@Test
		void decrementarStockRestaUnaUnidad() {
		    celular.decrementarStock(); // 5 - 1 = 4
		    assertEquals(4, celular.getStock());
		}
		
		/*
		@Test
		void crearProductoConAtributosDesdeElBuilder() {
			Producto monitor = new Producto.Builder("LG-MON-0099", "Monitor LG")
					.marca("LG")
					.precioBase(150000.0)
					.atributo("alto", "45cm")
					.atributo("ancho", "60cm")
					.build();

			assertEquals(2, monitor.getAtributos().size());
			assertEquals("alto", monitor.getAtributos().get(0).getNombre());
		}

		@Test
		void productoSeCreaConValoresPorDefectoSiNoSeEspecifican() {
			Producto productoPrueba = new Producto.Builder("SKU-PRU-001", "Producto Prueba").build();

			assertEquals("SKU-PRU-001", productoPrueba.getSKU());
			assertEquals("Producto Prueba", productoPrueba.getNombre());
			assertEquals(0.0, productoPrueba.getPrecioBase());
			assertEquals(0, productoPrueba.getDescuento());
			assertEquals(0, productoPrueba.getStock());
			assertTrue(productoPrueba.getAtributos().isEmpty());
		}

		@Test
		void productoGetNombre() {
			assertEquals("Moto G86", celular.getNombre());
		}

		@Test
		void productoGetSKU() {
			assertEquals("MOTO-G86-256", celular.getSKU());
		}

		@Test
		void productoGetMarca() {
			assertEquals("Motorola", celular.getMarca());
		}

		@Test
		void productoGetStock() {
			assertEquals(5, celular.getStock());
		}

		@Test
		void productoGetPeso() {
			assertEquals(186.0, celular.getPeso());
		}

		@Test
		void productoGetCategoria() {
			assertEquals(tecnologia, celular.getCategoria());
		}

		@Test
		void productoGetDescripcion() {
			assertEquals("Celular gama media", celular.getDescripcion());
		}

		@Test
		void incrementarStockSumaUnaUnidad() {
			celular.incrementarStock(); // 5 + 1
			assertEquals(6, celular.getStock());
		}

		@Test
		void decrementarStockRestaUnaUnidad() {
			celular.decrementarStock(); // 5 - 1
			assertEquals(4, celular.getStock());
		}
		*/
		
	}