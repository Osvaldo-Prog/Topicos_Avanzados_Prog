package Strategy.Ejemplo;

/**
 * Clase contexto del programa
 */
public class CarritoCompras {
    private EstrategiaPago estrategiaPago;
    public void setEstrategiaPago(EstrategiaPago estrategiaPago){
        this.estrategiaPago = estrategiaPago;
    }

    public void realizarPago(double monto){
        if (estrategiaPago == null){
            throw new IllegalStateException("No se selecciono ningun tipo de pago");
        }
        estrategiaPago.pagar(monto);
    }
}
