package model;

public class EdificioOficinas implements Edificio{
	private float superficieEdificio;

	@Override
	public float getSuperficieEdificio() {
		return superficieEdificio;
	}

	@Override
	public void setSuperficieEdificio(float superficieEdificio) {
		this.superficieEdificio=superficieEdificio;
		
	}
	

	
}
