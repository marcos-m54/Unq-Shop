package ar.edu.unq.po2.tpIntegrador;


public class Sistema {
	
	private Catalogo catalogo;
	
	private void agregarProducto(Item item) {
		catalogo.add(item);
	}
	
	private void quitarUnProducto(Item item) {
		this.catalogo.remove(item);
	}
	
	

	

}
