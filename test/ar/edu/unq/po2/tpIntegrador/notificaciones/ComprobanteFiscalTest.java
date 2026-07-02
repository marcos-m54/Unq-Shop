package ar.edu.unq.po2.tpIntegrador.notificaciones;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ComprobanteFiscalTest {

	ComprobanteFiscal comprobante;
	LocalDate fecha;

	@BeforeEach
	void setUp() throws Exception {
		fecha = LocalDate.of(2026, 7, 1);
		comprobante = new ComprobanteFiscal("A", 22, fecha, "20-00000001-9", 1500.0);
		// (tipoDeComprobante, numeroDeComprobante, fecha, cuit, montoTotal) 
	}

	@Test
	void comprobanteFiscalSeCreaConElTipoCorrecto() {
		assertEquals("A", comprobante.getTipoDeComprobante());
	}

	@Test
	void comprobanteFiscalSeCreaConElNumeroCorrecto() {
		assertEquals(22, comprobante.getNumeroDeComprobante());
	}

	@Test
	void comprobanteFiscalSeCreaConLaFechaCorrecta() {
		assertEquals(fecha, comprobante.getFecha());
	}

	@Test
	void comprobanteFiscalSeCreaConElCUITCorrecto() {
		assertEquals("20-00000001-9", comprobante.getCUIT());
	}

	@Test
	void comprobanteFiscalSeCreaConElMontoCorrecto() {
		assertEquals(1500.0, comprobante.getMontoTotal());
	}

	@Test
	void setTipoCambiaElTipo() {
		comprobante.setTipoDeComprobante("B");
		assertEquals("B", comprobante.getTipoDeComprobante());
	}

	@Test
	void setNumeroCambiaElNumero() {
		comprobante.setNumeroDeComprobante(99);
		assertEquals(99, comprobante.getNumeroDeComprobante());
	}

	@Test
	void setFechaCambiaLaFecha() {
		LocalDate nuevaFecha = LocalDate.of(2026, 8, 15);
		comprobante.setFecha(nuevaFecha);
		assertEquals(nuevaFecha, comprobante.getFecha());
	}

	@Test
	void setCUITCambiaElCUIT() {
		comprobante.setCUIT("27-99999999-4");
		assertEquals("27-99999999-4", comprobante.getCUIT());
	}

	@Test
	void setMontoCambiaElMonto() {
		comprobante.setMontoTotal(2000.0);
		assertEquals(2000.0, comprobante.getMontoTotal());
	}
}