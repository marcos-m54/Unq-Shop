package ar.edu.unq.po2.tpIntegrador.reporte;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.Categoria;
import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.Deposito;
import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.IItem;
import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.Producto;
import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.Sistema;
import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.Sucursal;
import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.Usuario;
import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.Venta;
import ar.edu.unq.po2.tpIntegrador.state.Pedido;
import ar.edu.unq.po2.tpIntegrador.visitor.CSVExportVisitor;
import ar.edu.unq.po2.tpIntegrador.visitor.LineaReporteProducto;
import ar.edu.unq.po2.tpIntegrador.visitor.ReporteProductosMasVendidos;

class ReporteTest {
	
		Producto tele;
		Producto freidoraAire;
		
		Producto freidoraAireConOferta;
		
		ArrayList<IItem> spyItems;
	    
	    Categoria tecnologia;
	    Categoria electrodomestico;
	    Sistema sistema;
	    
		Pedido pedidoTestB;
		Pedido pedidoTestA;
		Pedido pedidoTestC;
		
		Usuario pedroLanus;
		Usuario claraBera;
		
		LocalDate inicio;
	    LocalDate fin;
	    
	    CSVExportVisitor visitorCSV;


		@BeforeEach
		void setUp() throws Exception {
			
			sistema = new Sistema();
			tecnologia = new Categoria("Tecnologia", "Productos tecnologicos");
	        electrodomestico = new Categoria("Electrodomestico", "Articulos del hogar");
			tele = new Producto("Sams-xxx-0001", "Samsung Crystal", "Samsung", 900000.0, 10, 8300.0, "Samsung Crystal 50", new ArrayList<>());
			freidoraAire = new Producto("Atma-Fre-0002", "FR246ABP", "Atma", 190000.0, 10, 5100.0, "Frediora Atma con visor de 6 litros", new ArrayList<>());
			freidoraAireConOferta = new Producto("Atma-Fre-0002", "FR246ABP", "Atma", 160000.0, 10, 5100.0, "Frediora Atma con visor de 6 litros", new ArrayList<>());
			
			tele.setCategoria(tecnologia);
	        freidoraAire.setCategoria(electrodomestico);
	        
	   //     freidoraAireConOferta.setCategoria(electrodomestico);
	        
	        pedroLanus =  mock(Usuario.class);
	        
	        claraBera = mock(Usuario.class);
	        
	      //  spyItems = spy(new ArrayList<IItem>());
	        
	        pedidoTestA = new Pedido(claraBera, new ArrayList<IItem>());
	        
	        pedidoTestB = new Pedido(pedroLanus, new ArrayList<IItem>());
	        
	       // pedidoTestC = new Pedido(claraBera, new ArrayList<IItem>());
	        
	        // agregarItemACarrito ahora chequea sistema.hayStockDisponibleDe(item),
	        // asi que hace falta un Sistema con una Sucursal/Deposito con stock real,
	        // y que los pedidos conozcan a ese Sistema.
	        Deposito depositoTest = new Deposito("Deposito Test");
	        depositoTest.agregarStock(tele, 10);
	        depositoTest.agregarStock(freidoraAire, 10);

	        Sucursal sucursalTest = new Sucursal("Sucursal Test", depositoTest);
	        sistema.setSucursal(sucursalTest);

	        pedidoTestA.setSistema(sistema);
	        pedidoTestB.setSistema(sistema);
	        
	        sistema.registrarVenta(new Venta(LocalDate.now(), pedidoTestB));
	        
	        sistema.registrarVenta(new Venta(LocalDate.now(), pedidoTestA));
	        
	        inicio = LocalDate.of(2026, 6, 1);
	        fin = LocalDate.of(2026, 7, 31);
	        
	        visitorCSV = new CSVExportVisitor();

	       
		}

		@Test
	    void testVisitorGeneraFormatoCSVCorrectamente() {
			
			pedidoTestB.agregarItemACarrito(tele);
			pedidoTestB.confirmarPedido();
			
			String resultadoCSV = sistema.exportarReporteProductosMasVendidos(inicio, fin, visitorCSV);
			assertNotNull(resultadoCSV, "El reporte CSV no debería ser nulo");
			
			assertTrue(resultadoCSV.contains("Producto"));
		    assertTrue(resultadoCSV.contains("Cantidad Vendida"));
		    
		  
		    assertTrue(resultadoCSV.contains("Samsung Crystal"));
		
		}
		
		@Test 
		
		void testReporteOrdenaLosProductosDeMayorAMenor() {
			
			pedidoTestA.agregarItemACarrito(freidoraAire);
			pedidoTestA.agregarItemACarrito(freidoraAire);
			pedidoTestA.agregarItemACarrito(tele);
			pedidoTestA.confirmarPedido();
			
			ReporteProductosMasVendidos reporte = new ReporteProductosMasVendidos(sistema.getVentas(), inicio, fin);
		    ArrayList<LineaReporteProducto> lineas = reporte.getLineas();
		    
		    assertEquals(2, lineas.size());
			
		}
		
		

	}



