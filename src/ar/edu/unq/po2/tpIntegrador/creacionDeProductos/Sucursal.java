package ar.edu.unq.po2.tpIntegrador.creacionDeProductos;

public class Sucursal {
	
	private String nombre;
	private Deposito deposito;
	
	public Sucursal(String nombre, Deposito deposito) {
		this.nombre = nombre;
		this.deposito = deposito;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Deposito getDeposito() {
		return deposito;
	}

	public void setDeposito(Deposito deposito) {
		this.deposito = deposito;
	}

}
