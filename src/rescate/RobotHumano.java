package rescate;

import java.util.ArrayList;

public class RobotHumano extends Robot{	
	
	
	public RobotHumano(int posicionX, int posicionY, Escenario escenario) {
		super(posicionX, posicionY, escenario);
	}
	
	
	@Override
	public void jugar() {
		if(this.getConfig().isDisMunicion()){
			this.disparar();
			this.getConfig().setDisMunicion(false);
		}
		if(this.getConfig().isDisBomba()){
			this.lanzarBomba();
			this.getConfig().setDisBomba(false);
		}
		if (this.getConfig().isDerecha()){
			this.setDireccion(0);		
			this.avanzar();
		}
		else{
			if (this.getConfig().isIzquierda()){
				this.setDireccion(180);
				this.avanzar();
			}
			else{
				if (this.getConfig().isArriba()){
					this.setDireccion(270);
					this.avanzar();
				}
				else{
					this.setDireccion(90); 
					this.avanzar();
				}
			}
		}				
	}
	
	
	// Chocar contra
	@Override
	public void chocarContra(Elemento elemento) {
	}

	@Override
	public void chocarContraPared() {
		super.setDireccion(this.getDireccion()-180);
		super.avanzar();
	}
	
	
	@Override
	public void chocarContraSatelite(Satelite satelite) {
	}
	
	@Override
	public void chocarContraBonusBateria(BonusBateria bonus) {
	}
	
	@Override
	public void chocarContraBonusEscudo(BonusEscudo bonus) {
	}
	
	@Override
	public void chocarContraMunicion(Municion municion) {
	}
	@Override
	public void chocarContraRefugio(Refugio refugio) {
	}
	
	@Override
	public void chocarContraBomba(Bomba bomba) {
	}
	
	@Override
	public void chocarContraZonaRescate(ZonaRescate zonaRescate) {
	}


	@Override
	public void elementosVistos(ArrayList<Elemento> elementos) {
	}

}
