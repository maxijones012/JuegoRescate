package rescate;

import interfaces.IMunicion;

/**
 * Clase municion donde cada instancia de estas tiene un dueño
 * @author Maxi Jones
 *
 */
public class Municion extends Movible implements IMunicion{

	private int daño;
	private Elemento duenio;
	private Config config;
	
	
	/**
	 * Constructor de la clase municion
	 * @param posicionX
	 * @param posicionY
	 * @param escenario
	 */
	public Municion(int posicionX, int posicionY, Escenario escenario) {
		super(posicionX, posicionY, escenario);
		this.config = escenario.getConfig();
		this.daño= this.config.getDañoMunicion();
		this.setTamanio(new Tamanio(config.getAnchoMunicion(), config.getAltoMunicion()));
	}

	/**
	 * avanza en su turno
	 */
	@Override
	public void jugar() {
		avanzar();
	}
	

	public void disparar(Elemento elemento, Municion municion) {
		municion.getTamanio().setAlto(config.getAltoMunicion());
		municion.getTamanio().setAncho(config.getAnchoMunicion());
		municion.getPosicion().setX(elemento.getPosicion().getX());
		municion.getPosicion().setY(elemento.getPosicion().getY());
		this.setVelocidad(config.getVelocidadMunicion());
		elemento.getEscenario().addElemento(municion);
		
	}

	public int getDaño() {
		return daño;
	}
	
	
	public void setDaño(int daño) {
		this.daño = daño;
	}

	public void girar(int direccion) {
		this.setDireccion(getDireccion()+direccion);
	}
	
	/**
	 * Se ejecuta si la municion choca contra la pared, si es asi, muere
	 */
	@Override
	public void chocarContraPared() {
		destruir(this);
	}
	
	/**
	 * Se ejecuta si la municion choca contra algun tanque, si es asi, muere
	 */
	@Override
	public void chocarContraRobot(Robot robot) {
		robot.chocarContraMunicion(this);			
		destruir(this);
	}
	
	/**
	 * Se ejecuta si la municion choca contra algun bonus,
	 * este se destruye al impactar con este
	 */
	@Override
	public void chocoContraBonus(Bonus bonus) {
		this.destruir(this);
	}
	
	/**
	 * Se ejecuta si la municion choca contra algun elemento, le devuelve la llamada
	 */
	@Override
	public void chocarContra(Elemento elemento) {
		elemento.chocarContraMunicion(this);
	}
	@Override
	public void chocarContraRefugio(Refugio refugio) {
		this.destruir(this);
	}
	
	@Override
	public void chocarContraZonaRescate(ZonaRescate zona) {
		this.destruir(this);
	}

	@Override
	public void chocarContraSatelite(Satelite satelite) {
		satelite.chocarContraMunicion(this);
		this.destruir(this);
	}
	
	public Elemento getDuenio() {
		return duenio;
	}

	public void setDuenio(Elemento duenio) {
		this.duenio = duenio;
	}

}
