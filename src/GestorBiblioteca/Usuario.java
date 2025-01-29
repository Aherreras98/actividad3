package GestorBiblioteca;
class Usuario {
private String nombre;
private String contrasena;
private boolean esAdmin;
public Usuario(String nombre, String contrasena, boolean esAdmin) {
this.nombre = nombre;
this.contrasena = contrasena;
this.esAdmin = esAdmin;
}
public boolean validarContrasena(String contrasena) {
return this.contrasena.equals(contrasena);
}
}




