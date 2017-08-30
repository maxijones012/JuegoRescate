package interfaces;

import java.util.ArrayList;

import rescate.Elemento;

public interface IEscenario {
	/**
	 * agrega un elemento a la lista de elementos del escenario
	 * @param elementos
	 */
	public static void addElemento(Elemento elemento){};
	
	
	
	/**
	 * se queda en un bucle dando turnos a cada elemento para que implemente sus metodos
	 */
	public static void iniciarJuego(){};
	
	
	
	
}
