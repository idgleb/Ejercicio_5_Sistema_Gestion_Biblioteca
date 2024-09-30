import javax.swing.*;
import java.util.ArrayList;

public class Usario {
    private String nombre;
    private String dni;
    private ArrayList<Libro> libros;
    private Biblioteca biblioteca;

    public Usario(String nombre, String dni, Biblioteca biblioteca) {
        this.nombre = nombre;
        this.dni = dni;
        this.libros = new ArrayList<>();
        this.biblioteca = biblioteca;
        biblioteca.getBaseDatos().addUsario(this);
    }

    public void addLibro(Libro libro) {
        this.libros.add(libro);
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
