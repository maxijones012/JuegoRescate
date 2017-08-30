package utiles;

import rescate.Elemento;
import rescate.Radar;

public abstract class HelperMovimiento {
	
	
	public static int obtenerPosicionX(Elemento e) {
		return (e.getPosicion().getX());
	}

	public static int obtenerPosicionY(Elemento e) {
		return (e.getPosicion().getY());
	}

	public static void girar(Radar radar, int angulo) {
		int dirNueva = radar.getDireccion() + angulo;
		while (dirNueva >= 360){
			dirNueva = dirNueva - 360;
		}
		radar.setDireccion(dirNueva);
	}
	
	
	
}
