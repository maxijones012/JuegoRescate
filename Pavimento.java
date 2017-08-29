package EmpresaLogistica;

public class Pavimento extends Camino{

	public Pavimento(String descripcion) {
		super(descripcion);

	}

	//constructor
	public Pavimento(Tramo tramo){
		super(tramo);		
	}

	@Override
	public double calcularCostoTramo() throws VehiculoNoAptoExeption {
		if (this.getVehiculo() instanceof VehiculoAutomovil){
			throw new VehiculoNoAptoExeption(this.getVehiculo());
		}
		else{
			return super.calcularCostoTramo();			
		}
	}
	
	
}
