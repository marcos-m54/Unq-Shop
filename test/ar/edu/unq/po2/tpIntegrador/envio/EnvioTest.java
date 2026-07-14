package ar.edu.unq.po2.tpIntegrador.envio;
 
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
 
import java.util.ArrayList;
 
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
 
import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.IItem;
import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.Sucursal;
import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.Usuario;
import ar.edu.unq.po2.tpIntegrador.notificaciones.Notificador;
import ar.edu.unq.po2.tpIntegrador.state.Pedido;
 
class EnvioTest {
 
	Pedido pedido;
	Usuario usuario;
	IItem itemMock;
 
	@BeforeEach
	void setUp() throws Exception {
		usuario = new Usuario("Juana Perez", "juana@mail.com", "Calle Falsa 123");
 
		itemMock = mock(IItem.class);
		when(itemMock.getStock()).thenReturn(5);
		when(itemMock.getPeso()).thenReturn(2.0);        
		when(itemMock.precioFinal()).thenReturn(1000.0); 
 
		ArrayList<IItem> items = new ArrayList<>();
		items.add(itemMock);
 
		pedido = new Pedido(usuario, items);
	}
 
	// Envio Estandar
 
	@Test
	void envioEstandarLlamaACorreoArgentinaConElPesoCorrecto() {
		ICorreoArgentina correoMock = mock(ICorreoArgentina.class);
		when(correoMock.estimarEnvio(any(), any())).thenReturn(500.0);
 
		EnvioEstandar envio = new EnvioEstandar(correoMock);
 
		envio.calcularValorDelEnvio(pedido);
 
		// Verifica que le paso el peso total del pedido y la direccion del usuario
		verify(correoMock).estimarEnvio(2.0, "Calle Falsa 123");
	}
 
	@Test
	void envioEstandarDevuelveElValorQueRetornaCorreoArgentina() {
		ICorreoArgentina correoMock = mock(ICorreoArgentina.class);
		when(correoMock.estimarEnvio(any(), any())).thenReturn(500.0);
		
		EnvioEstandar envio = new EnvioEstandar(correoMock);
 
		Double resultado = envio.calcularValorDelEnvio(pedido);
 
		assertEquals(500.0, resultado);
	}
 
	@Test
	void envioEstandarEstimacionDiasEsEntre5Y7() {
		ICorreoArgentina correoMock = mock(ICorreoArgentina.class);
		
		EnvioEstandar envio = new EnvioEstandar(correoMock);
 
		int dias = envio.estimacionDiasDeEnvio(pedido);
 
		assertTrue(dias >= 5 && dias <= 7);
	}
 
	// Envio Express
 
	@Test
	void envioExpressCalculaElCostoCorrectamente() {
		// Enunciado: porcentaje fijo sobre el valor total + cargo base
		// precioFinal del item = 1000.0 (setUp)
		// porcentaje= 10  cargoBase= 200: (1000 * 10 / 100) + 200 = 300.0
		EnvioExpress envio = new EnvioExpress(200.0, 10.0);
 
		Double resultado = envio.calcularValorDelEnvio(pedido);
 
		assertEquals(300.0, resultado);
	}
 
	@Test
	void envioExpressGarantizaEntregaEn1DiaSiempre() {
		EnvioExpress envio = new EnvioExpress(200.0, 10.0);
 
		int dias = envio.estimacionDiasDeEnvio(pedido);
 
		assertEquals(1, dias);
	}

	// Retiro en Sucursal
 
	@Test
	void retiroEnSucursalCostoDeEnvioEsSiempreCero() {
		// Enunciado: "el costo de envio es siempre cero"
		Sucursal sucursalMock = mock(Sucursal.class);
		RetiroEnSucursal retiro = new RetiroEnSucursal(sucursalMock);
 
		Double costo = retiro.calcularValorDelEnvio(pedido);
 
		assertEquals(0.0, costo);
	}
 
	@Test
	void retiroEnSucursalConStockLocalEsInmediato() {
		// Enunciado: "inmediato si hay stock en esa sucursal"
		Sucursal sucursalMock = mock(Sucursal.class);
		when(sucursalMock.hayStockDeItemsDePedido(pedido)).thenReturn(true);
 
		RetiroEnSucursal retiro = new RetiroEnSucursal(sucursalMock);
 
		assertEquals(0, retiro.estimacionDiasDeEnvio(pedido));
	}
 
	@Test
	void retiroEnSucursalSinStockLocalRequiereHasta3Dias() {
		// Enunciado: "hasta 3 dias si requiere traslado interno desde otro deposito"
		Sucursal sucursalMock = mock(Sucursal.class);
		when(sucursalMock.hayStockDeItemsDePedido(pedido)).thenReturn(false);
 
		RetiroEnSucursal retiro = new RetiroEnSucursal(sucursalMock);
 
		assertEquals(3, retiro.estimacionDiasDeEnvio(pedido));
	}
}
