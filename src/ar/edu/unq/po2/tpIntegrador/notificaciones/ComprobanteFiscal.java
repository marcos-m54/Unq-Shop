package ar.edu.unq.po2.tpIntegrador.notificaciones;

import java.time.LocalDate;

public class ComprobanteFiscal {
	
	private String tipoDeComprobante;
	private int numeroDeComprobante;
	private LocalDate fecha;
	private String CUIT;
	private double montoTotal;
	
	public ComprobanteFiscal(String tipoDeComprobante, int numeroDeComprobante, LocalDate fecha, String cuit,
			double montoTotal) {
		this.tipoDeComprobante = tipoDeComprobante;
		this.numeroDeComprobante = numeroDeComprobante;
		this.fecha = fecha;
		this.CUIT = cuit;
		this.montoTotal = montoTotal;
	}



	public int getNumeroDeComprobante() {
		return numeroDeComprobante;
	}
	
	public void setNumeroDeComprobante(int numeroDeComprobante) {
		this.numeroDeComprobante = numeroDeComprobante;
	}
	
	public LocalDate getFecha() {
		return fecha;
	}
	
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	public String getCUIT() {
		return CUIT;
	}
	
	public void setCUIT(String cUIT) {
		CUIT = cUIT;
	}
	
	public double getMontoTotal() {
		return montoTotal;
	}
	
	public void setMontoTotal(double montoTotal) {
		this.montoTotal = montoTotal;
	}
	
	public String getTipoDeComprobante() {
		return tipoDeComprobante;
	}
	
	public void setTipoDeComprobante(String tipoDeComprobante) {
		this.tipoDeComprobante = tipoDeComprobante;
	}
	
	
	

}
