
public class Gato extends Animal {
	boolean testLeucemia;
	
	public Gato(int numeroChip, String nombre, int edad, String raza, boolean adoptado, boolean testLeucemia) {
		super(numeroChip, nombre, edad, raza, adoptado);
		this.testLeucemia = testLeucemia;
	}
	
	@Override
	public void mostrar() {
        System.out.println("Número de Chip: " + numeroChip);
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Raza: " + raza);
        System.out.println("Adoptado: " + (adoptado ? "Sí" : "No"));
        System.out.println("Test Leucemia: " + (testLeucemia ? "Sí" : "No"));
	}
}
