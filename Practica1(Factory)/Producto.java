/**
 * Interfaz que define las operaciones básicas de un producto.
 * 
 * Todas las clases que implementen esta interfaz deben proveer
 * la forma de obtener nombre y precio.
 */
public interface Producto{

    /**
     * Devuelve el nombre del producto
     * @return nombre del producto
     */
    String getNombre();

    /**
     * Devuelve el precio del producto
     * @return precio producto
     */
    double getPrecio();

    /**
     * Devuelve el precio del producto
     * @return precio del producto
     */
    String getTipo();
    void mostrarInfo(); //Este metodo es adicional, solo para mostrar informacion
}