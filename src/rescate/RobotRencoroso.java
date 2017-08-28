package rescate;

import java.util.ArrayList;

/**
 * clase contenedora de el robot rencoroso que se encarga de detectar robot y dispararles y de 
 * obtener cualquier tipo de bonus dentro del escenario
 *
 */
public class RobotRencoroso extends Robot{
	
	/**
	 * constructor de la clase robot rencoroso donde se aplica el mismo constructor que la clase padre robot
	 * @param posicionX
	 * @param posicionY
	 * @param escenario
	 */
	public RobotRencoroso(int posicionX, int posicionY, Escenario escenario) {
		super(posicionX, posicionY, escenario);
	}

	
	/**
	 * si el robot detecata es su jugada un robot o un bonus dispera para debilitar al robot,
	 * o al bonus para tomar el beneficio
	 */
	@Override
	public void jugar() {
		super.jugar();
		for(int i=0; i<this.getRadar().getElementosVistos().size(); i++){
			Elemento e = this.getRadar().getElementosVistos().get(i);
			if(e instanceof Bonus || e instanceof Robot){
				disparar();
				
			}
		}
		avanzar();
	}


	@Override
	public void elementosVistos(ArrayList<Elemento> elementos) {

		
	}
	
}