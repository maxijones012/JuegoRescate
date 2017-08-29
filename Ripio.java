package EmpresaLogistica;

public class Ripio extends Camino {
	private GradoConservacion gradoConservacion;
	
	//constructores
	public Ripio(Tramo tramo) {
		super(tramo);
	}	
//	constructores
	public Ripio(String descripcion){
		super(descripcion);
	}
	
	
	
	//GETTERS SETTERES
	public GradoConservacion getGradoConservacion() {
		return gradoConservacion;
	}
	public void setGradoConservacion(GradoConservacion gradoConservacion) {
		this.gradoConservacion = gradoConservacion;
	}
	
	
	@Override
	public double calcularCostoTramo() throws VehiculoNoAptoExeption {
		if (this.getVehiculo() instanceof CamionDobleEje){
			throw new VehiculoNoAptoExeption(this.getVehiculo());
		}
		else{
			return super.calcularCostoTramo();			
		}
	}
	
	
	
	
	
}
