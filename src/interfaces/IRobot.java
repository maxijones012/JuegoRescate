package interfaces;

import rescate.Bomba;
import rescate.Escenario;
import rescate.Radar;
import rescate.Refugio;
import rescate.ZonaRescate;

public interface IRobot {

	
	/**
	 * funcion que sirve para dejar una persona que lleva el robot en el refugio
	 * @param refugio
	 */
	public void dejarPersona(Refugio refugio);
	
	

	/**
	 * recarga la energia del robot con una cantidad dada
	 * @param energia
	 */
	public void recargarEnergia(int energia);
	
	
	
	
	//TODO
	public void chocarContraRefugio(Refugio refugio);

	//TODO
	public void chocarContraZonaRescate(ZonaRescate zonaRescate);
	
	

	/**
	 *  decrementa el escudo de un robot si choca contra una bomba
	 */
	public void chocarContraBomba(Bomba bomba);
	

	/**
	 * devuelve el radar que pertence a el robot
	 * @return radar del robot
	 */
	public Radar getRadar() ;
	
	

	/**
	 *  Procedimiento que responde a disparar municion
	 */
	public void disparar();
	
	

	/**
	 * Procedimiento que responde a lanzar bomba
	 */
	public void lanzarBomba();
	

	/**
	 * Muestra el nivel de escudo del robot
	 * @return nivel de escudo del robot
	 */
	public int getNivelEscudo() ;
	
	
	

	/**
	 * Setea el nivel de escudo del robot
	 * @param nivelEscudo
	 */
	public void setNivelEscudo(int nivelEscudo);
	
	

	/**
	 * se decrementa el nivel de escudo del robot en una cantidad dada
	 * @param daño
	 */
	public void romperEscudo(int daño);
	
	

	/**
	 * muestra el nivel de energia del robot
	 * @return
	 */
	public int getNivelEnergia();
	
	
	

	/**
	 * Setea el nivel de energia del robot
	 * @param nivelEnergia
	 */
	public void setNivelEnergia(int nivelEnergia) ;
	
	
	

	/**
	 * muestra la cantidad de municiones que posse el robot
	 * @return
	 */
	public int getCantidadMunicion();
	
	
	

	/**
	 * Setea la cantidad de municiones que tiene el robot
	 * @param cantidadMunicion
	 */
	public void setCantidadMunicion(int cantidadMunicion) ;
	
	

	/**
	 * Muestra la cantidad de bombas que tiene el robot
	 * @return
	 */
	public int getCantidadBomba() ;
	

	/**
	 * Setea la cantidad de bombas que tiene el robot
	 * @param cantidadBomba
	 */
	public void setCantidadBomba(int cantidadBomba) ;
	
	
	

	/**
	 * muestr el escenario del robot
	 */
	public Escenario getEscenario() ;
	
	

	/**
	 * setea el estado del robot si lleva una persona o no
	 * @param llevaPersona
	 */
	public void setLlevaPersona(boolean llevaPersona);
	
	
	

	/**
	 * devulve el estado de el robot si lleva una persona o no
	 * @return true o false
	 */
	public boolean isLlevaPersona();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
