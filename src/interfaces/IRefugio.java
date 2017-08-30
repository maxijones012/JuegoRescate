package interfaces;

import rescate.Persona;
import rescate.Robot;

public interface IRefugio {
	/**
	 * Verifica el choque contra un robot
	 */
	public void chocarContraRobot(Robot robot);
	
	

	public void entregarPersonaEnRefugio(Persona personaCargada);
	
	
	
}
