package ar.edu.unq.po2.tpIntegrador.creacionDeProductos;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CategoriaYAtributoTest {

	Categoria categoria;
	Atributo atributo;

	@BeforeEach
	void setUp() throws Exception {
		// nombre, descripcion (ambos)
		categoria = new Categoria("Tecnologia", "Productos tecnologicos");
		atributo = new Atributo("color", "negro");
	}

	@Test
	void categoriaSeCreaConElNombreCorrecto() {
		assertEquals("Tecnologia", categoria.getNombre());
	}

	@Test
	void categoriaSeCreaConLaDescripcionCorrecta() {
		assertEquals("Productos tecnologicos", categoria.getDescripcion());
	}

	@Test
	void setNombreCambiaElNombreDeLaCategoria() {
		categoria.setNombre("Electrodomesticos");
		assertEquals("Electrodomesticos", categoria.getNombre());
	}

	@Test
	void setDescripcionCambiaLaDescripcionDeLaCategoria() {
		categoria.setDescripcion("Articulos del hogar");
		assertEquals("Articulos del hogar", categoria.getDescripcion());
	}

	@Test
	void atributoSeCreaConElNombreCorrecto() {
		assertEquals("color", atributo.getNombre());
	}

	@Test
	void atributoSeCreaConLaDescripcionCorrecta() {
		assertEquals("negro", atributo.getDescripcion());
	}

	@Test
	void setNombreCambiaElNombreDelAtributo() {
		atributo.setNombre("talle");
		assertEquals("talle", atributo.getNombre());
	}

	@Test
	void setDescripcionCambiaLaDescripcionDelAtributo() {
		atributo.setDescripcion("XL");
		assertEquals("XL", atributo.getDescripcion());
	}
}