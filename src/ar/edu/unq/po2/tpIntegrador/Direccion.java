package ar.edu.unq.po2.tpIntegrador;

public class Direccion {

	
	private String Provincia;
	private String localidad;
	private String calle;
	private int altura;
	
	public Direccion(String provincia, String localidad, String calle, int altura) {
		super();
		Provincia = provincia;
		this.localidad = localidad;
		this.calle = calle;
		this.altura = altura;
	}

	public String getProvincia() {
		return Provincia;
	}

	public void setProvincia(String provincia) {
		Provincia = provincia;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}
	
	
	
	
}
