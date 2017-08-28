package rescate;
/**
 *  Clase que contiene todas las acciones que puede realizar la bomba dentro del juego
 * 
 */
public class Bomba extends Movible{
	private int danio;
	private Elemento duenio;
	private Config config;
	
	/**
	 * Constructor de la clase Bomba
	 * @param posicionX
	 * @param posicionY
	 * @param escenario
	 * @return {@link #danio}
	 */
	public Bomba(int posicionX, int posicionY, Escenario escenario) {
		super(posicionX, posicionY, escenario);
		this.config = escenario.getConfig();
		this.setTamanio(new Tamanio(config.getAnchoBomba(),config.getAltoBomba())); //tamaño de la bomba
		this.danio = config.getDañoBomba();
		this.setVelocidad(config.getVelocidadBomba());
	}

	/**
	 * al avanzar se le reduce la velocidad que lleva si llega a 0, se destruye
	 */
	@Override
	public void jugar() {
		if(this.getVelocidad() >= 0){
			avanzar();
			this.setVelocidad(getVelocidad()-1);
		}
		else
			this.explotar(this);
			this.destruir(this);
	}
		
	
	public void lanzarBomba(Elemento elemento, Bomba bomba){
		bomba.getTamanio().setAlto(config.getAltoBomba());
		bomba.getTamanio().setAncho(config.getAnchoBomba());
		bomba.getPosicion().setX(elemento.getPosicion().getX());
		bomba.getPosicion().setY(elemento.getPosicion().getY());
		elemento.getEscenario().addElemento(bomba);
	}
	

	/**
	 * Se ejecuta si la bomba choca contra la pared, si es asi, explota y muere
	 */
	@Override
	public void chocarContraPared() {
		this.explotar(this);
		this.destruir(this);
	}
	  
	/**
	 * Se ejecuta si la bomba choca contra algun tanque, si es asi, muere
	*/
	@Override
	public void chocarContraRobot(Robot robot) {
		this.explotar(this);
		this.destruir(this);
	}
	
	
	/**
	 * Se ejecuta si la bomba choca contra algun bonus
	*/
	@Override
	public void chocoContraBonus(Bonus bonus) {
	//	bonus.chocarContraBomba(this);
		explotar(this);
		destruir(this);
	}
	
	
	/**
	 * comportamiento que toma la bomba al chochar contra un elemento
	 */
	@Override
	public void chocarContra(Elemento elemento) {
		elemento.chocarContraBomba(this);
	}
	
	/**
	 * comportamiento que toma la bomba al destruirse
	 *  @return devuleve un area de combertura mas grande
	 */
	public void explotar(Bomba bomba){
		bomba.getTamanio().setAlto(bomba.getTamanio().getAlto()+config.getExpansion());
		bomba.getTamanio().setAncho(bomba.getTamanio().getAncho()+config.getExpansion());
		
	}

	/**
	 * Devuelve el daño que provoca la bomba
	 * @return daño 
	 */
	public int getDanio() {
		return danio;
	}

	/**
	 * Setea la variable daño de la bomba
	 * @param daño
	 */
	public void setDanio(int danio) {
		this.danio = danio;
	}

	public Elemento getDuenio() {
		return duenio;
	}

	public void setDuenio(Elemento duenio) {
		this.duenio = duenio;
	}
	

}
