package utiles;

import rescate.Movible;

public abstract class HelperMovible {
	
	public static void girar(Movible obj, int direccion){
		int dirNueva = obj.getDireccion() + direccion;
		while (dirNueva >= 360){
			dirNueva = dirNueva - 360;
		}
		obj.setDireccion(dirNueva);
	}
	
	
	public static void avanzarX(Movible obj){
		obj.getPosicion().setX((int) (obj.getPosicion().getX()+ Math.cos(Math.toRadians(obj.getDireccion()))*obj.getVelocidad()));		
	}
	public static void avanzarY(Movible obj){
		obj.getPosicion().setY((int) (obj.getPosicion().getY()+ Math.sin(Math.toRadians(obj.getDireccion()))*obj.getVelocidad()));		
	}
	
	
	
	
}
