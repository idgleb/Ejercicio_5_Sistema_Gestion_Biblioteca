import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        BaseDatos baseDatos = BaseDatos.getInstance();

        Biblioteca biblioteca = new Biblioteca("Baba", baseDatos);

        Libro libro1 = new Libro("Agonia", "Petrov", biblioteca);
        Libro libro2 = new Libro("Como ser libre", "Kim Chen Ir", biblioteca);

        String[] opc = {"Agregar NEW Usario", "Agregar NEW Libro", "Prestar libro", "Devolver libro"};

        Runnable[] ac = new Runnable[]{
                biblioteca::addUsario,
                biblioteca::addLibro,
                biblioteca::prestar_libro,
                biblioteca::devolver_libro,
        };
        MisFunciones.interfaz(ac, opc, biblioteca::getReporte);


    }
}