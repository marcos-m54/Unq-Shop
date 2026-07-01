package ar.edu.unq.po2.tpIntegrador.visitor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.IItem;
import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.Venta;
import ar.edu.unq.po2.tpIntegrador.state.Pedido;

public class ReporteProductosMasVendidos implements IReporte {
	
	private ArrayList<LineaReporteProducto> lineas;

	public ReporteProductosMasVendidos(ArrayList<Venta> ventas, LocalDate inicio, LocalDate fin) {
		this.lineas = new ArrayList<>();
		
		Map<String, Integer> cantidadesPorProducto = new HashMap<>();
        Map<String, Double> recaudacionPorProducto = new HashMap<>();
		
		for (Venta venta : ventas) {
            LocalDate fechaVenta = venta.getFecha();
            
       
            if ((fechaVenta.isAfter(inicio) || fechaVenta.isEqual(inicio)) && 
                (fechaVenta.isBefore(fin) || fechaVenta.isEqual(fin))) {
                
                Pedido pedido = venta.getPedido();
                
                for (IItem item : pedido.getItems()) { 
                    String nombre = item.getNombre(); 
                    int cantidad = item.getStock(); 
                    double precio = item.precioFinal(); 

                    // Acumulador de las cantidades vendidas
                    cantidadesPorProducto.put(nombre, cantidadesPorProducto.getOrDefault(nombre, 0) + cantidad);
                    
                    // Acumulador de la recaudación para sacar el promedio
                    recaudacionPorProducto.put(nombre, recaudacionPorProducto.getOrDefault(nombre, 0.0) + (precio * cantidad));
                }
            }
        }

        // maps a LineaReporteProducto
        for (String nombreProducto : cantidadesPorProducto.keySet()) {
            int totalUnidades = cantidadesPorProducto.get(nombreProducto);
            double totalRecaudado = recaudacionPorProducto.get(nombreProducto);
            double precioPromedio = totalRecaudado / totalUnidades;
            
            LineaReporteProducto linea = new LineaReporteProducto(nombreProducto, totalUnidades, precioPromedio);
            this.lineas.add(linea);
        }

        // ordenar de mayor a menor, según la cantidad vendida
        
        this.lineas.sort((linea1, linea2) -> Integer.compare(linea2.getCantidadVendida(), linea1.getCantidadVendida()));
    }
	

	@Override
	public String aceptar(IVisitor visitor) {
		return visitor.visit(this);
	}
	
	public ArrayList<LineaReporteProducto> getLineas() {
        return new ArrayList<>(this.lineas); 
    }

}
