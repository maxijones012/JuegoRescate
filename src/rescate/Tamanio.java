package rescate;

import interfaces.ITamanio;

public class Tamanio implements ITamanio{
	private int ancho;
	private int alto;
	
	public Tamanio(int ancho, int alto){
		this.ancho = ancho;
		this.alto = alto;
	}
	
	
	
	
//	getters setters
	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}
	
	public void setAlto(int alto) {
		this.alto = alto;
	}
}
