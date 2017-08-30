package utiles;

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
}
