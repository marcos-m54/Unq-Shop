package ar.edu.unq.po2.tpIntegrador.creacionDeProductos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PaqueteTest {

	    Producto celular;
	    Producto freidoraAire;
	    Producto hornoElectrico;
	    Producto televisor;
	    
	    Paquete packHogarTech;
	    Paquete kitHomeOffice;
	    Paquete comboSinDescuento;

	    @BeforeEach
	    void setUp() throws Exception {

	        celular = new Producto("MOTO-G86-256", "Moto G86", "Motorola", 700000.0, 10, 5, 186.0, "Celular gama media", new ArrayList<>());
	        freidoraAire = new Producto("ATMA-FRE-0002", "FR246ABP", "Atma", 190000.0, 10, 10, 5100.0, "Freidora Atma con visor de 6 litros", new ArrayList<>());
	        hornoElectrico = new Producto("ATMA-HOR-0003", "HGAB4523PI", "Atma", 230000.0, 30, 5, 7500.0, "Horno electrico Atma de 45 litros", new ArrayList<>());
	        televisor = new Producto("Sams-xxx-0001", "Samsung Crystal", "Samsung", 900000.0, 0, 2, 8300.0, "Samsung Crystal 50", new ArrayList<>());
	        
	        // packHogarTech celular y freidora con 15% descuento
	        packHogarTech = new Paquete("Pack Hogar Tech", "Celular y freidora", 15, new ArrayList<>());
	        packHogarTech.agregarItem(celular);
	        packHogarTech.agregarItem(freidoraAire);

	        // kitHomeOffice packHogarTech y horno con 10% descuento
	        kitHomeOffice = new Paquete("Kit Home Office", "Pack + Horno", 10, new ArrayList<>());
	        kitHomeOffice.agregarItem(packHogarTech);
	        kitHomeOffice.agregarItem(hornoElectrico);
	        
	        /*
		     celular = new Producto.Builder("MOTO-G86-256", "Moto G86")
					.marca("Motorola")
					.precioBase(700000.0)
					.descuento(10)
					.stock(5)
					.peso(186.0)
					.descripcion("Celular gama media")
					.build();
	
			freidoraAire = new Producto.Builder("Atma-Fre-0002", "FR246ABP")
					.marca("Atma")
					.precioBase(190000.0)
					.descuento(10)
					.stock(10)
					.peso(5100.0)
					.descripcion("Freidora Atma con visor de 6 litros")
					.build();
	
			hornoElectrico = new Producto.Builder("Atma-Hor-0003", "HGAB4523PI")
					.marca("Atma")
					.precioBase(230000.0)
					.descuento(30)
					.stock(5)
					.peso(7500.0)
					.descripcion("Horno electrico Atma de 45 litros")
					.build();
	
			televisor = new Producto.Builder("Sams-xxx-0001", "Samsung Crystal")
					.marca("Samsung")
					.precioBase(900000.0)
					.descuento(0)
					.stock(2)
					.peso(8300.0)
					.descripcion("Samsung Crystal 50")
					.build();
	
			// packHogarTech: celular (700.000) + freidora (190.000) = 890.000 con 15% descuento
			packHogarTech = new Paquete.Builder("Pack Hogar Tech")
					.descripcion("Celular y freidora")
					.descuento(15)
					.agregarItem(celular)
					.agregarItem(freidoraAire)
					.build();
	
			// kitHomeOffice: packHogarTech (890.000) + horno (230.000) = 1.120.000 con 10% descuento
			kitHomeOffice = new Paquete.Builder("Kit Home Office")
					.descripcion("Pack + Horno")
					.descuento(10)
					.agregarItem(packHogarTech)
					.agregarItem(hornoElectrico)
					.build();
	        */
	    }
	        
	        @Test
	        void paquetePrecioBaseEsSumaDeItems() {
	            // 700000 + 190000 = 890000
	            assertEquals(890000.0, packHogarTech.getPrecioBase());
	        }

	        @Test
	        void paqueteAnidadoPrecioBaseEsSumaRecursiva() {
	            // 890000 + 230000 = 1120000
	            assertEquals(1120000.0, kitHomeOffice.getPrecioBase());
	        }

	        @Test
	        void paquetePrecioFinalAplicandoDescuento() {
	            // 890000 * (1 - 0.15) = 756500
	            assertEquals(756500.0, packHogarTech.precioFinal());
	        }

	        @Test
	        void paqueteAnidadoPrecioFinal() {
	            // 1120000 * (1 - 0.10) = 1008000
	            assertEquals(1008000.0, kitHomeOffice.precioFinal());
	        }

	        @Test
	        void paqueteSinDescuentoPrecioFinalIgualBase() {
	            Paquete comboSinDescuento = new Paquete("Solo celular", "Sin descuento", 0, new ArrayList<>());
	            comboSinDescuento.agregarItem(celular);
	            assertEquals(comboSinDescuento.getPrecioBase(), comboSinDescuento.precioFinal());
	        }
	        
	        /*
	        @Test
			void paqueteSinDescuentoPrecioFinalIgualBase() {
				Paquete comboSinDescuento = new Paquete.Builder("Solo celular")
						.descripcion("Sin descuento")
						.descuento(0)
						.agregarItem(celular)
						.build();
		
				assertEquals(comboSinDescuento.getPrecioBase(), comboSinDescuento.precioFinal());
			}
	        */

	        @Test
	        void paquetePesoEsSumaDeItems() {
	            // celular 186 y freidora 5100g = 5286
	            assertEquals(5286.0, packHogarTech.getPeso());
	        }
	        
	        @Test
	        void agregarItemAumentaPrecioBase() {
	            packHogarTech.agregarItem(televisor); // 890000 + 900000 = 1790000
	            assertEquals(1790000.0, packHogarTech.getPrecioBase());
	        }

	        @Test
	        void quitarItemReducePrecioBase() {
	            packHogarTech.quitarItem(freidoraAire); // -190000
	            assertEquals(700000.0, packHogarTech.getPrecioBase());
	        }
	        
	        /*
	         @Test
			void paqueteSeCreaVacioSiNoSeAgreganItems() {
				Paquete paqueteVacio = new Paquete.Builder("Paquete Vacio").build();
		
				assertEquals(0.0, paqueteVacio.getPrecioBase());
				assertEquals(0.0, paqueteVacio.getPeso());
			}
	        */

	        // Nota Yami: estos no se si son medios meh para poner 
	        
	        @Test
	        void paqueteGetNombre() {
	            assertEquals("Pack Hogar Tech", packHogarTech.getNombre());
	        }

	        @Test
	        void paqueteGetDescripcion() {
	            assertEquals("Celular y freidora", packHogarTech.getDescripcion());
	        }

	        @Test
	        void paqueteGetDescuento() {
	            assertEquals(15, packHogarTech.getDescuento());
	        }   
	}
	  

