package GestorBiblioteca;

import java.util.Arrays;

class Usuario {
    private String nombre;
    private String contrasena;
    private boolean esAdmin;
    private Libro[] prestamosActivos = new Libro[0];
    private int totalPrestamosHistoricos;

    public Usuario(String nombre, String contrasena, boolean esAdmin) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.esAdmin = esAdmin;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean validarContrasena(String contrasena) {
        return this.contrasena.equals(contrasena);
    }

    public boolean esAdmin() {
        return esAdmin;
    }

    public Libro[] getPrestamosActivos() {
        return Arrays.copyOf(prestamosActivos, prestamosActivos.length);
    }

    public void agregarPrestamo(Libro libro) {
        prestamosActivos = Arrays.copyOf(prestamosActivos, prestamosActivos.length + 1);
        prestamosActivos[prestamosActivos.length - 1] = libro;
        totalPrestamosHistoricos++;
    }

    public void devolverPrestamo(Libro libro) {
        Libro[] nuevosPrestamos = new Libro[prestamosActivos.length - 1];
        int index = 0;
        for (Libro p : prestamosActivos) {
            if (!p.equals(libro)) {
                nuevosPrestamos[index++] = p;
            }
        }
        prestamosActivos = nuevosPrestamos;
    }

    public int getTotalPrestamosHistoricos() {
        return totalPrestamosHistoricos;
    }

    public int getPrestamosActivosCount() {
        return prestamosActivos.length;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", esAdmin=" + esAdmin +
                '}';
    }

}
