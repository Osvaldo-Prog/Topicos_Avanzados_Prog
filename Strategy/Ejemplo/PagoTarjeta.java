package Strategy.Ejemplo;
/**
 * clase para indicar que se paga con tarjeta
 */
public class PagoTarjeta implements EstrategiaPago{
    @Override
    /**
     * Metodo para indicar que paga con tarjeta
     * @param monto monto que ingresa el usuario
     */
    public void pagar(double monto){
        System.out.println("Pagando la cantidad $" + monto + " con tarjeta");
    }
}
