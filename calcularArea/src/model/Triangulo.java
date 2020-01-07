package model;

public class Triangulo extends FiguraGeometrica{
	private int base,altura;

	
	public Triangulo(int base, int altura) {
		super();
		this.base = base;
		this.altura = altura;
	}


	public int getBase() {
		return base;
	}


	public void setBase(int base) {
		this.base = base;
	}


	public int getAltura() {
		return altura;
	}


	public void setAltura(int altura) {
		this.altura = altura;
	}


	@Override
	public float getArea() {
		return base*altura/2;
	}


	@Override
	public String toString() {
		return "Triangulo [base=" + base + ", altura=" + altura + "]";
	}
	
	
}
