/**
 * Clase que genera instancias de un producto segun su tipo
 */
public class ProductoFactory {

    /**
     * 
     * @param tipo tipo del producto dado(Electronica o Alimento)
     * @param nombre nombre del tipo de producto
     * @param precio precio del tipo de producto
     * @return instancia de {@link Producto}
     */
    public static Producto crearProducto(String tipo, String nombre, double precio) {
        if (tipo.equalsIgnoreCase("electronica")) {   // ← usa equalsIgnoreCase para ignorar mayusculas y minusculas
            return new Electronica(nombre, precio);
        } else if (tipo.equalsIgnoreCase("alimento")) {
            return new Alimento(nombre, precio);
        } else {
            throw new IllegalArgumentException("Tipo no válido");
        }
    }
}

