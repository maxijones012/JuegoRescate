package utiles;

import java.awt.Dimension;
import java.awt.event.KeyEvent;

import grafica.Tablero;
import rescate.Config;


public class HelperTablero {
	
	
	public static void controlTeclado(Tablero obj ,KeyEvent e,Config config){

		if (e.getKeyCode() == KeyEvent.VK_DOWN){
			config.setAbajo(true);
			config.setArriba(false);
			config.setIzquierda(false);
			config.setDerecha(false);
		}
		if (e.getKeyCode() == KeyEvent.VK_UP){
			config.setAbajo(false);
			config.setArriba(true);
			config.setIzquierda(false);
			config.setDerecha(false);
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT){
			config.setAbajo(false);
			config.setArriba(false);
			config.setIzquierda(false);
			config.setDerecha(true);	
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT){
			config.setAbajo(false);
			config.setArriba(false);
			config.setIzquierda(true);
			config.setDerecha(false);	
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE ){
			config.setDisMunicion(true);
		}
		if (e.getKeyCode() == KeyEvent.VK_B){
			config.setDisBomba(true);
		}
	}

}

