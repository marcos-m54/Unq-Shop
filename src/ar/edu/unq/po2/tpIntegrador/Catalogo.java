package ar.edu.unq.po2.tpIntegrador;

import java.util.ArrayList;

public class Catalogo {
	
	private ArrayList<IItem> items;
	
	public Catalogo(ArrayList<IItem> items) {
		this.items = items;
	}

	public void agregarItem(IItem item) {
		//validar o no lo de añadir un producto invalido?
		this.items.add(item);
	}
	
	public void quitarItem(IItem item) {
		this.items.remove(item);
	}
	
	//getter para obtener los items?  
	/*
	public ArrayList<Item> getItems() {
		return items;
	}
	*/
	
	/* metodo para añadir varios items y no de uno? 
	public void setItems(ArrayList<IItem> items) {
		this.items = items;
	}
	*/
	

}
