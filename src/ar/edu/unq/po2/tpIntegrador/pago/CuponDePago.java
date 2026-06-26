package ar.edu.unq.po2.tpIntegrador.pago;

public class CuponDePago extends Comprobante {

	private String numeroTarjetaEnmascarado;

	public CuponDePago(Double montoTotal, String numeroTarjeta) {
        super(montoTotal);
        this.numeroTarjetaEnmascarado = enmascararTarjeta(numeroTarjeta);
    }

    private String enmascararTarjeta(String numero) {
        if (numero == null || numero.length() < 4) return "****";
        return "**** **** **** " + numero.substring(numero.length() - 4);
    }

    @Override
    public String generarFormatoImprimible() {
        return "====================================\n" +
               "        CUPÓN DE PAGO APROBADO      \n" +
               "====================================\n" +
               "Fecha        : " + this.getFechaFormateada() + "\n" +
               "Transacción  : " + this.codigoTransaccion + "\n" +
               "Tarjeta      : " + this.numeroTarjetaEnmascarado + "\n" +
               "Monto Total  : $" + this.montoTotal + "\n" +
               "====================================";
    }
}
