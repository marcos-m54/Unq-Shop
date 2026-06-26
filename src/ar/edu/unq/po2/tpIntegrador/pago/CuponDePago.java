package ar.edu.unq.po2.tpIntegrador.pago;

public class CuponDePago extends Comprobante {

	private String ultimosNumerosDeTarjeta;
	private Double montoTotal;

	
	public CuponDePago(String ultimosNumerosDeTarjeta, Double montoTotal) {
		this.ultimosNumerosDeTarjeta = ultimosNumerosDeTarjeta;
		this.montoTotal = montoTotal;

	}
	
	
	

}
