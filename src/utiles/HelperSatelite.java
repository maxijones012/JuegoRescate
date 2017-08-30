package utiles;

import rescate.Config;
import rescate.Municion;
import rescate.Satelite;

public abstract class HelperSatelite {
	
	
	public static void disparar(Satelite obj){
		if(obj.getCantidadMuniciones() > 0){
			Municion municion = new Municion(obj.getPosicion().getX(), obj.getPosicion().getY(), obj.getEscenario());
			municion.disparar(obj, municion);
			municion.setDireccion(obj.getRadar().getDireccion());
			obj.setCantidadMuniciones(obj.getCantidadMuniciones()-1);
		}
	}

	/**
	 * corrige el radar del satelite para no tocar el tope del escenario
	 * @param satelite
	 */
	public static void girarCorrector(Satelite satelite) {
		
		if (satelite.getRadarOn()==true){
			satelite.getRadar().girar(10);
			if (   satelite.getRadar().getDireccion()>180  ){
				satelite.setRadarOn(false);
			}
			else
				satelite.setRadarOn(true);
		}
		else
			satelite.getRadar().girar(-10);
		if (   satelite.getRadar().getDireccion()<0  ){
			satelite.setRadarOn(true);
		}
		
	}
}
