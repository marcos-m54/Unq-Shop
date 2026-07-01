package ar.edu.unq.po2.tpIntegrador.visitor;

public class TextoPlanoExportVisitor implements IVisitor {

	@Override
	public String visit(ReporteProductosMasVendidos reporte) {
		StringBuilder sb = new StringBuilder();
        
        sb.append("==================================================\n");
        sb.append("        REPORTE DE PRODUCTOS MÁS VENDIDOS        \n");
        sb.append("==================================================\n");
        sb.append(String.format("%-25s | %-8s | %-12s\n", "PRODUCTO", "CANTIDAD", "PRECIO PROM"));
        sb.append("--------------------------------------------------\n");
        
        for (LineaReporteProducto linea : reporte.getLineas()) {
            sb.append(String.format("%-25s | %-8d | $%11.2f\n", 
                linea.getNombreProducto(), 
                linea.getCantidadVendida(), 
                linea.getPrecioPromedioCobrado()
            ));
        }
        
        sb.append("==================================================\n");
        return sb.toString();

	}

}
