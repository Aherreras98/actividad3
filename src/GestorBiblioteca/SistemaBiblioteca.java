package GestorBiblioteca;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SistemaBiblioteca {

    //TENGO QUE RELLENAR ESTA PARTE//

}

public void mostrarMenu() {
    Scanner scanner = new Scanner(System.in);
    int opcion;
    do {
        System.out.println("\n--- Menú ---");
        System.out.println("1. Ver libros disponibles");
        System.out.println("0. Salir");
        opcion = scanner.nextInt();
        if(opcion == 1) {
            System.out.println(Arrays.toString(gestorLibro.getLibrosDisponibles()));
        }
    } while (opcion != 0);
}

private void realizarPrestamo(Scanner scanner) {
    System.out.print("Título del libro: ");
    String titulo = scanner.nextLine();
    for (Libro libro : gestorLibro.getLibrosDisponibles()) {
    if (libro.getTitulo().equalsIgnoreCase(titulo)) {
    libro.setPrestado(true);
    usuarioActual.agregarPrestamo(libro);
    gestorLibro.incrementarContadorPrestamos(libro);
    break;
    }
    }
private void mostrarEstadisticas() {
        System.out.println("\n--- Estadísticas ---");
        System.out.println("Préstamos totales: " + gestorLibro.getTotalPrestamosHistoricos());
        System.out.println("Préstamos activos: " + gestorLibro.getLibrosPrestados().length);

        Libro[] topLibros = gestorLibro.getLibrosMasPrestados();
        System.out.println("\nTop 5 libros más prestados:");
        for (int i = 0; i < topLibros.length; i++) {
            System.out.println((i + 1) + ". " + topLibros[i].getTitulo());
        }

        Usuario topUsuario = Arrays.stream(usuarios)
                .max(Comparator.comparingInt(Usuario::getPrestamosActivosCount))
                .orElse(null);
        if (topUsuario != null) {
            System.out.println("\nUsuario con más préstamos activos: " + topUsuario.getNombre());
        }
    }    
}
    