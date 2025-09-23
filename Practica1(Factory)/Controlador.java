/**
 * Controlador que conecta la clase view con la clase modelo
 */
public class Controlador {
    private ModelProducto<Producto> model;

    /**
     * 
     * @param model modelo de los productos
     */
    public Controlador(ModelProducto<Producto> model) {
        this.model = model;
    }

    /**
     * Agrega un nuevo producto al modelo
     * @param tipo tipo del producto (electronico o alimento)
     * @param nombre nombre del producto
     * @param precio precio del producto
     */
    public void agregarProducto(String tipo, String nombre, double precio) {
        Producto prod = ProductoFactory.crearProducto(tipo, nombre, precio);
        model.agregar(prod);
    }

    /**
     * Muestra todos los productos
     */
    public void mostrarProductos() {
        model.mostrarTodos();
    }
}
