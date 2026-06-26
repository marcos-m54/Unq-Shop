package ar.edu.unq.po2.tpIntegrador.pago;

public class ComprobanteCBU extends Comprobante {
	
	private String cbuOrigen;
	private String numeroDeOperacion;

	public ComprobanteCBU(String cbuOrigen, String numeroDeOperacionBanco, Double montoTotal) {
        super(montoTotal); 
        this.cbuOrigen = cbuOrigen;
        this.numeroDeOperacion = numeroDeOperacionBanco;
    }

    @Override
    public String generarFormatoImprimible() {
        return "------------------------------------\n" +
               "     COMPROBANTE DE TRANSFERENCIA   \n" +
               "------------------------------------\n" +
               "Fecha        : " + this.getFechaFormateada() + "\n" +
               "Nº Op. Banco : " + this.numeroDeOperacion + "\n" +
               "Trx. Interna : " + this.codigoTransaccion + "\n" + 
               "CBU Origen   : " + this.cbuOrigen + "\n" +
               "Monto Total  : $" + this.montoTotal + "\n" +
               "------------------------------------";
    }
	

}
