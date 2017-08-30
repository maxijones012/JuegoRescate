package interfaces;

import rescate.Bonus;
import rescate.Municion;

public interface IMovible {
	
	

	/**
	 * metodo para poder avanzar dentro del escenario dandole una direccion	
	 */
	public void avanzar() ;
	

	/**
	 * cambia la direccion con respecto al angulo actual
	 * @param angulo 
	 */
	public void girar(int direccion);
	
	

	/**
	 * Se ejecuta el metodo si un elemento choca contra un bonus
	 */
	public void chocoContraBonus(Bonus bonus) ;
	
	
	

	/**
	 * Se ejecuta el metodo si un elemento choca contra una municion
	 */
	public void chocoContraMunicion(Municion municion);
	
	
	


	/**
	 * muestra la direccion que tiene un obj movible
	 * @return direccion del movible
	 */
	public int getDireccion() ;
	
	
	

	/**
	 * setea la direccion del obj movible
	 * @param direccion
	 */
	public void setDireccion(int direccion) ;
	
	
	
	
	

	/**
	 * retorna la velocidad del obj movible
	 * @return velocidad del movible
	 */
	public int getVelocidad();
	
	
	

	/**
	 * setea la velocidad del obj movible
	 * @param velocidad
	 */
	public void setVelocidad(int velocidad);
	
	
	
	
	
	
	
	
	
	
}
