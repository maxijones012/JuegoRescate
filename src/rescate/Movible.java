package rescate;
import interfaces.IMovible;
import utiles.HelperMovible;

/**
 * Clase donde los elementos tienen la particularidad de moverse dentro del escenario
 *
 */
public abstract class Movible extends Elemento implements IMovible{
	
	private Config config;
	private int direccion ; 
	private int velocidad ;
	
	/**
	 * Constructor de clase 
	 * @param posicionX
	 * @param posicionY
	 * @param escenario
	 */
	public Movible(int posicionX, int posicionY, Escenario escenario) {
		super(posicionX, posicionY, escenario);
		this.config=escenario.getConfig();
		this.direccion= config.getDireccion();
		this.velocidad= config.getVelocidad();
	}
	
	public void avanzar() {	
		HelperMovible.avanzarX(this);
		HelperMovible.avanzarY(this);
	}
	
	
	public void girar(int direccion){
		HelperMovible.girar(this, direccion);
	}
	
	
	public void chocoContraBonus(Bonus bonus) {}
	
	public void chocoContraMunicion(Municion municion) {}
	

	public int getDireccion() {
		return direccion;
	}
	
	
	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}
	
	
	public int getVelocidad() {
		return velocidad;
	}

	
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}


	@Override
	public void chocarContra(Elemento elemento) {}

	@Override
	public void chocarContraBonusEscudo(BonusEscudo bonus) {}
	
	@Override
	public void chocarContraBonusBateria(BonusBateria bonus) {}

	@Override
	public void chocarContraRobot(Robot robot) {		
	}

	@Override
	public void chocarContraSatelite(Satelite satelite) {}



	public Config getConfig() {
		return config;
	}

	public void setConfig(Config config) {
		this.config = config;
	}

}
