//Modelo
import java.util.ArrayList;
import java.util.List;
/**
 * Este es el modelo pero generico para asi almacenar productos de cualquier tipo
 * @param <T> tipo de producto que extiende de {@link Producto}
 */
public class ModelProducto<T extends Producto> {
    private List<T> lista = new ArrayList<>();

    /**
     * @param Producto agrega un producto al modelo
     */
    public void agregar(T Producto) { lista.add(Producto); }

    /**
     * Devuelve la lista de productos almacenados
     * @return
     */
    public List<T> getTodosProductos() { return lista; }

    public void mostrarTodos() {
        for (T producto : lista) {
            producto.mostrarInfo();
        }
    }
}

