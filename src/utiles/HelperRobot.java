package utiles;

import rescate.Bomba;
import rescate.Config;
import rescate.Elemento;
import rescate.Municion;
import rescate.Robot;

public abstract class HelperRobot {

	public static void disparar(Robot obj){
		if (obj.getCantidadMunicion() > 0){
			Municion municion = new Municion(obj.getPosicion().getX(), obj.getPosicion().getY(), obj.getEscenario());
			municion.setDireccion(obj.getDireccion());
			municion.setDuenio(obj);
			municion.disparar(obj, municion);			
			obj.setCantidadMunicion(obj.getCantidadMunicion()-1);	
		}
	}
	
	
	public static void lanzarBomba(Robot obj){
		
		if (obj.getCantidadBomba() > 0){
			Bomba b = new Bomba(obj.getPosicion().getX(), obj.getPosicion().getY(), obj.getEscenario());
			b.setDireccion(obj.getDireccion());
			b.setDuenio(obj);
			b.lanzarBomba(obj, b);
			obj.setCantidadBomba(obj.getCantidadBomba()-1);
		}
	}

	
	public static void lanzarBomba(Elemento elemento, Bomba bomba, Config config){
		bomba.getTamanio().setAlto(config.getAltoBomba());
		bomba.getTamanio().setAncho(config.getAnchoBomba());
		bomba.getPosicion().setX(elemento.getPosicion().getX());
		bomba.getPosicion().setY(elemento.getPosicion().getY());
		elemento.getEscenario().addElemento(bomba);
	}
}
