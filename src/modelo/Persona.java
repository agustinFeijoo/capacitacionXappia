package modelo;

public class Persona {
	private float peso;
	private float altura;
	private String nombre;
	private static int id=0;
	
	
	public Persona(float peso, float altura, String nombre) {
		super();
		this.peso = peso;
		this.altura = altura;
		this.nombre = nombre;
		id++;
	}
	public int getId() {
		return id;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public float getAltura() {
		return altura;
	}
	public void setAltura(float altura) {
		this.altura = altura;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
