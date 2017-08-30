package interfaces;

import rescate.Elemento;
import rescate.Municion;

public interface IMunicion {

	
	/** 
	 * Metodo que se encarga de lanzar una {@link Municion municion}
	 * a los diferentes elementos del escenario.
	 */
	public void disparar(Elemento elemento, Municion municion);
	
	

	/**
	 * retorna el da�o de la munision	
	 * @return dano de la munision
	 */
	public int getDa�o();
	
	

	/**
	 * setea el da�o de la municion
	 * @param da�o
	 */
	public void setDa�o(int da�o);
	
	
	

	/**
	 * Gira la direcci�n del canion en un determinado angulo
	 * 
	 * @param angulo �ngulo que se desea girar. Si el canion tiene un angulo actual de 100� y se gira 30�, el resultado 
	 * debera ser un angulo final de 130�
	 */
	public void girar(int direccion);
	
	
	
	
	
	
	
	
	
	
	
}
