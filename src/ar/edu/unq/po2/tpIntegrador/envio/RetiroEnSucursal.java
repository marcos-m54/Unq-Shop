package ar.edu.unq.po2.tpIntegrador.envio;

import ar.edu.unq.po2.tpIntegrador.creacionDeProductos.Sucursal;
import ar.edu.unq.po2.tpIntegrador.state.Pedido;

public class RetiroEnSucursal implements IFormaDeEnvio {
	
	private Sucursal sucursal;
	
	// Nota Yami: Agregue constructor, setter y getter (uml)
	public RetiroEnSucursal(Sucursal sucursal) {
		super();
	    this.sucursal = sucursal;
	}

	public Sucursal getSucursal() {
	    return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
	    this.sucursal = sucursal;
	}
	
	@Override
	public Double calcularValorDelEnvio(Pedido pedido) {
		return 0.0;
	}

	@Override
	public int estimacionDiasDeEnvio(Pedido pedido) {
		
		if (sucursal.hayStockDeItemsDePedido(pedido)) {
			return 0;
		}
			else {
				return 3;
			}
		}
}
