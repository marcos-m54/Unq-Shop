package ar.edu.unq.po2.tpIntegrador.visitor;

public class HTMLExportVisitor implements IVisitor {

	@Override
	public String visit(ReporteProductosMasVendidos reporte) {
		StringBuilder sb = new StringBuilder();
        
        sb.append("<html>\n<head>\n<title>Reporte de Ventas</title>\n</head>\n<body>\n");
        sb.append("<h2>Ranking de Productos Más Vendidos</h2>\n");
        sb.append("<table border='1' cellpadding='5' cellspacing='0'>\n");
        
        sb.append("  <tr bgcolor='#CCCCCC'>\n")
          .append("    <th>Producto</th>\n")
          .append("    <th>Cantidad Vendida</th>\n")
          .append("    <th>Precio Promedio Cobrado</th>\n")
          .append("  </tr>\n");
          
        for (LineaReporteProducto linea : reporte.getLineas()) {
            sb.append("  <tr>\n")
              .append("    <td>").append(linea.getNombreProducto()).append("</td>\n")
              .append("    <td align='center'>").append(linea.getCantidadVendida()).append("</td>\n")
              .append("    <td align='right'>$").append(String.format("%.2f", linea.getPrecioPromedioCobrado())).append("</td>\n")
              .append("  </tr>\n");
        }
        
        sb.append("</table>\n</body>\n</html>");
        return sb.toString();
		
	}

}
