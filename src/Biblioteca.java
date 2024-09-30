import javax.swing.*;
import java.util.Arrays;

public class Biblioteca {
    private String nombre;
    private BaseDatos baseDatos;

    public Biblioteca(String nombre, BaseDatos baseDatos) {
        this.nombre = nombre;
        this.baseDatos = baseDatos;
    }

    public Boolean prestar_libro() {

        Usario usario = eligirUsario();
        if (usario == null) return false;
        Libro libro = eligirLibro();
        if (libro == null) return false;

        if (libro.isDisponible()) {
            libro.setUsario(usario);
            usario.addLibro(libro);
            JOptionPane.showMessageDialog(null, "Libro: " + libro.getTitulo() + " prestando a: " + usario.getNombre());
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Libro: " + libro.getTitulo() + " no diponible ");
            return false;
        }

    }

    public Boolean devolver_libro() {

        Usario usario = eligirUsario();
        if (usario == null) return false;
        Libro libro = eligirLibroDeUsario(usario);
        if (libro == null) return false;

        libro.setUsario(null);
        usario.getLibros().remove(libro);
        JOptionPane.showMessageDialog(null, "Libro: " + libro.getTitulo() + " devolviendo");
        return true;

    }

    public Usario eligirUsario() {
        if (BaseDatos.getInstance().getUsarios().isEmpty()) {
            addUsario();
        }
        String[] arrStrUsar = new String[BaseDatos.getInstance().getUsarios().size()];
        int i = 0;
        for (Usario usario : BaseDatos.getInstance().getUsarios()) {
            arrStrUsar[i] = getInfoUsarios(usario);
            i++;
        }

        String usarioElegido = (String) JOptionPane.showInputDialog(null,
                "Elege usario", "Lista de las usarios",
                JOptionPane.QUESTION_MESSAGE, null, arrStrUsar, null);

        if (usarioElegido != null) {
            int item = Arrays.asList(arrStrUsar).indexOf(usarioElegido);
            return BaseDatos.getInstance().getUsarios().get(item);
        }
        return null;
    }

    public Libro eligirLibro() {

        if (BaseDatos.getInstance().getLibros().isEmpty()) {
            addLibro();
        }

        String[] arrStrLibros = new String[BaseDatos.getInstance().getLibros().size()];
        int i = 0;
        for (Libro libro : BaseDatos.getInstance().getLibros()) {
            arrStrLibros[i] = getInfoLibros(libro);
            i++;
        }

        String libroElegido = (String) JOptionPane.showInputDialog(null,
                "Elege libro", "Lista de los libros",
                JOptionPane.QUESTION_MESSAGE, null, arrStrLibros, null);

        if (libroElegido != null) {
            int item = Arrays.asList(arrStrLibros).indexOf(libroElegido);
            return BaseDatos.getInstance().getLibros().get(item);
        }

        return null;
    }

    public Libro eligirLibroDeUsario(Usario usario) {

        if (usario.getLibros().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Usario no tiene libros");
            return null;
        }

        String[] arrStrLibros = new String[usario.getLibros().size()];
        int i = 0;
        for (Libro libro : usario.getLibros()) {
            arrStrLibros[i] = getInfoLibros(libro);
            i++;
        }

        String libroElegido = (String) JOptionPane.showInputDialog(null,
                "Elege libro de Usario " + usario.getNombre(), "Lista de los libros",
                JOptionPane.QUESTION_MESSAGE, null, arrStrLibros, null);

        if (libroElegido != null) {
            int item = Arrays.asList(arrStrLibros).indexOf(libroElegido);
            return usario.getLibros().get(item);
        }

        return null;
    }

    public String getReporte() {
        String reporte = "Biblioteca: " + nombre + "\n";
        reporte += "__________ \n";
        reporte += "Libros: \n";
        reporte += getInfoLibros();
        reporte += "__________ \n";
        reporte += "Usarios: \n";
        reporte += getInfoUsarios();
        return reporte;

    }

    public String getInfoUsarios() {
        String infoUsarios = "";
        for (Usario usario : baseDatos.getUsarios()) {
            infoUsarios += getInfoUsarios(usario);
        }
        return infoUsarios;
    }

    public String getInfoUsarios(Usario usario) {
        String infoUsario = "";
        infoUsario += "Nombre: " + usario.getNombre() + ", DNI: " + usario.getDni() + " Tiene(";
        for (Libro libro : usario.getLibros()) {
            infoUsario += libro.getTitulo() + ", ";
        }
        infoUsario += ")\n";
        return infoUsario;
    }

    public String getInfoLibros() {
        String infoLibro = "";
        for (Libro libro : baseDatos.getLibros()) {
            infoLibro += getInfoLibros(libro);
        }
        return infoLibro;
    }

    public String getInfoLibros(Libro libro) {
        String infoLibro = "";
        String disponibleStr = libro.isDisponible() ? " |Disponible| " : " |No Disponible| ";
        infoLibro += "Titulo: " + libro.getTitulo() + ", Autor: " + libro.getAutor() + " " + disponibleStr + "\n";
        return infoLibro;
    }

    public Boolean addLibro() {

        String autor = MisFunciones.pedirStrNoVacio("Autor de libro?");
        if (autor == null) return false;

        String titulo;
        boolean existe;
        do {
            existe = false;
            titulo = MisFunciones.pedirStrNoVacio("titulo de libro?");
            if (titulo == null) return false;
            for (Libro libro : this.baseDatos.getLibros()) {
                if (libro.getTitulo().equals(titulo)) {
                    existe = true;
                    JOptionPane.showMessageDialog(null, "Libro ya existe");
                }
            }
        } while (existe);

        new Libro(titulo, autor, this);
        JOptionPane.showMessageDialog(null, "Libro agregado");
        return true;

    }

    public Boolean addUsario() {

        String nombre = MisFunciones.pedirStrNoVacio("Nombre de usario?");
        if (nombre == null) return false;

        String dni;
        boolean existe;
        do {
            existe = false;
            dni = MisFunciones.pedirStrNoVacio("DNI?");
            if (dni == null) return false;
            for (Usario usario : this.baseDatos.getUsarios()) {
                if (usario.getDni().equals(dni)) {
                    existe = true;
                    JOptionPane.showMessageDialog(null, "Usario ya existe");
                }
            }
        } while (existe);

        new Usario(nombre, dni, this);
        JOptionPane.showMessageDialog(null, "Usario agregado");
        return true;

    }

    public BaseDatos getBaseDatos() {
        return baseDatos;
    }

}
