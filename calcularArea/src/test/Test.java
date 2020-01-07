package test;

import model.FiguraGeometrica;
import model.Triangulo;

public class Test {

	public static void main(String[] args) {
		FiguraGeometrica figuraGeometrica=new Triangulo(5,8);
		System.out.println(figuraGeometrica.toString()+" "+figuraGeometrica.getArea());
		
	}

}
