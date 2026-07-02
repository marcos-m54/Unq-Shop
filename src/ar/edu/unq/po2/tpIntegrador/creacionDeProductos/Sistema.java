package ar.edu.unq.po2.tpIntegrador.creacionDeProductos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.tpIntegrador.busquedaItems.ICriterio;

import ar.edu.unq.po2.tpIntegrador.visitor.IVisitor;
import ar.edu.unq.po2.tpIntegrador.visitor.CSVExportVisitor;
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
	
	
	
	public ArrayList<Venta> getVentas() {
		return ventas;
	}

	public List<IItem> busqueda(ICriterio criterioDeBusqueda) {
		return criterioDeBusqueda.filtrar(this.getCatalogo());
	}

	public void registrarVenta(Venta venta) {
		this.ventas.add(venta);
		
	}

	public String exportarReporteProductosMasVendidos(LocalDate inicio, LocalDate fin, IVisitor formato) {
		IReporte reporte = new ReporteProductosMasVendidos(this.ventas, inicio, fin);
		
		return reporte.aceptar(formato);
		
	}
	
}