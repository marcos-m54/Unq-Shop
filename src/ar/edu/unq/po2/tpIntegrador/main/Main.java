/*package ar.edu.unq.po2.tpIntegrador.main;

import java.time.LocalDate;
import java.util.ArrayList;

import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.Categoria;
import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.Deposito;
import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.Paquete;
import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.Producto;
import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.Sistema;
import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.Sucursal;
import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.Usuario;
import ar.edu.unq.po2.tpIntegrador.envio.EnvioExpress;
import ar.edu.unq.po2.tpIntegrador.notificaciones.Fidelizacion;
import ar.edu.unq.po2.tpIntegrador.notificaciones.GeneradorDeFactura;
import ar.edu.unq.po2.tpIntegrador.notificaciones.IMailSender;
import ar.edu.unq.po2.tpIntegrador.notificaciones.Notificador;
import ar.edu.unq.po2.tpIntegrador.notificaciones.NotificadorDeEmail;
import ar.edu.unq.po2.tpIntegrador.pago.BilleteraVirtual;
import ar.edu.unq.po2.tpIntegrador.pago.IApiBilleteraVirtual;
import ar.edu.unq.po2.tpIntegrador.state.Pedido;
import ar.edu.unq.po2.tpIntegrador.visitor.TextoPlanoExportVisitor;

public class Main {

	public static void main(String[] args) {

		System.out.println("========================================");
		System.out.println("        UNQ-SHOP - DEMO DEL SISTEMA     ");
		System.out.println("========================================\n");

		// 1) Armar Catalogo
		
		System.out.println("--- 1. Armando el catalogo ---");

		Sistema sistema = new Sistema();

		Categoria tecnologia = new Categoria("Tecnologia", "Productos tecnologicos");
		Categoria electrodomestico = new Categoria("Electrodomestico", "Articulos del hogar");

		Producto celular = new Producto("MOTO-G86-256", "Moto G86", "Motorola", 700000.0, 10, 5, 186.0, "Celular gama media", new ArrayList<>());
		celular.setCategoria(tecnologia);
		celular.agregarAtributo("color", "negro");
		celular.agregarAtributo("almacenamiento", "256GB");

		Producto auriculares = new Producto("JBL-T500-001", "JBL Tune 500", "JBL", 85000.0, 0, 10, 150.0, "Auriculares inalambricos", new ArrayList<>());
		auriculares.setCategoria(tecnologia);

		Producto freidora = new Producto("ATMA-FRE-0002", "FR246ABP", "Atma", 190000.0, 10, 8, 5100.0, "Freidora de aire 6 litros", new ArrayList<>());
		freidora.setCategoria(electrodomestico);

		// Paquete: celular + auriculares con 15% de descuento
		Paquete packTech = new Paquete("Pack Tech", "Celular y auriculares", 15, new ArrayList<>());
		packTech.agregarItem(celular);
		packTech.agregarItem(auriculares);

		sistema.agregarItem(celular);
		sistema.agregarItem(auriculares);
		sistema.agregarItem(freidora);
		sistema.agregarItem(packTech);

		System.out.println("Productos en catalogo: " + sistema.getCatalogo().size());
		System.out.println("Precio base Pack Tech: $" + packTech.getPrecioBase());
		System.out.println("Precio final Pack Tech (con 15% desc): $" + packTech.precioFinal());

		// 2) Armar Deposito y Sucursal
		
		System.out.println("\n--- 2. Armando deposito y sucursal ---");

		Deposito depositoCentral = new Deposito("Deposito Central", new ArrayList<>());
		depositoCentral.setItem(celular);
		depositoCentral.setItem(auriculares);
		depositoCentral.setItem(freidora);

		Sucursal sucursalOnce = new Sucursal("Sucursal Once", depositoCentral);
		sistema.setSucursal(sucursalOnce);

		System.out.println("Sucursal creada: " + sucursalOnce.getNombre());
		System.out.println("Stock celular en deposito: " + depositoCentral.getStockDe(celular));

		// 3) Configurar notificaciones

		System.out.println("\n--- 3. Configurando notificaciones ---");

		// MailSender simulado que imprime por consola
		IMailSender mailSender = (destino, titulo, mensaje) -> {
			System.out.println("  [EMAIL] Para: " + destino);
			System.out.println("  [EMAIL] Titulo: " + titulo);
			System.out.println("  [EMAIL] Mensaje: " + mensaje);
		};

		Notificador notificador = new Notificador();
		notificador.suscribir(new NotificadorDeEmail(mailSender));
		notificador.suscribir(new GeneradorDeFactura());
		notificador.suscribir(new Fidelizacion(mailSender));

		System.out.println("Suscriptores registrados: 3 (email, factura, fidelizacion)");

		// 4) Crear Usuario y Pedido (BORRADOR)

		System.out.println("\n--- 4. Cliente armando su pedido ---");

		Usuario juana = new Usuario("Juana Perez", "juana@mail.com", "Av. Corrientes 1234");

		Pedido pedido = new Pedido(juana, new ArrayList<>());
		pedido.setNotificador(notificador);
		pedido.setSistema(sistema);

		// Agrega items al carrito (solo posible en BORRADOR)
		pedido.getEstado().agregarItem(packTech);
		pedido.getEstado().agregarItem(freidora);

		System.out.println("Items en carrito: " + pedido.getItems().size());
		System.out.println("Monto total del pedido: $" + pedido.montoTotal());

		// 5) Elergir tipo de envio y metodo de pago

		System.out.println("\n--- 5. Eligiendo envio y metodo de pago ---");

		EnvioExpress envioExpress = new EnvioExpress(500.0, 5.0);
		pedido.setFormaDeEnvio(envioExpress);

		System.out.println("Forma de envio: Express (1 dia habil)");
		System.out.println("Costo de envio: $" + envioExpress.calcularValorDelEnvio(pedido));

		// Billetera virtual simulada
		IApiBilleteraVirtual apiBilletera = new IApiBilleteraVirtual() {
			public boolean tieneSaldoSuficiente(BilleteraVirtual b) {
				System.out.println("  [BILLETERA] Validando saldo...");
				return true;
			}
			public void bloquearSaldo(BilleteraVirtual b) {
				System.out.println("  [BILLETERA] Bloqueando saldo...");
			}
			public void acreditarSaldo(BilleteraVirtual b) {
				System.out.println("  [BILLETERA] Acreditando al vendedor...");
			}
			public void crearNotificacionPush(BilleteraVirtual b) {
				System.out.println("  [BILLETERA] Notificacion push enviada!");
			}
		};

		BilleteraVirtual billetera = new BilleteraVirtual(1000000.0, apiBilletera);
		pedido.setMetodoDePago(billetera);
		System.out.println("Metodo de pago: Billetera Virtual");

		// 6) Confirmar pedido (BORRADOR --> CONFIRMADO)
		
		System.out.println("\n--- 6. Confirmando pedido ---");
		System.out.println("Estado actual: " + pedido.getEstado().getClass().getSimpleName());

		pedido.confirmarPedido(); // Aca el sistema registra la venta

		System.out.println("Estado despues de confirmar: " + pedido.getEstado().getClass().getSimpleName());
		System.out.println("Stock celular despues de confirmar: " + celular.getStock());
		System.out.println("Venta registrada: " + LocalDate.now());
		System.out.println("Total ventas en el sistema: " + sistema.getVentas().size());

		// 7) Preparar pedido (CONFIRMADO --> EN PREPARACION)

		System.out.println("\n--- 7. Preparando el pedido ---");

		pedido.prepararPedido();

		System.out.println("Estado: " + pedido.getEstado().getClass().getSimpleName());

		// 8) Enviar pedido (EN PREPARACION --> ENVIADO)

		System.out.println("\n--- 8. Enviando el pedido ---");

		pedido.enviarPedido();

		System.out.println("Estado: " + pedido.getEstado().getClass().getSimpleName());

		// 9) Entregar pedido (ENVIADO --> ENTREGADO)

		System.out.println("\n--- 9. Entregando el pedido ---");

		pedido.entregarPedido();

		System.out.println("Estado: " + pedido.getEstado().getClass().getSimpleName());

		// 10. Generar reporte

		System.out.println("\n--- 10. Generando reporte ---");

		String reporte = sistema.exportarReporteProductosMasVendidos(
				LocalDate.now().minusDays(7),
				LocalDate.now(),
				new TextoPlanoExportVisitor()
		);

		System.out.println("\n--- REPORTE DE PRODUCTOS MAS VENDIDOS ---");
		System.out.println(reporte);

		System.out.println("\n========================================");
		System.out.println("        FIN DE LA DEMO                  ");
		System.out.println("========================================");
	}
}
*/