package ar.edu.unq.po2.tpIntegrador.visitor;

public class CSVExportVisitor implements IVisitor {

	@Override
	public String visit(ReporteProductosMasVendidos reporte) {
		StringBuilder sb = new StringBuilder();
        
        
        sb.append("Producto,Cantidad Vendida,Precio Promedio\n");
        
        for (LineaReporteProducto linea : reporte.getLineas()) {
            sb.append(linea.getNombreProducto()).append(",")
              .append(linea.getCantidadVendida()).append(",")
              .append(String.format("%.2f", linea.getPrecioPromedioCobrado()))
              .append("\n");
        }
        
        return sb.toString();
	}

}
