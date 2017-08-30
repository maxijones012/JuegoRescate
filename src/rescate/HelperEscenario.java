package rescate;

import java.awt.Rectangle;
import java.awt.geom.RectangularShape;
import java.util.Random;

public class HelperEscenario {

	public static Double posicionAleatoriaX(){
		Random randx = new Random();
		return (randx.nextDouble());
	}
	
	public static Double posicionAleatoriaY(){
		Random randy = new Random();
		return( randy.nextDouble() );
	}
	
	
	public static void eliminarElementos(Escenario escenario){
		
		for(int i=0; i<escenario.elementos.size();i++){
			if (!escenario.elementos.get(i).estaVivo())
				escenario.elementos.remove(i);
		}
		
		
	}

	public static void darTurno(Escenario escenario){
		for(int i=0; i<escenario.elementos.size(); i++){
			Elemento elemento = escenario.elementos.get(i);			
			elemento.jugar();
		}
	}
}
