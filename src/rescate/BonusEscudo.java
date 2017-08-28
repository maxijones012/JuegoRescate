package rescate;


public class BonusEscudo extends Bonus{
	
	private int escudo = 10;
	
	public BonusEscudo(int posicionX, int posicionY, Escenario escenario){
		super(posicionX, posicionY, escenario);
	}


	/**
	 * recarga el escudo del robot recibido por parametro
	 */
	@Override
	public void chocarContraRobot(Robot robot) { 
		this.destruir(this);
	}
	
	
	/**
	 * devuelve la llamada al dueño de la municion
	 */
	@Override
	public void chocarContraMunicion(Municion municion) {
		if(municion.getDuenio() instanceof Robot){
			Robot r = (Robot) municion.getDuenio();
			this.chocarContraRobot(r);
			r.setNivelEnergia(r.getNivelEscudo()+(r.getEscenario().getConfig().getBonusEscudo())) ;
		}
		if(municion.getDuenio() instanceof Satelite){
			Satelite s = (Satelite) municion.getDuenio();
			this.chocarContraSatelite(s);
		}
	}
	
	/**
	 * al chocar contra un elemento este se destruye
	 */
	@Override
	public void chocarContra(Elemento elemento) {
		elemento.chocarContraBonusEscudo(this);
		destruir(this);
	}
	
	@Override
	public void chocarContraSatelite(Satelite satelite) {
	satelite.chocarContraBonusEscudo(this);
	}
	
	public int getEscudo() {
		return escudo;
	}


	public void setEscudo(int escudo) {
		this.escudo = escudo;
	}

}
