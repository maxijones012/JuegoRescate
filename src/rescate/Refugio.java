package rescate;

import java.util.ArrayList;

import interfaces.IRefugio;

/**
 * Clase refugio, contiene todas las accciones que puede realizar el refugio dentro del juego
 *
 */
public class Refugio extends Elemento implements IRefugio{
	
	ArrayList<Persona> personasEnRefugio = new ArrayList<>();
	
	/**
	 * Constructor de la clase Refugio 
	 * @param posicionX
	 * @param posicionY
	 * @param escenario
	 */
	public Refugio(int posicionX, int posicionY, Escenario escenario) {
		super(posicionX, posicionY, escenario);
		
	}

	@Override
	public void jugar() {} /*no realiza ningun movimiento en el jugar*/			
	

	//CHOCAR CHONTRA
	@Override
	public void chocarContra(Elemento elemento) {	
		elemento.chocarContraRefugio(this);
	}	
	
	@Override
	public void chocarContraBonusBateria(BonusBateria bonus) {}
	
	@Override
	public void chocarContraBonusEscudo(BonusEscudo bonus) {}

	public void chocarContraRobot(Robot robot) {
		//tiene personas (?
		if (robot.isLlevaPersona()){
			robot.dejarPersona(this);
			System.out.println("ROBOT DEJO PERSONA EN REFUGIO");
		}			
	}
	
	@Override
	public void chocarContraMunicion(Municion municion) {
		municion.chocarContraRefugio(this);
	}
	
	public void entregarPersonaEnRefugio(Persona personaCargada) {
		personasEnRefugio.add(personaCargada);
		
	}

}
