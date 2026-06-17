package ar.edu.unq.po2.tpIntegrador;

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
  

