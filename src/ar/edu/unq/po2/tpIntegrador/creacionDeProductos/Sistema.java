package ar.edu.unq.po2.tpIntegrador.creacionDeProductos;

import java.time.LocalDate;
import java.util.ArrayList;

import ar.edu.unq.po2.tpIntegrador.visitor.IVisitor;
import ar.edu.unq.po2.tpIntegrador.visitor.IReporte;
import ar.edu.unq.po2.tpIntegrador.visitor.ReporteProductosMasVendidos;

public class Sistema {
		
	private ArrayList<IItem> catalogo = new ArrayList<IItem>(); 
	
	private ArrayList<Sucursal> sucursales = new ArrayList<Sucursal>();

	public ArrayList<IItem> getCatalogo() {
		return catalogo;
	}
	
	private ArrayList<Venta> ventas = new ArrayList<Venta>();

	public void agregarItem(IItem item) {
		catalogo.add(item);
	}
	
	public void sacarItem(IItem item) {
		catalogo.remove(item);
	}

	public ArrayList<Sucursal> getSucursales() {
		return sucursales;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursales.add(sucursal);
	}
	
	public void registrarVenta(Venta venta) {
		this.ventas.add(venta);
	}
	
	public String exportarReporteProductosMasVendidos(LocalDate inicio, LocalDate fin, IVisitor formato) {
		IReporte reporte = new ReporteProductosMasVendidos(this.ventas, inicio, fin);
		
		return reporte.aceptar(formato);
	}
	
	public ArrayList<Venta> getVentas() {
		return ventas;
	}
}
