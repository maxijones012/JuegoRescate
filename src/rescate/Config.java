package rescate;

public class Config {
	/*Tamaño de todos los elementos del juego*/
	private int anchoTablero= 800;
	private int altoTablero = 600;
	
	

	//ROBOT
	private int escudo=39;	
	
	private int anchoRobot = 40;
	private int altoRobot = 40;
	
	private int anchoSatelite=50;
	private int altoSatelite=50;
	
	
	private int anchoZonaRescate=80;
	private int altoZonaRescate=80;
	
	private int	anchoMunicion = 20;
	private int altoMunicion = 20;
	private int cantidadMunicion = 5000; 
	
	private int	anchoBomba = 20;
	private int altoBomba = 20;
	private int TimeVidaBonus = 50;
	private int anchoBonus = 30 ;
	private int altoBonus = 30;
	
	/*valores de daños*/
	private int dañoBomba = 15;
	private int dañoMunicion = 10;
	private int expansion = 5;


	private int velocidad = 25;
	private int velocidadBomba = 60;
	private int velocidadMunicion = 60;
	private int cantidadBomba = 40; 
	
	private int direccion = 20;

	private final int duracionJuego = 1000000;
	private int radarAlcanceMaximo;
	private int tiempoEsperaJuego ;
	
	
	
	private int anchoRefugio=80;
	private int altoRefugio=80;
	
	
	
	//radarr
	private int anguloApertura=20;
	private int alcance=300;
	private int alcanceMaximo=100;
	
	
	
	private int bonusBateria=30;
	private int bonusEscudo=40;
	
	
	private int Energia=300;
	
	


	//ROBOT HUMANO
	private boolean arriba;
	private boolean abajo;
	private boolean izquierda;
	private boolean derecha;
	private boolean disMunicion;
	private boolean disBomba;
	
	/**
	 * Devuelve tiempo de duracion del juego
	 * 
	 * @return Tiempo
	 */
	public int getDuracionJuego() {
		return this.duracionJuego;
	}

	/**
	 * Alto del tablero donde se desarrolla el juego en pixels
	 * 
	 * @return Cantidad de pixels
	 */
	public int getAltoTablero() {
		return this.altoTablero;
	}

	
	/**
	 * Ancho del tablero donde se desarrolla el juego en pixels
	 * 
	 * @return Cantidad de pixels
	 */
	
	public int getAnchoTablero() {
		return this.anchoTablero;
	}

	/**
	 * Devuelve el alcance máximo de un radar.
	 * 
	 * 
	 * @return Distancia en pixels
	 */

	public int getRadarAlcanceMaximo() {
		return this.radarAlcanceMaximo;
	}

	/**
	 * Devuelve el tiempo de espera entre turnos
	 * 
	 * @return Segundos
	 */

	public int getTiempoEsperaJuego() {
		return this.tiempoEsperaJuego;
	}

	/**
	 * Devuelve el alto de una municion
	 * 
	 * @return Cantidad de pixels
	 */

	public int getAltoMunicion() {
		return this.altoMunicion;
	}

	/**
	 * Devuelve el ancho de una municion
	 * 
	 * @return Cantidad de pixels
	 */

	public int getAnchoMunicion() {
		return this.anchoMunicion;
	}

	/**
	 * Devuelve el alto de un Robot
	 * 
	 * @return Cantidad de pixels
	 */

	public int getAltoRobot() {
		return this.altoRobot;
	}

	/**
	 * Devuelve el ancho de un Robot
	 * 
	 * @return Cantidad de pixels
	 */
	public int getAnchoRobot() {
		return this.anchoRobot;
	}

	/**
	 * Devuelve el alto de un Bonus Energia
	 * 
	 * @return Cantidad de pixels
	 */


	/**
	 * Devuelve el alto del Bonus
	 * 
	 * @return Cantidad de pixels
	 */
	
	public int getAltoBonus() {
		return this.altoBonus;
	}

	/**
	 * Devuelve el ancho del Bonus
	 * 
	 * @return Cantidad de pixels
	 */
	
	public int getAnchoBonus() {
		return this.anchoBonus;
	}
	/**
	 * Devuelve el alto de la bomba
	 * @return cantidad de pixeles
	 */
	
	public int getAltoBomba() {
		return altoBomba;
	}
	
	public int getAnchoSatelite() {
		return anchoSatelite;
	}

	public void setAnchoSatelite(int anchoSatelite) {
		this.anchoSatelite = anchoSatelite;
	}

	
	public int getBonusBateria() {
		return bonusBateria;
	}

	public int getBonusEscudo() {
		return bonusEscudo;
	}
	public int getAltoZonaRescate() {
		return altoZonaRescate;
	}

	public void setAltoZonaRescate(int altoZonaRescate) {
		this.altoZonaRescate = altoZonaRescate;
	}

	public int getAnchoZonaRescate() {
		return anchoZonaRescate;
	}

	public void setAnchoZonaRescate(int anchoZonaRescate) {
		this.anchoZonaRescate = anchoZonaRescate;
	}

	public void setAltoTablero(int altoTablero) {
		this.altoTablero = altoTablero;
	}

	public void setAnchoTablero(int anchoTablero) {
		this.anchoTablero = anchoTablero;
	}

	public void setAnchoRobot(int anchoRobot) {
		this.anchoRobot = anchoRobot;
	}

	public void setAltoRobot(int altoRobot) {
		this.altoRobot = altoRobot;
	}

	public void setAnchoMunicion(int anchoMunicion) {
		this.anchoMunicion = anchoMunicion;
	}

	public void setAltoMunicion(int altoMunicion) {
		this.altoMunicion = altoMunicion;
	}

	public void setAnchoBomba(int anchoBomba) {
		this.anchoBomba = anchoBomba;
	}

	public void setAltoBomba(int altoBomba) {
		this.altoBomba = altoBomba;
	}


	public void setRadarAlcanceMaximo(int radarAlcanceMaximo) {
		this.radarAlcanceMaximo = radarAlcanceMaximo;
	}

	public void setTiempoEsperaJuego(int tiempoEsperaJuego) {
		this.tiempoEsperaJuego = tiempoEsperaJuego;
	}

	public int getAltoSatelite() {
		return altoSatelite;
	}


	public boolean isArriba() {
		return arriba;
	}

	public void setArriba(boolean arriba) {
		this.arriba = arriba;
	}


	public void setAbajo(boolean abajo) {
		this.abajo = abajo;
	}

	public void setIzquierda(boolean izquierda) {
		this.izquierda = izquierda;
	}


	public boolean isAbajo() {
		return abajo;
	}

	public boolean isIzquierda() {
		return izquierda;
	}

	public boolean isDerecha() {
		return derecha;
	}

	public void setDerecha(boolean derecha) {
		this.derecha = derecha;
	}

	public void setAltoSatelite(int altoSatelite) {
		this.altoSatelite = altoSatelite;
	}

	/**
	 * devulve el alto de la bomba
	 * @return cantidad de pixeles
	 */
	public int getAnchoBomba() {
		return anchoBomba;
	}

	
/*__________________________________DAÑOS___________________________________________________________________*/
	
	/**
	 * devulve el valor de daño de la bomba
	 * @return
	 */
	public int getDañoBomba() {
		return dañoBomba;
	}
	
	/**
	 * devulve el valor de daño de la municion
	 * @return
	 */
	public int getDañoMunicion() {
		return dañoMunicion;
	}
	

	public int getVelocidad() {
		return velocidad;
	}

	public int getVelocidadBomba() {
		return velocidadBomba;
	}

	public int getVelocidadMunicion() {
		return velocidadMunicion;
	}
	
	public int getDireccion() {
		return direccion;
	}
	
	public int getExpansion() {
		return expansion;
	}
	
	public int getTimeVidaBonus() {
		return TimeVidaBonus;
	}

	public int getCantidadBomba() {
		return cantidadBomba;
	}

	public int getCantidadMunicion() {
		return cantidadMunicion;
	}

	public int getEscudo() {
		return escudo;
	}

	public int getAnguloApertura() {
		return anguloApertura;
	}

	public int getAlcance() {
		return alcance;
	}

	public int getAlcanceMaximo() {
		return alcanceMaximo;
	}

	public int getAnchoRefugio() {
		return anchoRefugio;
	}

	public int getAltoRefugio() {
		return altoRefugio;
	}

	public boolean isDisMunicion() {
		return disMunicion;
	}

	public void setDisMunicion(boolean disMunicion) {
		this.disMunicion = disMunicion;
	}

	public boolean isDisBomba() {
		return disBomba;
	}

	public void setDisBomba(boolean disBomba) {
		this.disBomba = disBomba;
	}

	public int getEnergia() {
		return Energia;
	}



}

