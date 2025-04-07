
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// Estructura de datos para almacenar animales
		HashMap<Integer, Animal> animales = new HashMap<Integer, Animal>();
		
		// Crear el scanner para obtener entrada por teclado
		Scanner scanner = new Scanner(System.in);
		
		// Menú interactivo
		int opcion;
		do {
			System.out.println();
			System.out.println("--- MENÚ ---");
            System.out.println("1. Dar de alta un animal");
            System.out.println("2. Buscar un animal");
            System.out.println("3. Salir");
            
            // Pedir número de opción
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer
            
            switch (opcion) {
            	case 1:
            		// Dar de alta un animal
            		altaAnimal(scanner, animales);
            		break;
            	case 2:
            		// Buscar animal
            		buscarAnimal(scanner, animales);
            		break;
            	case 3:
            		// Salir
            		System.out.println("Saliendo...");
            		break;
            	default:
                    System.out.println("Opción inválida.");
            }
            
		} while (opcion != 3);
		
		// Cerrar scanner
		scanner.close();
	}
	
	// Método para dar de alta animales
	public static void altaAnimal(Scanner sc, HashMap<Integer, Animal> animales) {
		// Preguntar el tipo de animal a insertar
		System.out.print("Tipo de animal: ");
		String tipoAnimal = sc.nextLine().toLowerCase();
		
		// Gestionar tipo inválido
		if (!tipoAnimal.equals("perro") && !tipoAnimal.equals("gato")) {
			System.out.println("Error: Tipo inválido.");
			return;
		}
		
		// Pedir el número de chip
		System.out.print("Número de chip: ");
		int numChip = sc.nextInt();
		sc.nextLine(); // Limpiar buffer
		
		// Gestionar números de chip duplicados
		if (animales.containsKey(numChip)) {
			System.out.println("Error: Número de chip existente.");
			return;
		}
		
		// Preguntar los datos del animal
		System.out.print("Nombre: ");
		String nombre = sc.nextLine();		
		System.out.print("Edad: ");
		int edad = sc.nextInt();
		sc.nextLine(); // Limpiar buffer
		System.out.print("Raza: ");
		String raza = sc.nextLine();
		System.out.print("Adoptado (true/false): ");
		boolean adoptado = sc.nextBoolean();
		sc.nextLine(); // Limpiar buffer

		// Gestionar según el tipo de animal
		Animal animal = null;
		if (tipoAnimal.equals("perro")) {
			System.out.print("Tamaño: ");
			String tamanio = sc.nextLine();
			animal = new Perro(numChip, nombre, edad, raza, adoptado, tamanio);
		} else if (tipoAnimal.equals("gato")) {
			System.out.print("Test Leucemia (true/false): ");
			boolean testLeucemia = sc.nextBoolean();
			animal = new Gato(numChip, nombre, edad, raza, adoptado, testLeucemia);
		}
		
		// Añadir animal
		if (animal != null) {
			animales.put(numChip, animal);
			System.out.println("Animal añadido con éxito");
		} else {
			System.out.println("Error al añadir al animal");
		}
	}
	
	// Método para buscar un animal
	public static void buscarAnimal(Scanner sc, HashMap<Integer, Animal> animales) {
		// Pedir número de chip
		System.out.print("Número de chip del animal a buscar: ");
		int numChip = sc.nextInt();
		
		if (!animales.containsKey(numChip)) {
			System.out.println("Error: El número de chip no existe.");
			return;
		}
		
		// Mostrar los datos del animal
		animales.get(numChip).mostrar();
	}
}
