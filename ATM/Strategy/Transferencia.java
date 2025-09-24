package ATM.Strategy;
import ATM.CajeroModel;
public class Transferencia implements Operacion{
    @Override
    public void ejecutar(CajeroModel cajero, double cantidad, String cuentaDestino) {
        if (cajero.realizarTransaccion(cuentaDestino, cantidad)) {
            System.out.println("Transferencia realizada a " + cuentaDestino);
        } else {
            System.out.println("Error en la transferencia.");
        }
    }
}
