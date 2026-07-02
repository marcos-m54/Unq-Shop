package ar.edu.unq.po2.tpIntegrador.pago;

public interface IApiTransferenciaBancaria {
	
	public boolean sonDatosValidos (TransferenciaBancaria transferencia);
	
	public void ejecutarTransferencia(TransferenciaBancaria transferencia);

}
