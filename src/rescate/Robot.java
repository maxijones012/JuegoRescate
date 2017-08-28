package rescate;

public abstract class Robot extends Movible implements RadarListener{
	private int nivelEscudo;
	private int nivelEnergia;
	private boolean llevaPersona = false;
	private int cantidadMunicion;
	private int cantidadBomba;
	private Radar radar; 
	private Config config;
	private Persona personaCargada;
	private Escenario escenario;	
	

	/**
	 * Constructor de clase
	 * @param posicionX
	 * @param posicionY
	 * @param escenario
	 */
	public Robot(int posicionX, int posicionY, Escenario escenario){
		super(posicionX, posicionY, escenario);
		this.escenario = escenario;
		this.config = escenario.getConfig();
		this.radar = new Radar(this);
		this.radar.addRadarListener(this);
		this.cantidadBomba = escenario.getConfig().getCantidadBomba();
		this.cantidadMunicion = escenario.getConfig().getCantidadMunicion();
		Tamanio tamanio = new Tamanio(config.getAnchoRobot(), config.getAltoRobot());
		this.setTamanio(tamanio); 
		this.nivelEnergia= this.getConfig().getEnergia();
		this.nivelEscudo= this.config.getEscudo();
	}
	
	
	/**
	 * accion que toma el robot a jugar en su turno, se encarga de avanzar y de escanar mediante el radar que 
	 * le pertenece
	 */
	@Override
	public void jugar() {
		//tengo escudo
		if (this.nivelEscudo>=0){		
			this.getRadar().escanear();				
		}
		//sino se rompio escudo
		else{
			destruir(this);
		}		
	}
	
	/**
	 * funcion que sirve para dejar una persona que lleva el robot en el refugio
	 * @param refugio
	 */
	public void dejarPersona(Refugio refugio){
		refugio.personasEnRefugio.add(getPersonaCargada());
		this.setPersonaCargada(null);
		this.setLlevaPersona(false);
	}
	
	
	/**
	 * realiza un desplazamiento hacia la direccion ya establecida
	 */
	@Override
	public void avanzar() {
		if (this.getNivelEnergia()>=0){
			super.avanzar();			
			this.setNivelEnergia(getNivelEnergia()-1);			
		}
	}
	
	/**
	 * Se ejecuta si el robot choca contra la pared
	 * 
	*/
	@Override
	public void chocarContraPared() {
		this.girar(90);
	}

	

	@Override
	public boolean equals(Object obj) {	
		return super.equals(obj);
	}
	/**
	 * choca contra un bonus bateria y devulve al llamada y aplica la funcion de 
	 * beneficio
	 */
	@Override
	public void chocarContraBonusBateria(BonusBateria bonus) {
		this.setNivelEnergia(this.getNivelEnergia()+(this.getEscenario().getConfig().getBonusBateria())) ;
		bonus.chocarContraRobot(this);
	}
	
	/**
	 * recarga la energia del robot con una cantidad dada
	 * @param energia
	 */
	public void recargarEnergia(int energia){
		this.setNivelEnergia(this.getNivelEnergia()+energia);
	}

	/**
	 * choca contra un bonus escudo y devulve al llamada y aplica la funcion de 
	 * beneficio
	 */
	@Override
	public void chocarContraBonusEscudo(BonusEscudo bonus) {
		this.recargarEscudo(bonus.getEscudo());
		bonus.chocarContraRobot(this);
	}
	
	
	@Override
	public void chocarContraSatelite(Satelite satelite) {
		girar(180);
		this.setNivelEscudo(this.getNivelEscudo()-10);
	}
	
	/**
	 * incrementa el escudo del robot con una cantidad dada
	 * @param escudo
	 */
	public void recargarEscudo(int escudo){
		this.setNivelEscudo(this.getNivelEscudo()+escudo);
	}
	
	
	public void chocarContraRefugio(Refugio refugio) {
		refugio.chocarContraRobot(this);
		this.girar(180);				
	
	}
	
	public void chocarContraZonaRescate(ZonaRescate zonaRescate){
		zonaRescate.chocarContraRobot(this);		
		girar(180);
		this.setNivelEnergia(this.nivelEnergia-1);		
	}
	
	
	/**
	 * decrementa el escudo de un robot si choca contra una municion
	*/
	@Override
	public void chocarContraMunicion(Municion municion) {
		
		if (!equals(municion.getDuenio())){
			this.setNivelEscudo(this.getNivelEscudo()- municion.getDaño());			
		}
	}
	
	/**
	 *  decrementa el escudo de un robot si choca contra una bomba
	 */
	public void chocarContraBomba(Bomba bomba){
		if (!equals(bomba.getDuenio())){
			this.setNivelEnergia(this.getNivelEscudo()- bomba.getDanio());
		}
	}
	
	/**
	 * devuelve el radar que pertence a el robot
	 * @return radar del robot
	 */
	public Radar getRadar() {
		return radar;
	}
	
	/**
	 *  Procedimiento que responde a disparar municion
	 */
	public void disparar(){
		if (this.cantidadMunicion > 0){
			Municion municion = new Municion(this.getPosicion().getX(), this.getPosicion().getY(), escenario);
			municion.setDireccion(this.getDireccion());
			municion.setDuenio(this);
			municion.disparar(this, municion);			
			this.cantidadMunicion--;	
		}
	}
	
	
	/**
	 * Procedimiento que responde a lanzar bomba
	 */
	public void lanzarBomba(){
		if (this.cantidadBomba > 0){
			Bomba b = new Bomba(this.getPosicion().getX(), this.getPosicion().getY(), escenario);
			b.setDireccion(this.getDireccion());
			b.setDuenio(this);
			b.lanzarBomba(this, b);
			this.cantidadBomba--;
		}
	}
	

	/**
	 * Muestra el nivel de escudo del robot
	 * @return nivel de escudo del robot
	 */
	public int getNivelEscudo() {
		return nivelEscudo;
	}
	
	public Persona getPersonaCargada() {
		return personaCargada;
	}
	
	
	public void setPersonaCargada(Persona personaCargada) {
		this.personaCargada = personaCargada;
	}
	
	
	/**
	 * Este metodo se ejecuta cuando el elemento choca contra otro elemento.
	 * En el mismo se efectua la accion correspondiendo dependiendo del elemento
	 * contra el que se choco.
	 * @param elemento Elemento contra el que esta chocando
	 */
	@Override
	public void chocarContra(Elemento elemento) {	
		elemento.chocarContraRobot(this);
	}
	
	@Override
	public void chocarContraRobot(Robot robot) {
		this.girar(90);
	}

	/**
	 * Setea el nivel de escudo del robot
	 * @param nivelEscudo
	 */
	public void setNivelEscudo(int nivelEscudo) {
		this.nivelEscudo = nivelEscudo;
	}
	
	
	/**
	 * se decrementa el nivel de escudo del robot en una cantidad dada
	 * @param daño
	 */
	public void romperEscudo(int daño){
		this.setNivelEscudo(this.getNivelEscudo()-daño);
	}	
	
	/**
	 * muestra el nivel de energia del robot
	 * @return
	 */
	public int getNivelEnergia() {
		return nivelEnergia;
	}
	
	/**
	 * Setea el nivel de energia del robot
	 * @param nivelEnergia
	 */
	public void setNivelEnergia(int nivelEnergia) {
		this.nivelEnergia = nivelEnergia;
	}

	/**
	 * muestra la cantidad de municiones que posse el robot
	 * @return
	 */
	public int getCantidadMunicion() {
		return cantidadMunicion;
	}
	
	
	/**
	 * Setea la cantidad de municiones que tiene el robot
	 * @param cantidadMunicion
	 */
	public void setCantidadMunicion(int cantidadMunicion) {
		this.cantidadMunicion = cantidadMunicion;
	}
	
	
	/**
	 * Muestra la cantidad de bombas que tiene el robot
	 * @return
	 */
	public int getCantidadBomba() {
		return cantidadBomba;
	}
	
	
	/**
	 * Setea la cantidad de bombas que tiene el robot
	 * @param cantidadBomba
	 */
	public void setCantidadBomba(int cantidadBomba) {
		this.cantidadBomba = cantidadBomba;
	}
	
	/**
	 * muestr el escenario del robot
	 */
	public Escenario getEscenario() {
		return escenario;
	}


	/**
	 * setea el escenario para el robot
	 */
	public void setEscenario(Escenario escenario) {
		this.escenario = escenario;
	}

	
	/**
	 * devulve el estado de el robot si lleva una persona o no
	 * @return true o false
	 */
	public boolean isLlevaPersona() {
		return llevaPersona;
	}

	
	/**
	 * setea el estado del robot si lleva una persona o no
	 * @param llevaPersona
	 */
	public void setLlevaPersona(boolean llevaPersona) {
		this.llevaPersona = llevaPersona;
	}


	public int angulo(Posicion pInicial, Posicion pFinal){
		double deltaX = pFinal.getX() - pInicial.getX();
		double deltaY = pFinal.getY() - pInicial.getY();
		double distancia = Math.sqrt(deltaX*deltaX + deltaY*deltaY);
				
		double radianes = 0;
			
		if (distancia > 0){
				radianes = Math.acos(deltaX/distancia);
		}
		int angulo = (int)Math.toDegrees(radianes);
		
		if (deltaY < 0){
				angulo = 360 - angulo;
		}
		return angulo;
	}

	/**
	 * Rescata una persona y setea la bandera del robot
	 * @param persona
	 */
	public void rescatar(Persona persona) {
		this.llevaPersona= true;
		this.personaCargada=persona;
	}

}
