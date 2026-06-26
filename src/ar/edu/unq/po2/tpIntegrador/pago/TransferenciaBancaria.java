package ar.edu.unq.po2.tpIntegrador.pago;

import ar.edu.unq.po2.tpIntegrador.state.Pedido;

public class TransferenciaBancaria extends MetodoDePago {
	
	private String cbuOrCvu;
	private String alias; 
	private IApiTransferenciaBancaria api; 
	
	public TransferenciaBancaria(String cbuorcvu, String alias, IApiTransferenciaBancaria api) {
		this.cbuOrCvu = cbuorcvu;
		this.alias = alias;
		this.api = api;
	}


	// Set y Get
	public IvalidacionTransferenciaBancaria getValidacion() {
		return validacion;
	}

	public void setValidacion(IvalidacionTransferenciaBancaria validacion) {
		this.validacion = validacion;
	}
	
	@Override
	public void validarDatos(Pedido pedido) {
		api.sonDatosValidos(this);

	}

	@Override
	public void reservarFondos(Pedido pedido) {
		
	}

	@Override
	public void ejecutarTransacción(Pedido pedido) {
		api.ejecutarTransferencia(this);

	}

	
	public void notificarResultado(Pedido pedido) {
		String nroOperacionBanco = String.valueOf(new java.util.Random().nextInt(900000000) + 100000000);
		pedido.registrarComprobante(new ComprobanteCBU(this.getCbuOrCvu(), nroOperacionBanco, pedido.montoTotal()));
	}
	
	//getters y setters

	public String getCbuOrCvu() {
		return cbuOrCvu;
	}

	public void setCbuOrCvu(String cBUorCVU) {
		cbuOrCvu = cBUorCVU;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}
}
