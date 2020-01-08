package model;

public class Circulo extends FiguraGeometrica{
	
	private float radio;
	
	public Circulo(float radio) {
		super();
		this.radio = radio;
	}
	@Override
	public float getArea() {
		return (float) (Math.PI*Math.pow(radio, 2));
	}
	public float getRadio() {
		return radio;
	}
	public void setRadio(float radio) {
		this.radio = radio;
	}
	@Override
	public String toString() {
		return "Circulo [radio=" + radio + "]";
	}
	
	
}
