package Rescate;

import java.awt.Polygon;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

import Grafica.JuegoListener;
import Grafica.JuegoUI;
import Grafica.Modelo;
import Grafica.PersonasRescatadas.PersonasRescatada;


public class Escenario implements JuegoListener, PersonasRescatada{
	private Config config;
	private boolean bonusAleatorio;
	private int bonusContador = 0;
	private boolean finalizar = false;
	private boolean pausa = false;
	
	public Escenario(){
		this.config= new Config();
	}

	/**
	 * se queda en un bucle dando turnos a cada elemento para que implemente sus metodos
	 */
	public void iniciarJuego(){
		crearElementos();
		
		//CREAMOS LA PARTE GRAFICA
		JuegoUI vista = new JuegoUI(this);
		vista.iniciar(new Modelo()); 
		
		while(!finalizar){
			if (!config.isPausa()){
				
				//TODO BORRAR LOS BONUS
				crearBonus();
				crearBonus();				
				crearBonus();
				crearBonus();
				crearBonus();
				crearBonus();				
				crearBonus();
				crearBonus();
				
			 	turnos();		 					 	
			 	
			 	vista.actualizar();
			 	
				verficarChoques();
				
				actualizarEnConsola();

				depurarElementos();
			}	
			
		 	try {
				Thread.sleep(500); //aca va un 1000
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * muestra los estados en la consola
	 */
	private void actualizarEnConsola() {
		for(int i=0; i<elementos.size();i++){
			Elemento e = elementos.get(i);
		}
		
	}


	/**
	 * añade a una lista todos los elementos que puede visualizar un radar
	 * @param radar
	 * @return lista de elementos
	 */
	public ArrayList<Elemento> detectarElementos(Radar radar){
		ArrayList<Elemento> elementosVistos = new ArrayList<Elemento>();
		
		for(int i= 0; i< elementos.size();i++){
			Elemento elemento = JuegoListener.elementos.get(i);
			
			Rectangle areaElemento = new Rectangle((int)elemento.getPosicion().getX(),(int)elemento.getPosicion().getY()); 
			
			Polygon areaRadar = radar.getAreaCobertura();
			
			if (areaRadar.intersects(areaElemento)){				
				elementosVistos.add(elemento);	
			}			
		}
		return elementosVistos;
	}
	
	
	/**
	 * funcion encargada de crear bonus de forma alatoria tanto de bonus de escudo, como de energia,
	 * y lo ubica en el escenario de forma aleatoria
	 */
	public void crearBonus() {
		  Random timeRandom = new Random();
		  int tiempoRandom = (int)(timeRandom.nextDouble()*10);  //3000
		  this.bonusContador =bonusContador+1;
		  if (this.bonusContador>=tiempoRandom){
			  this.bonusAleatorio=true;
			  this.bonusContador=0;
		  }
		  Bonus bonus=null;
		  Random tipoRandom = new Random();
		  int tipoBonus = (int)(tipoRandom.nextDouble()*2+1);
		  if(this.bonusAleatorio==true){	
			  Random randx = new Random();
			  Random randy = new Random();
			  int x = (int) (randx.nextDouble()*config.getAnchoTablero());
			  int y = (int) (randy.nextDouble()*config.getAltoTablero());
			switch (tipoBonus) {
				case 1:	
						bonus = new BonusBateria(x,y,this); 
						break;
		
				case 2:	bonus = new BonusEscudo(x,y,this);
						break;
			}
			bonus.getTamanio().setAlto(config.getAltoBonus());
			bonus.getTamanio().setAncho(config.getAnchoBonus());
			
			bonus.setTiempoDeVida(99);

			
			JuegoListener.elementos.add(bonus);
			this.bonusAleatorio=false;
		  }
	}

	
	/**
	 * Se encarga de monitorear los estados de vida de los elementos presentes en el juego
	 * en caso de que un elemento no este vivo es retirado del juego.
	 * 
	 */
	private void depurarElementos() {
		for(int i=0; i<JuegoListener.elementos.size();i++){
			if (!JuegoListener.elementos.get(i).estaVivo())
				JuegoListener.elementos.remove(i);
		}
		
	}
	
	
	
	/**
	 * controla si un elemento se choco con otro elemento dentro del escenario
	 */
	private void verficarChoques() {
		
		for(int i=0; i<JuegoListener.elementos.size();i++){
			
			Elemento e1 = JuegoListener.elementos.get(i);
			
			//guaramos las coordenadas para verificar si choco contra el tablero
			int coord1 = e1.getPosicion().getX();
			int coord2 = e1.getPosicion().getY();
			//Creamos el rectangulo
			Rectangle r1 = new Rectangle(e1.getPosicion().getX(),
										e1.getPosicion().getY(),
										e1.getTamanio().getAncho(),
										e1.getTamanio().getAlto());
			
			for(int j=i+1; j<JuegoListener.elementos.size(); j++){
				
				//Creamos el rectangulo
				Elemento e2 = JuegoListener.elementos.get(j);
				Rectangle r2 = new Rectangle(e2.getPosicion().getX(),
						e2.getPosicion().getY(),
						e2.getTamanio().getAncho(),
						e2.getTamanio().getAlto());												
				
				if(r1.intersects(r2)){
					e1.chocarContra(e2);
					e2.chocarContra(e1);
				}
			}
			
			
			// estaContenidoDentro, hace referencia si no se paso del tope del tablero
			// esta contenidoposito, se fija si las posiciones son positivas 
			boolean estaContenidoDentro = ( (coord1 >= this.config.getAnchoTablero()) || (coord2 >= this.config.getAltoTablero()) ); 
			boolean estaContenidoPositivo= (coord1<= 0) || (coord2 <= 0 ); 
			if(estaContenidoPositivo || estaContenidoDentro){
				e1.chocarContraPared();
			}			
		}


	}



	/**
	 * le da un turno a cada elemento
	 */
	private void turnos() {
		for(int i=0; i<JuegoListener.elementos.size(); i++){
			Elemento elemento = JuegoListener.elementos.get(i);
			
			elemento.jugar();
		}
	}

	/**
	 * crea un elemento y lo añade a la lista de elementos
	 */
	private void crearElementos() {
		
		
		Refugio refugio = new Refugio(20, 20, this); 
		refugio.setTamanio(new Tamanio(config.getAnchoRefugio(), config.getAltoRefugio()) );
		JuegoListener.elementos.add(refugio);
		
		//ZONA DE RESCATE
		ZonaRescate zonaRescate1 = new ZonaRescate(400, 300, this);
		JuegoListener.elementos.add(zonaRescate1);	
		
		
		RobotHumano rHumano = new RobotHumano(250, 250, this);
		rHumano.setNivelEnergia(999999999);
		JuegoListener.elementos.add(rHumano);
		rHumano.setCantidadMunicion(9999999);
		rHumano.setRadar(new Radar(rHumano));	
		
		
//		Robot robot1 = new Robot(230, 270, this);
//		robot1.setNivelEnergia(100000000);		
//		JuegoListener.elementos.add(robot1);
//		robot1.setCantidadBomba(100);
//		robot1.setCantidadMunicion(10);
//		robot1.setRadar(new Radar(robot1));
		
		
		//EQUIPOSOLDADO RYAN
		RobotSoldadoRyan robotRY = new RobotSoldadoRyan(0, 270, this);
		robotRY.setNivelEnergia(100000000);
		robotRY.setNivelEscudo(30);
		JuegoListener.elementos.add(robotRY);
		robotRY.setCantidadBomba(100);
		robotRY.setCantidadMunicion(10);
		robotRY.setRadar(new Radar(robotRY));
		
		
//		Robot robot2 = new Robot(120, 150, this);
//		robot2.setNivelEnergia(100000000);		
//		JuegoListener.elementos.add(robot2);
//		robot2.setCantidadBomba(10);
//		robot2.setCantidadMunicion(10);
//		robot2.setRadar(new Radar(robot2));
//		
		
		Satelite satelite = new Satelite(380,50,this);
		satelite.setTamanio(new Tamanio(config.getAnchoSatelite(), config.getAltoSatelite()) );
		JuegoListener.elementos.add(satelite);
		satelite.setRadar(new Radar(satelite));
			
	}
	
	
	

	/**
	 * retorna la lista de todos los elementos activos del escenario
	 * @return lista de elementos
	 */
	public ArrayList<Elemento> getElementos() {
		return elementos;
	}

	
	/**
	 * agrega un elemento a la lista de elementos del escenario
	 * @param elementos
	 */
	public void addElemento(Elemento elemento) {
		JuegoListener.elementos.add(elemento);
	}
	

	public boolean isFinalizar() {
		return finalizar;
	}

	public void setFinalizar(boolean finalizar) {
		this.finalizar = finalizar;
	}

	public boolean isPausa() {
		return pausa;
	}

	public void setPausa(boolean pausa) {
		this.pausa = pausa;
	}

	public Config getConfig() {
		return config;
	}

	public void setConfig(Config config) {
		this.config = config;
	}
	
	
			
			
	
	
}

