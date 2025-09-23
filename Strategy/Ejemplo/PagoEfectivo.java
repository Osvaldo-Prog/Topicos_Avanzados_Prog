package Strategy.Ejemplo;
//Clase Strategy de pago en efectivo
public class PagoEfectivo implements EstrategiaPago{
    @Override
    /**
     * Clase para indicar que esta pagando en efectivo
     * @param monto el monto que da el usuario
     */
    public void pagar(double monto){
        System.out.println("Pagando la cantidad de $" + monto + " en efectivo");
    }
}
