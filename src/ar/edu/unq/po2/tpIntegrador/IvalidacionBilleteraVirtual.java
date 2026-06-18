package ar.edu.unq.po2.tpIntegrador;

public interface IvalidacionBilleteraVirtual {
	
	public boolean tieneSaldoSuficiente(BilleteraVirtual billeteraVirtual);
	
	public void bloquearSaldo();
	
	public void acreditarSaldo();
	
	public void crearNotificacionPush();
	
	

}
