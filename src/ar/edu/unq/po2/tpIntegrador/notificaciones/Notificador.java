package ar.edu.unq.po2.tpIntegrador.notificaciones;

import java.util.ArrayList;

import ar.edu.unq.po2.tpIntegrador.state.IEstado;
import ar.edu.unq.po2.tpIntegrador.state.Pedido;

public class Notificador {
	
	private IEstado estadoPrincipal;
	
	private ArrayList<ISuscriptor> suscriptores = new ArrayList<ISuscriptor>();
	
	public void suscribir (ISuscriptor suscriptor) {
		suscriptores.add(suscriptor);
	}
	
	public void desuscribir (ISuscriptor suscriptor) {
		suscriptores.remove(suscriptor);
	}
	
	public void notificarASuscriptores(IEstado estado) {
		
		for (ISuscriptor suscriptor: suscriptores) {
			suscriptor.actualizar(estado);
		}
	}
	
}
