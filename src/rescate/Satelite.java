package rescate;

import java.util.ArrayList;

import interfaces.RadarListener;
import utiles.HelperSatelite;

public class Satelite extends Elemento implements RadarListener{
	private int nivelEscudo;
	private int cantidadMuniciones;
	private Radar radar;
	private Config config;
	private Boolean radarOn=true;
	private Escenario escenario;
	

	/**
	 * Constructor de la clase satelite
	 * @param posicionX
	 * @param posicionY
	 * @param escenario
	 */
	public Satelite(int posicionX, int posicionY, Escenario escenario) {
		super(posicionX, posicionY, escenario);
		this.escenario= escenario;
		this.config= escenario.getConfig();
		this.cantidadMuniciones = escenario.getConfig().getCantidadMunicion();
		this.setTamanio(new Tamanio(config.getAnchoSatelite(), config.getAltoSatelite()));
		this.radar = new Radar(this);		
		this.radar.addRadarListener(this);
		this.nivelEscudo= this.config.getEscudo();
	}

	@Override
	public void jugar() {
		this.getRadar().escanear();
		if (this.getNivelEscudo()>=0){
			HelperSatelite.girarCorrector(this);
//			this.getRadar().girar(10);
			for(int i=0; i<this.getRadar().getElementosVistos().size(); i++){
				Elemento e = this.getRadar().getElementosVistos().get(i);
				if(e instanceof Robot){
					disparar();					
				}
			}
		}else{
			this.destruir(this);
		}
			
	}
		
	
	
	public void disparar(){
		HelperSatelite.disparar(this);
	}
	
	
	/**
	 * devuelve el radar que pertence a el satelite
	 * @return radar del satelite
	 */
	public Radar getRadar() {
		return radar;
	}

	
	/**
	 * muestra el niverl de escudo que tiene el satelite
	 * @return nivel escudo
	 */
	public int getNivelEscudo() {
		return nivelEscudo;
	}
	
	/**
	 * setea el nivel de escudo del satelite
	 * @param nivelEscudo
	 */
	public void setNivelEscudo(int nivelEscudo) {
		this.nivelEscudo = nivelEscudo;
	}
	
	
	/**
	 * muestra la cantidad de municiones que tiene el satelite
	 * @return cantidad de municiones
	 */
	public int getCantidadMuniciones() {
		return cantidadMuniciones;
	}
	
	
	/**
	 * setea la cantidad de municiones de un saltelite
	 * @param cantidadMuniciones
	 */
	public void setCantidadMuniciones(int cantidadMuniciones) {
		this.cantidadMuniciones = cantidadMuniciones;
	}

	
	@Override
	public void chocarContra(Elemento elemento) {
		elemento.chocarContraSatelite(this);
	}
	
	@Override
	public void elementosVistos(ArrayList<Elemento> elementos) {		
	}

	@Override
	public void chocarContraBonusEscudo(BonusEscudo bonus) {}
	
	@Override
	public void chocarContraBonusBateria(BonusBateria bonus) {}

	@Override
	public void chocarContraRobot(Robot robot) {
		robot.chocarContraSatelite(this);
	}
	@Override
	public void chocarContraMunicion(Municion municion) {
		this.setNivelEscudo(this.getNivelEscudo()-municion.getDaño());
		
	}

	public Boolean getRadarOn() {
		return radarOn;
	}

	public void setRadarOn(Boolean radarOn) {
		this.radarOn = radarOn;
	}

}
