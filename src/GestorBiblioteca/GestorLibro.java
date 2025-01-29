package GestorBiblioteca;

import java.util.Arrays;

class GestorLibro {
    private Libro[] libros = new Libro[0];

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
}