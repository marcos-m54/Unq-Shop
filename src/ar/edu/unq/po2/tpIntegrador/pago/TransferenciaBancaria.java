package ar.edu.unq.po2.tpIntegrador.pago;

import java.util.Random;

import ar.edu.unq.po2.tpIntegrador.state.Pedido;

public class TransferenciaBancaria extends MetodoDePago {
	
	private int CBUorCVU;
	private String alias; 
	private IApiTransferenciaBancaria api; 
	
	public TransferenciaBancaria(int cBUorCVU) {
		setCBUorCVU(cBUorCVU);
	}

	@Override
	public void validarDatos(Pedido pedido) {
		api.sonDatosValidos(this);

	}

	@Override
	public void reservarFondos(Pedido pedido) {
		// TODO Auto-generated method stub

	}

	@Override
	public void ejecutarTransacción(Pedido pedido) {
		api.ejecutarTransferencia(this);

	}

	
	public void notificarResultado(Pedido pedido) {
		
	}
	
	//getters y setters

	public int getCBUorCVU() {
		return CBUorCVU;
	}

	public void setCBUorCVU(int cBUorCVU) {
		CBUorCVU = cBUorCVU;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

}
