package prueba;

import modelo.Persona;
import negocio.PersonaNegocio;

public class Test {
	public static void main(String[] args) {
		PersonaNegocio pn=new PersonaNegocio();
		float IMC;
		
		Persona p=pn.pedirDatos();
		IMC=pn.calcularIMC(p.getPeso(), p.getAltura());
		
		System.out.println("El IMC es de "+IMC);
		
		pn.mostrarLogica();
		
		System.out.println("TU RESULTADO ES "+pn.establecerResultado(IMC));
		// Persona p=new Persona(peso,altura,nombre);

	}

}
