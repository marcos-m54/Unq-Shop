package ar.edu.unq.po2.tpIntegrador.pago;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ComprobanteTest {

	// Comprobante CBU

	ComprobanteCBU comprobanteCBU;
	CuponDePago cupon;

	@BeforeEach
	void setUp() throws Exception {
		comprobanteCBU = new ComprobanteCBU("0000003100012345678901", "123456789", 1500.0);
		cupon = new CuponDePago(700000.0, "123456789");
	}

	@Test
	void comprobanteCBUSeCreaConElMontoCorreto() {
		assertEquals(1500.0, comprobanteCBU.getMontoTotal());
	}

	@Test
	void comprobanteCBUTieneCodigoDeTransaccion() {
		// El codigo se genera automaticamente con UUID, solo verifico que no sea null ni vacio
		assertNotNull(comprobanteCBU.getCodigoTransaccion());
		assertFalse(comprobanteCBU.getCodigoTransaccion().isEmpty());
	}

	@Test
	void comprobanteCBUTieneFechaDeEmision() {
		assertNotNull(comprobanteCBU.getFechaEmision());
	}

	@Test
	void comprobanteCBUGeneraFormatoImprimibleConLosDatosCorrectos() {
		String formato = comprobanteCBU.generarFormatoImprimible();

		assertTrue(formato.contains("COMPROBANTE DE TRANSFERENCIA"));
		assertTrue(formato.contains("0000003100012345678901")); // CBU origen
		assertTrue(formato.contains("123456789")); // numero de operacion
		assertTrue(formato.contains("1500.0")); // monto
	}

	// Cupon de Pago

	@Test
	void cuponDePagoSeCreaConElMontoCorrecto() {
		assertEquals(700000.0, cupon.getMontoTotal());
	}

	@Test
	void cuponDePagoTieneCodigoDeTransaccion() {
		assertNotNull(cupon.getCodigoTransaccion());
		assertFalse(cupon.getCodigoTransaccion().isEmpty());
	}

	@Test
	void cuponDePagoEnmascaraLaTarjetaCorrectamente() {
		String formato = cupon.generarFormatoImprimible();

		// Solo deben aparecer los ultimos 4 digitos
		assertTrue(formato.contains("**** **** **** 6789"));
	}

	@Test
	void cuponDePagoGeneraFormatoImprimibleConLosDatosCorrectos() {
		String formato = cupon.generarFormatoImprimible();

		assertTrue(formato.contains("CUPÓN DE PAGO APROBADO"));
		assertTrue(formato.contains("700000.0")); // monto
	}

	@Test
	void cuponDePagoConTarjetaNullEnmascaraCorrectamente() {
		CuponDePago cuponNull = new CuponDePago(700000.0, null);
		String formato = cuponNull.generarFormatoImprimible();

		assertTrue(formato.contains("****"));
	}

	@Test
	void cuponDePagoConTarjetaCorta() {
		// Numero con menos de 4 digitos
		CuponDePago cuponCorto = new CuponDePago(700000.0, "123");
		String formato = cuponCorto.generarFormatoImprimible();

		assertTrue(formato.contains("****"));
	}
}