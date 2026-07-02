package ar.edu.unq.po2.tpIntegrador.envio;

import ar.edu.unq.po2.tpIntegrador.state.Pedido;

public class EnvioExpress implements IFormaDeEnvio {
	
	private Double cargoBase;

	private Double porcentaje;
	
	public EnvioExpress(Double cargoBase, Double porcentaje) {
		super();
		this.cargoBase = cargoBase;
		this.porcentaje = porcentaje;
	}

	public Double getCargoBase() {
		return cargoBase;
	}

	public void setCargoBase(Double cargoBase) {
		this.cargoBase = cargoBase;
	}

	public Double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(Double porcentaje) {
		this.porcentaje = porcentaje;
	}

	@Override
	public Double calcularValorDelEnvio(Pedido pedido) {
		return ((pedido.montoTotal() * this.getPorcentaje()) / 100) + this.getCargoBase();
	}

	@Override
	public int estimacionDiasDeEnvio(Pedido pedido) {
		return 1;
	}
}
