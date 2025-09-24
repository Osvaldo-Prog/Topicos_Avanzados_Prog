package ATM.Strategy;
import ATM.CajeroModel;
//Se hara el strategy bien implementado
public class ConsultarSaldo implements Operacion{
    @Override
    public void ejecutar(CajeroModel cajero, double monto, String cuentaDestino){
        System.out.println("El saldo de la cuenta" + " es de $" + cajero.consultarSaldo());
    }
}
