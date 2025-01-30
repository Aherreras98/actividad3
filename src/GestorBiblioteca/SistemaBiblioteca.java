package GestorBiblioteca;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SistemaBiblioteca {

    // TENGO QUE RELLENAR ESTA PARTE//

}

    public void mostrarMenu() {
        if (usuarioActual == null) {
            System.out.println("Debe iniciar sesión para acceder al sistema.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Ver todos los libros disponibles");
            System.out.println("2. Buscar libro");
            System.out.println("3. Realizar préstamo de libro");
            System.out.println("4. Devolver libro");
            System.out.println("5. Ver mis préstamos activos");

            if (usuarioActual.esAdmin()) {
                System.out.println("6. Agregar libro");
                System.out.println("7. Eliminar libro");
                System.out.println("8. Ver libros prestados");
                System.out.println("9. Registrar usuario");
                System.out.println("10. Consultar usuarios");
                System.out.println("11. Ver estadísticas");
            }

            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    mostrarLibrosDisponibles();
                    break;
                case 2:
                    buscarLibro(scanner);
                    break;
                case 3:
                    realizarPrestamo(scanner);
                    break;
                case 4:
                    devolverLibro(scanner);
                    break;
                case 5:
                    mostrarPrestamosActivos();
                    break;
                case 6:
                    if (usuarioActual.esAdmin())
                        agregarLibro(scanner);
                    else
                        opcionInvalida();
                    break;
                case 7:
                    if (usuarioActual.esAdmin())
                        eliminarLibro(scanner);
                    else
                        opcionInvalida();
                    break;
                case 8:
                    if (usuarioActual.esAdmin())
                        mostrarLibrosPrestados();
                    else
                        opcionInvalida();
                    break;
                case 9:
                    if (usuarioActual.esAdmin())
                        registrarNuevoUsuario(scanner);
                    else
                        opcionInvalida();
                    break;
                case 10:
                    if (usuarioActual.esAdmin())
                        mostrarUsuarios();
                    else
                        opcionInvalida();
                    break;
                case 11:
                    if (usuarioActual.esAdmin())
                        mostrarEstadisticas();
                    else
                        opcionInvalida();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema.");
                    break;
                default:
                    opcionInvalida();
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
