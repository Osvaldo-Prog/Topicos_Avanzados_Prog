/**
 * Clase principal del programa
 */
public class Fabrica {
    public static void main(String[] args) {
        ModelProducto<Producto> repo = new ModelProducto<>();
        Controlador controller = new Controlador(repo);
        ViewProducto view = new ViewProducto(controller);
        view.menu(); // Inicia la interfaz de consola
    }
}
