package GestorBiblioteca;

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
    }
    