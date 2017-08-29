package Grafica;


import java.awt.Point;
import java.util.ArrayList;

/**
 * 
 * 
 * @version 2.3
 */
public class Modelo {
	private ArrayList<ModeloListener> listeners; //una lista de objetos que implementan la interfaz
	private ArrayList<Point> puntos;
	
	/**
	 * Constructor de clase
	 */
	public Modelo(){
		listeners = new ArrayList<ModeloListener>();
		puntos = new ArrayList<Point>();
	}
	

	public void addModeloListener(ModeloListener listener){
		listeners.add(listener);
	}
	
	public void agregar(int x, int y){
		puntos.add(new Point(x, y));
		
		for(ModeloListener listener : listeners){
			listener.actualizar();
		}
	}
	
	public void limpiar(){
		puntos = new ArrayList<Point>();
	}
	
	public ArrayList<Point> getPuntos(){
		return this.puntos;
	}

}

