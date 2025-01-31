package GestorBiblioteca;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class GestorLibro {
    private Libro[] libros = new Libro[0];
    private Map<Libro, Integer> contadorPrestamos = new HashMap<>();

    public void agregarLibro(Libro libro) {
        Libro[] nuevoArray = Arrays.copyOf(libros, libros.length + 1);
        nuevoArray[libros.length] = libro;
        libros = nuevoArray;
    }

    public boolean eliminarLibro(String titulo) {
        for (int i = 0; i < libros.length; i++) {
            if (libros[i].getTitulo().equalsIgnoreCase(titulo)) {
                Libro[] nuevoArray = new Libro[libros.length - 1];
                System.arraycopy(libros, 0, nuevoArray, 0, i);
                System.arraycopy(libros, i + 1, nuevoArray, i, nuevoArray.length - i);
                libros = nuevoArray;
                return true;
            }
        }
        return false;
    }

    public Libro[] buscarLibros(String criterio) {
        return Arrays.stream(libros)
                .filter(libro -> libro.getTitulo().toLowerCase().contains(criterio.toLowerCase()) ||
                        libro.getAutor().toLowerCase().contains(criterio.toLowerCase()) ||
                        libro.getCategoria().toLowerCase().contains(criterio.toLowerCase()))
                .toArray(Libro[]::new);
    }

    public Libro[] getLibrosDisponibles() {
        return Arrays.stream(libros)
                .filter(libro -> !libro.isPrestado())
                .toArray(Libro[]::new);
    }

    public Libro[] getLibrosPrestados() {
        return Arrays.stream(libros)
                .filter(Libro::isPrestado)
                .toArray(Libro[]::new);
    }

    public void incrementarContadorPrestamos(Libro libro) {
        contadorPrestamos.merge(libro, 1, Integer::sum);
    }

    public int getTotalPrestamosHistoricos() {
        return contadorPrestamos.values().stream().mapToInt(Integer::intValue).sum();
    }

    public Libro[] getLibrosMasPrestados() {
        return contadorPrestamos.entrySet().stream()
                .sorted(Map.Entry.<Libro, Integer>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .toArray(Libro[]::new);
    }

    @Override
    public String toString() {
        return Arrays.toString(libros);
    }

}