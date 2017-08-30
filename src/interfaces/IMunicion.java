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
	 * retorna el daño de la munision	
	 * @return dano de la munision
	 */
	public int getDaño();
	
	

	/**
	 * setea el daño de la municion
	 * @param daño
	 */
	public void setDaño(int daño);
	
	
	

	/**
	 * Gira la dirección del canion en un determinado angulo
	 * 
	 * @param angulo Ángulo que se desea girar. Si el canion tiene un angulo actual de 100º y se gira 30º, el resultado 
	 * debera ser un angulo final de 130º
	 */
	public void girar(int direccion);
	
	
	
	
	
	
	
	
	
	
	
}
