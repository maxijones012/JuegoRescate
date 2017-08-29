package Rescate;

import java.util.ArrayList;

public class RobotSoldadoRyan extends Robot{
	private Config config;
	private int i=0;
	private boolean buscaEscudo=false;
	/**
	 * Constructor de la clase Robot Soldado ryan
	 * @param posicionX
	 * @param posicionY
	 * @param escenario
	 */	
	public RobotSoldadoRyan(int posicionX, int posicionY, Escenario escenario) {
		super(posicionX, posicionY, escenario);
		this.config= escenario.getConfig();
		this.setTamanio(new Tamanio(this.config.getAnchoRobot(), this.config.getAltoRobot()));
		
	}

	
	@Override
	public void jugar() {
		if (this.getNivelEscudo()>40){
			super.jugar();
		}
		else{ //tiene poco nivel de energia		
			if ( ((this.getRadar().getElementosVistos().size()) == 0)){
				super.avanzar();
			}else{
				for (int i=0; i<= this.getRadar().getElementosVistos().size(); i++){
					Elemento e1 =  this.getRadar().getElementosVistos().get(i); 
					if (e1 instanceof BonusEscudo){
						disparar();
						
					}
					super.avanzar();
				}
				
			}
				
		}
	}
				
	@Override
	public void elementosVistos(ArrayList<Elemento> elementosVistos) {
	}
	
	public int getI() {
		return i;
	}


	public void setI(int i) {
		this.i = i;
	}


	public boolean isBuscaEscudo() {
		return buscaEscudo;
	}


	public void setBuscaEscudo(boolean buscaEscudo) {
		this.buscaEscudo = buscaEscudo;
	}
	
	
}
