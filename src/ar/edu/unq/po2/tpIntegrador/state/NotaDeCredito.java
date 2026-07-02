package ar.edu.unq.po2.tpIntegrador.state;

import java.time.LocalDate;

public class NotaDeCredito {


	private String titular;
	private LocalDate fecha;
	private Double monto;
	
	
	public NotaDeCredito(String titular, LocalDate fecha, Double monto) {
		this.titular = titular;
		this.fecha = fecha;
		this.monto = monto;
	}
	
	
	public String getTitular() {
		return titular;
	}
	
	public void setTitular(String titular) {
		this.titular = titular;
	}
	
	public LocalDate getFecha() {
		return fecha;
	}
	
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	public Double getMonto() {
		return monto;
	}
	
	public void setMonto(Double monto) {
		this.monto = monto;
	}
}
