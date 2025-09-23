/**
 * Clase que genera un producto tipo elentronica
 */
public class Electronica implements Producto {
    private String nombre;
    private double precio;

    /**
     * 
     * @param nombre nombre del producto electronica
     * @param precio precio del producto electronica
     */
    public Electronica(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public String getNombre() { return nombre; }

    @Override
    public double getPrecio() { return precio; }

    @Override
    public String getTipo() { return "Electrónica"; }

    @Override
    public void mostrarInfo() {
        System.out.println(nombre + " - Electrónica - $" + precio);
    }
}



