package ar.edu.unq.po2.tpIntegrador.notificaciones;

import java.util.ArrayList;

import ar.edu.unq.po2.tpIntegrador.state.Pedido;

public class Notificador {
	
	//private IEstado estadoPrincipal;
	
	private ArrayList<ISuscriptora> suscriptores = new ArrayList<ISuscriptora>();
	
	public void suscribir (ISuscriptora suscriptor) {
		suscriptores.add(suscriptor);
	}
	
	public void desuscribir (ISuscriptora suscriptor) {
		suscriptores.remove(suscriptor);
	}
	
	public void notificarASuscriptores(Pedido pedido) {
		
		for (ISuscriptora suscriptor: suscriptores) {
			suscriptor.actualizar(pedido);
		}
	}
	
}
