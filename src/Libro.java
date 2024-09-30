public class Libro {

    private String titulo;
    private String autor;
    private Usario usario;
    private Biblioteca biblioteca;

    public Libro(String titulo, String autor, Biblioteca biblioteca) {
        this.titulo = titulo;
        this.autor = autor;
        this.usario = null;
        this.biblioteca = biblioteca;
        biblioteca.getBaseDatos().addLibro(this);
    }

    public void setUsario(Usario usario) {
        this.usario = usario;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Boolean isDisponible() {
        return (usario == null);
    }

}
