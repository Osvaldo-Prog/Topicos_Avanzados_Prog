package View;
import javax.swing.JOptionPane;
import Controller.SistemaController;

public class Main {
    public static void main(String[] args) {
        ViewGlobal view;
        String tipoVista = JOptionPane.showInputDialog(null, "Selecciona el tipo de vista que deseas usar" +
                                                                             "\n(Consola / GUI)", "Manejador de vistas", JOptionPane.QUESTION_MESSAGE);
        if (tipoVista.equalsIgnoreCase("Consola")) {
             view = new SistemaView(); // Consola
        } else {
            view = new SistemaViewJ(); // JOptionPane
        }

        SistemaController controller = new SistemaController(view);
        controller.iniciar();
    }
}
