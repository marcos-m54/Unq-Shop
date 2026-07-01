package ar.edu.unq.po2.tpIntegrador.visitor;

public class LineaReporteProducto {
	
	private String nombreProducto;
    private int cantidadVendida;
    private double precioPromedioCobrado;

    public LineaReporteProducto(String nombreProducto, int cantidadVendida, double precioPromedioCobrado) {
        this.nombreProducto = nombreProducto;
        this.cantidadVendida = cantidadVendida;
        this.precioPromedioCobrado = precioPromedioCobrado;
    }

    public String getNombreProducto() {
        return this.nombreProducto;
    }

    public int getCantidadVendida() {
        return this.cantidadVendida;
    }

    public double getPrecioPromedioCobrado() {
        return this.precioPromedioCobrado;
    }


}
