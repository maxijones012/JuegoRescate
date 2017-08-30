package utiles;

import java.awt.Color;

import grafica.CampoBatalla;
import rescate.Elemento;

public class HelperCampoBatalla {

	public static void inicializarCampo(CampoBatalla campoBatalla) {		
		campoBatalla.setBackground(Color.BLACK);
		campoBatalla.setForeground(Color.RED);
		campoBatalla.setLocation(250,250);
	}



}
