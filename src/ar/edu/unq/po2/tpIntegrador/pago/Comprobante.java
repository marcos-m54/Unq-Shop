package ar.edu.unq.po2.tpIntegrador.pago;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public abstract class Comprobante {
	
	protected Double montoTotal;
	protected String codigoTransaccion;
    protected LocalDateTime fechaEmision;
    
    public Comprobante(Double montoTotal) {
		this.montoTotal = montoTotal;
		this.fechaEmision = LocalDateTime.now();
		this.codigoTransaccion = "TRX-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
	}
    
    public abstract String generarFormatoImprimible();
	
	public Double getMontoTotal() {
		return montoTotal;
	}
	
	public String getCodigoTransaccion() {
        return codigoTransaccion;
    }

    public LocalDateTime getFechaEmision() {
        return fechaEmision;
    }
    
    protected String getFechaFormateada() {
        return fechaEmision.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }
}
