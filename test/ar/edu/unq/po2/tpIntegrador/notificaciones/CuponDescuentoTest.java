package ar.edu.unq.po2.tpIntegrador.notificaciones;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CuponDescuentoTest {
	
	CuponDescuento cupon;

	@BeforeEach
	void setUp() throws Exception {
	
		cupon = new CuponDescuento(20.00);
		
	}

	@Test
	void pruebaDeCuponCon20PorCientoDeDescuento() {
		assertEquals(cupon.descripcion(),"Cupon de descuento de: 20.0%");
	}

}
