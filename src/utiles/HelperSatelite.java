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
	 * 
	 * los valores estan dados por el angulo de escaneo desde INI - MAX
	 * @param satelite, ini, max
	 *  
	 */
	public static void girarCorrector(Satelite satelite, int ini, int max) {
		
		if (satelite.getRadarOn()==true){
			satelite.getRadar().girar(10);
			if (   satelite.getRadar().getDireccion()>ini ){
				satelite.setRadarOn(false);
			}
			else
				satelite.setRadarOn(true);
		}
		else
			satelite.getRadar().girar(-10);
		if (   satelite.getRadar().getDireccion()<max ){
			satelite.setRadarOn(true);
		}
		
		
	}		
		public static void girarCorrector(Satelite satelite, int ini, int max,int velocidadGiro) {
			
			if (satelite.getRadarOn()==true){
				satelite.getRadar().girar(velocidadGiro);
				if (   satelite.getRadar().getDireccion()>ini ){
					satelite.setRadarOn(false);
				}
				else
					satelite.setRadarOn(true);
			}
			else
				satelite.getRadar().girar(-velocidadGiro);
			if (   satelite.getRadar().getDireccion()<max ){
				satelite.setRadarOn(true);
			}
		}
}
