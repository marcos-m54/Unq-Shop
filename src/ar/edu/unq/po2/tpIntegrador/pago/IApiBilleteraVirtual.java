package ar.edu.unq.po2.tpIntegrador.pago;

public interface IApiBilleteraVirtual {
	
	public boolean tieneSaldoSuficiente(BilleteraVirtual billeteraVirtual);
	
	public void bloquearSaldo(BilleteraVirtual billeteraVirtual);
	
	public void acreditarSaldo(BilleteraVirtual billeteraVirtual);
	
	public void crearNotificacionPush(BilleteraVirtual billeteraVirtual);
	
	

}
