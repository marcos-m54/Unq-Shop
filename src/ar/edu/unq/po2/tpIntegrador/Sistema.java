package ar.edu.unq.po2.tpIntegrador;


public class Sistema {
	
	private Catalogo catalogo;
	
	
	public Sistema(Catalogo catalogo) {
		this.catalogo = catalogo;
	}


	public void agregarItemDeCatalogo(IItem item) {
		this.catalogo.agregarItem(item);
	}
	
	public void sacarItemDeCatalogo(IItem item) {
		this.catalogo.quitarItem(item);
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
