package ar.edu.unq.po2.tpIntegrador.creacionDeProductos;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpIntegrador.state.Pedido;

class VentaTest {

	Venta venta;
	Pedido pedidoMock;
	LocalDate fecha;

	@BeforeEach
	void setUp() throws Exception {
		fecha = LocalDate.of(2026, 7, 1);
		pedidoMock = mock(Pedido.class);
		venta = new Venta(fecha, pedidoMock);
	}

	@Test
	void ventaSeCreaConLaFechaCorrecta() {
		assertEquals(fecha, venta.getFecha());
	}

	@Test
	void ventaSeCreaConElPedidoCorrecto() {
		assertEquals(pedidoMock, venta.getPedido());
	}

	@Test
	void setFechaCambiaLaFecha() {
		LocalDate nuevaFecha = LocalDate.of(2026, 8, 15);
		venta.setFecha(nuevaFecha);
		assertEquals(nuevaFecha, venta.getFecha());
	}

	@Test
	void setPedidoCambiaElPedido() {
		Pedido otroPedidoMock = mock(Pedido.class);
		venta.setPedido(otroPedidoMock);
		assertEquals(otroPedidoMock, venta.getPedido());
	}
}