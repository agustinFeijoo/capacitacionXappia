package model;

public class Polideportivo implements Edificio{
	private String nombre;
	private float superficieEdificio;
	@Override
	public float getSuperficieEdificio() {
		
		return superficieEdificio;
	}

	@Override
	public void setSuperficieEdificio(float superficieEdificio) {
		this.superficieEdificio=superficieEdificio;
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
