package rescate;

public class BonusBateria extends Bonus{
	
	private int energia = 10 ;
	
	/**
	 * Constructor de la clase bonus bateria 
	 * @param posicionX
	 * @param posicionY
	 * @param escenario
	 */
	public BonusBateria(int posicionX, int posicionY, Escenario escenario) {
		super(posicionX, posicionY, escenario);
	}

	
	
	/**
	 * devuelve la llamada al dueño de la municion
	 */
	@Override
	public void chocarContraMunicion(Municion municion) {
		if(municion.getDuenio() instanceof Robot){
			Robot robot = (Robot) municion.getDuenio();
			this.chocarContraRobot(robot);
		}
		if(municion.getDuenio() instanceof Satelite){
			Satelite s = (Satelite) municion.getDuenio();
			this.chocarContraSatelite(s);			
		}
	}
	
	
	/**
	 * recarga la energia del robot
	 */
	
	@Override
	public void chocarContraRobot(Robot robot) {
		this.destruir(this);
	}
	
	@Override
	public void chocarContraSatelite(Satelite satelite) {
	satelite.chocarContraBonusBateria(this);
	}
	/**
	 * al chocar contra un elemento este se destruye
	 */
	@Override
	public void chocarContra(Elemento elemento) {
		elemento.chocarContraBonusBateria(this);
		this.destruir(this);
	}
    
	 
	/**
	 * obtiene la energia del bonus
	 * @return
	 */
	public int getEnergia() {
		return energia;
	}

	/**
	 * setea la energia que otorga el bonus
	 * @param energia
	 */
	public void setEnergia(int energia) {
		this.energia = energia;
	}

	
}
