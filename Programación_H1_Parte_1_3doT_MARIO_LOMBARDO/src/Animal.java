
public abstract class Animal {
	int numeroChip;
	String nombre;
	int edad;
	String raza;
	boolean adoptado;
	
	public Animal(int numeroChip, String nombre, int edad, String raza, boolean adoptado) {
		this.numeroChip = numeroChip;
		this.nombre = nombre;
		this.edad = edad;
		this.raza = raza;
		this.adoptado = adoptado;
	}
	
	abstract void mostrar();
}
