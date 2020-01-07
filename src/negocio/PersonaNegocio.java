package negocio;

import java.util.Scanner;
import java.util.regex.Pattern;

import modelo.Persona;

public class PersonaNegocio {
	
	public PersonaNegocio() {
	}
	
	public static boolean isNumber(String str) {
		Pattern pattern= Pattern.compile("-?\\d+(\\.\\d+)?");
		return !pattern.matcher(str).matches()||Double.parseDouble(str)<=0;
	
	}
	public Persona pedirDatos() {
		
		float altura=0, peso=0;
		boolean pesoValido=false,alturaValida=false;
		String nombre, entrada;
		Scanner in = new Scanner(System.in);
		PersonaNegocio pn = new PersonaNegocio();
		System.out.println("Ingresé el nombre");
		nombre = in.nextLine();
		
		while(!pesoValido) {
		System.out.println("Hola " + nombre + ",cuanto pesas?");
		entrada = in.nextLine();
		if (!pn.isNumber(entrada)){
			peso = Float.parseFloat(entrada);
			pesoValido=true;
		}
		}
		while(!alturaValida) {
			System.out.println("Cuanto medis ?(mts)");
			entrada = in.nextLine();
			if (!pn.isNumber(entrada)) {
				altura = Float.parseFloat(entrada);
				alturaValida=true;
			}
		}
		return new Persona(peso,altura,nombre);
	}
	public float calcularIMC(float peso,float altura) {
		float IMC=peso/(altura*altura);
		return IMC;
	}
	public void mostrarLogica() {
		System.out.println("La lógica de criterios es la siguiente:");
		System.out.println("< 18.5 BAJO PESO");
		System.out.println("de 18.5 a 24.9 NORMAL");
		System.out.println("de 25 a 29.9 SOBRE PESO");
		System.out.println("sino OBESIDAD");	
	}
	public String establecerResultado(float IMC) {
		String resultado;
		if(IMC<=18.5) {
			resultado="Peso bajo";
		}else {
			if((IMC>18.5)&&(IMC<=24.9)) {
				resultado="Peso normal";
			}else {
				if((IMC>24.9)&&(IMC<29.9)) {
					resultado="Sobre peso";
				}else {
					resultado="Obesidad";
				}
			}
		}
		return resultado;
		
	}
	
}
