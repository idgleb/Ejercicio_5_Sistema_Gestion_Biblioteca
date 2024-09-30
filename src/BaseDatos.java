import java.util.ArrayList;

public class BaseDatos {
    private ArrayList<Libro> libros;
    private ArrayList<Usario> usarios;

    private BaseDatos() {
        //inicializacion
        libros = new ArrayList<>();
        usarios = new ArrayList<>();
    }

    ///Libros
    public ArrayList<Libro> getLibros() {
        return libros;
    }
    public Libro getLibroPorTitulo(String titulo) {
        for (Libro libro : libros) {
            if (titulo.equals(libro.getTitulo())) return libro;
        }
        return null;
    }
    public void addLibro(Libro libro) {
        this.libros.add(libro);
    }
    ///

    ///Usarios
    public ArrayList<Usario> getUsarios() {
        return usarios;
    }
    public Usario getUsarioPorDni(String dni) {
        for (Usario usario : usarios) {
            if (dni.equals(usario.getDni())) return usario;
        }
        return null;
    }
    public void addUsario(Usario usario) {
        this.usarios.add(usario);
    }
    ///

    private static class BaseDatosHolder {
        private static final BaseDatos INSTANCE = new BaseDatos();
    }
    public static BaseDatos getInstance(){
        return BaseDatosHolder.INSTANCE;
    }


}
