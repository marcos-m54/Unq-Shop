package ar.edu.unq.po2.tpIntegrador.notificaciones;

public class CuponDescuento implements IAdjunto {

	private Double descuento;
	
	@Override
	public String descripcion() {
		return "Cupon de descuento de: " + this.descuento + "%" ;
	}

	public CuponDescuento(Double descuento) {
		super();
		this.descuento = descuento;
	}

}
