package ar.edu.unq.po2.tpIntegrador;

import java.util.ArrayList;

public class Deposito {
	
	private ArrayList<IItem> items = new ArrayList<IItem>();
	
	public int getStockDe(IItem item) {
		return item.getStock();
	}

	public ArrayList<IItem> getItems() {
		return items;
	}

	public void setItems(ArrayList<IItem> items) {
		this.items = items;
	}

}
