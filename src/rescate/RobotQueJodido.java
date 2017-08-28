package rescate;

import java.util.ArrayList;

/**
 * clase contenedora de el robot que jodido que NO rescata personas, se encarga de detectar robot que lleven 
 * personas y dispararles y atrapar bonus de energia cuando se cuentre por debajo del 20%
 *
 */
public class RobotQueJodido extends Robot{

	public RobotQueJodido(int posicionX, int posicionY, Escenario escenario) {
		super(posicionX, posicionY, escenario);
	}
	

	@Override
	public void jugar() {
		super.jugar();
		if (this.getNivelEnergia() > 250){
			for(int i=0; i<this.getRadar().getElementosVistos().size(); i++){
				Elemento e = this.getRadar().getElementosVistos().get(i);
				if(e instanceof Robot){
					Robot r = (Robot) e;
					if (r.isLlevaPersona()){
						disparar();
					}
				}
			}
		}
		else{			
			for(int i=0; i< this.getRadar().getElementosVistos().size() ;i++){
				Elemento e = this.getRadar().getElementosVistos().get(i);
				if(e instanceof BonusBateria){					
					this.disparar();					
				}
			}
		}
		if (this.getNivelEnergia()>=0){
			this.avanzar();	
		}
	}
	
	@Override
	public void chocarContraSatelite(Satelite satelite) {	}

	@Override
	public void elementosVistos(ArrayList<Elemento> elementos) {}

}
