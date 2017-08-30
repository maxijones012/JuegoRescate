package rescate;

/**
 * Clase abstrcta bonus, contiene todos los metodos que pueden tener los bonus que son
 * redefinidos en las subclases (BONUS BATERIA/ESCUDO)
 *
 */
public abstract class Bonus extends Elemento{

	private int tiempoDeVida;
	private Config config;
	
	
	/**
	 * Constrcutor obligatorio que deben implementar las sub-clases Bonus Bateria - Bonus Escudo
	 * @param posicionX
	 * @param posicionY
	 * @param escenario
	 */
	public Bonus(int posicionX, int posicionY, Escenario escenario) {
		super(posicionX, posicionY, escenario);
		this.config = escenario.getConfig();
		this.setTamanio(new Tamanio(config.getAnchoBonus(), config.getAltoBonus()));
		
	}
	
	
	@Override
	public void chocarContraMunicion(Municion municion) {}
		
	/**
	 * juega el bonus hasta que termine a su tiempo de vida 
	 */
	@Override
	public void jugar() {
		if (this.getTiempoDeVida()>=0){
			this.setTiempoDeVida(this.getTiempoDeVida()-1);		
		}
		else{
			destruir(this);
		}
	}
	
	
	/**
	 * retorna la llamada al elemento contra el que choco
	 */
	@Override
	public void chocarContra(Elemento elemento) {
		elemento.chocarContraBonus();
	}	
	

	
	public void chocarContraRobot(Robot robot){
		destruir(this);
	}   //se redefine en las subclases de bonus
	
	
	/**
	 * retorna el tiempo de vida del bonus
	 * 
	 * @return Tiempo de vida seteado
	 */
	public int getTiempoDeVida() {
		return tiempoDeVida;
	}
	
	
	
	
	
	
	/**
	 * Setea el tiempo de vida del bonus
	 */
	public void setTiempoDeVida(int tiempoDeVida) {
		this.tiempoDeVida = tiempoDeVida;
	}


	
	public void chocarContraBonusBateria(BonusBateria bonus) {}
	
	public void chocarContraBonusEscudo(BonusEscudo bonus) {}
}
