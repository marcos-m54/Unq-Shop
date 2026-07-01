package ar.edu.unq.po2.tpIntegrador.visitor;

import java.time.LocalDate;
import java.util.ArrayList;

import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.Venta;

public class ReporteProductosMasVendidos implements IReporte {

	public ReporteProductosMasVendidos(ArrayList<Venta> ventas, LocalDate inicio, LocalDate fin) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String aceptar(IVisitor visitor) {
		return null;
	}

}
