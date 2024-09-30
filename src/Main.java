import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        BaseDatos baseDatos = BaseDatos.getInstance();

        Biblioteca biblioteca = new Biblioteca("Baba", baseDatos);

        Libro libro1 = new Libro("Agonia", "Petrov", biblioteca);
        Libro libro2 = new Libro("Como ser libre", "Kim Chen Ir", biblioteca);

        int seleccion = 0;
        do {
            String[] opciones = {"Salir", "Agregar NEW Usario", "Agregar NEW Libro", "Prestar libro", "Devolver libro"};
            seleccion = JOptionPane.showOptionDialog(
                    null,
                    biblioteca.getReporte(),
                    "Ursol",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );
            switch (seleccion) {
                case 0:
                    //Salir
                    break;
                case 1:
                    //Agregar Usario
                    biblioteca.addUsario();
                    break;
                case 2:
                    //Agregar NEW Libro
                    biblioteca.addLibro();
                    break;
                case 3:
                    //Prestar libro
                    biblioteca.prestar_libro();
                    break;
                case 4:
                    //Devolver libro
                    biblioteca.devolver_libro();
                    break;
                case 5:
                    break;
                default:
                    break;
            }
        } while (seleccion != 0);

    }
}