package model;

public class Cuadrado extends FiguraGeometrica{
	private int lado;
	
	public Cuadrado(int lado) {
		super();
		this.lado = lado;
	}

	@Override
	public float getArea() {
		return lado*lado;
	}

	public int getLado() {
		return lado;
	}

	public void setLado(int lado) {
		this.lado = lado;
	}

	@Override
	public String toString() {
		return "Cuadrado [lado=" + lado + "]";
	}
	
	
}
