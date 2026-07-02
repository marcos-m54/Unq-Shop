package ar.edu.unq.po2.tpIntegrador.state;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NotaDeCreditoTest {

	NotaDeCredito nota;
	LocalDate fecha;

	@BeforeEach
	void setUp() throws Exception {
		fecha = LocalDate.of(2026, 7, 1);
		nota = new NotaDeCredito("Juana Perez", fecha, 1200.0);
	}

	@Test
	void notaDeCreditoSeCreaConElTitularCorrecto() {
		assertEquals("Juana Perez", nota.getTitular());
	}

	@Test
	void notaDeCreditoSeCreaConLaFechaCorrecta() {
		assertEquals(fecha, nota.getFecha());
	}

	@Test
	void notaDeCreditoSeCreaConElMontoCorrecto() {
		assertEquals(1200.0, nota.getMonto());
	}

	@Test
	void setTitularCambiaElTitular() {
		nota.setTitular("Carlos Garcia");
		assertEquals("Carlos Garcia", nota.getTitular());
	}

	@Test
	void setFechaCambiaLaFecha() {
		LocalDate nuevaFecha = LocalDate.of(2026, 8, 15);
		nota.setFecha(nuevaFecha);
		assertEquals(nuevaFecha, nota.getFecha());
	}

	@Test
	void setMontoCambiaElMonto() {
		nota.setMonto(500.0);
		assertEquals(500.0, nota.getMonto());
	}
}