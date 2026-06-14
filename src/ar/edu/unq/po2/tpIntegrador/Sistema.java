package ar.edu.unq.po2.tpIntegrador;

import java.util.ArrayList;

public class Sistema {
	
	private ArrayList<IItem> productos = new ArrayList<IItem>(); 
	
	//que el sistema tenga una lista de depositos
	
	private ArrayList<Deposito> depositos = new ArrayList<Deposito>();


	public void agregarItem(IItem item) {
		productos.add(item);
	}
	
	public void sacarItem(IItem item) {
		productos.remove(item);
	}

	
	public void setDepositos(ArrayList<Deposito> depositos) {
		this.depositos = depositos;
	}
	
	public ArrayList<Deposito> getDepositos() {
		return depositos;
	}
	
	/*
	
	public void nuevoPedido{}
	 
	*/
	
	/* metodo para obtener el catalogo? 
	 
	public Catalogo getCatalogo() {
		return this.catalogo;
		
	}
	*/
	
}
