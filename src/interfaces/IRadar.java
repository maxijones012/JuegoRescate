package interfaces;

import java.awt.Polygon;

public interface IRadar {

	
	/**
	 * Utiliza el poligono para detectar elementos en un angulo determinado por su distrancia
	 * @return area de cobertura que cubre el robot
	 */
	public Polygon getAreaCobertura();
	
	
	/**
	 * Devuelve el angulo de Apertura de vision del radar
	 * @return angulo de apertura del radar
	 */
	public int getAnguloApertura();
	
	

	/**
	 * Setea el angulo de apertura de vision del radar
	 * @param anguloApertura 
	 * 
	 */
	public void setAnguloApertura(int anguloApertura);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
