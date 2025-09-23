/**
 * Clase que crea un producto de tipo alimento
 */
public class Alimento implements Producto {
    private String nombre;
    private double precio;

    /**
     * 
     * @param nombre nombre del alimento
     * @param precio precio del alimento
     */
    public Alimento(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public String getNombre() { 
        return nombre; }

    @Override
    public double getPrecio() { 
        return precio; }

    @Override
    public String getTipo() { 
        return "Alimento"; }

    @Override
    public void mostrarInfo() {
        System.out.println(nombre + " - Alimento - $" + precio);
    }
}