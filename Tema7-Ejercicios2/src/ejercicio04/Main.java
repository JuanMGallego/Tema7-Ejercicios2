package ejercicio04;

import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// Creo un array de tipo Disco de 10 posiciones
		Disco[] arrayDiscos = new Disco[10];
		int posicion = 0;
		int opcion;

		// Crear un objeto de tipo Disco y asignarlo a cada posición
		for (int i = 0; i < arrayDiscos.length; i++) {
			arrayDiscos[i] = new Disco();
		}

		do {
			menu();
			System.out.println("Introduzca una opción:");
			opcion = sc.nextInt();
			sc.nextLine();

			switch (opcion) {
			case 1:
				listado(arrayDiscos);
				break;
			case 2: // Inserto nuevo disco
				// Tengo que ver qué posición hay libre.
				posicion = posicionLibre(arrayDiscos);
				if (posicion < 0) {
					System.out.println("No hay hueco");
				} else {
					nuevoDisco(arrayDiscos, posicion);
				}
				break;
			case 3:
				modificar(arrayDiscos);
				break;
			case 4:
				borrar(arrayDiscos);
				break;
			case 5:
				System.out.println("SALIENDO...");
				break;
			default:
				System.out.println("Opción no válida");
			}
		} while (opcion != 5);
		// System.out.println(Arrays.toString(arrayDiscos));
	}

	private static void menu() {
		System.out.println("COLECCIÓN DE DISCOS");
		System.out.println("===================");
		System.out.println("1. Listado");
		System.out.println("2. Nuevo Disco");
		System.out.println("3. Modificar");
		System.out.println("4. Borrar");
		System.out.println("5. Salir");
	}

	private static void listado(Disco[] array) {
		for (Disco disco : array) {
			if (!disco.getCodigo().equals("LIBRE")) {
				System.out.println(disco);
			}
		}
	}

	private static void nuevoDisco(Disco[] array, int contador) {
		String codigo;
		String autor, titulo, genero;
		int duracion;

		codigo = String.valueOf(contador);

		System.out.println("Introduzca el autor del disco:");
		autor = sc.nextLine();

		System.out.println("Introduzca el titulo del disco:");
		titulo = sc.nextLine();

		System.out.println("Introduzca el genero del disco:");
		genero = sc.nextLine();

		System.out.println("Introduzca la duración del disco:");
		duracion = sc.nextInt();

		array[contador] = new Disco(codigo, autor, titulo, genero, duracion);

	}

	private static int posicionLibre(Disco[] array) {
		int posicion = 0;

		while (posicion < array.length && !array[posicion].getCodigo().equals("LIBRE")) {
			posicion++;
		}

		if (posicion == array.length) {
			posicion = -1;
		}

		return posicion;
	}

	private static void modificar(Disco[] array) {
		String autor, titulo, genero;
		int codigo, duracion;

		System.out.println("Introduzca el código del disco a modificar");
		codigo = sc.nextInt();
		sc.nextLine();

		if (!array[codigo].getCodigo().equals("LIBRE")) {
			System.out.println("Introduzca el autor del disco:");
			autor = sc.nextLine();
			array[codigo].setAutor(autor);

			System.out.println("Introduzca el titulo del disco:");
			titulo = sc.nextLine();
			array[codigo].setTitulo(titulo);

			System.out.println("Introduzca el genero del disco:");
			genero = sc.nextLine();
			array[codigo].setGenero(genero);

			System.out.println("Introduzca la duración del disco:");
			duracion = sc.nextInt();
			array[codigo].setDuracion(duracion);
		} else {
			System.out.println("En esa posición no hay ningún disco a modificar");
		}

	}

	public static void borrar(Disco[] array) {
		System.out.println("Introduzca el código del disco a borrar");
		int posicion = sc.nextInt();
		sc.nextLine();
		
		if(posicion>=0 && posicion<array.length) {
			array[posicion].setCodigo("LIBRE");
		} else {
			System.out.println("Código no válido");
		}
	}

}
