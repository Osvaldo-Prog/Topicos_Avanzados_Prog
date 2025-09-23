package Strategy.Ejemplo;
//Clase para indicar que paga con transferencia
public class PagoTransferencia implements EstrategiaPago{
    @Override
    /**
     * Metodo para indicar que paga con transferencia
     * @param monto monto que ingresa el usuario
     */
    public void pagar(double monto){
        System.out.println("Pagando la cantidad de $" + monto + " con transferencia");
    }
}