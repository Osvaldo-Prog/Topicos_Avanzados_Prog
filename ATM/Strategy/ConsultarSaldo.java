package ATM.Strategy;
import ATM.Cuenta;
//Se hara el strategy bien implementado
public class ConsultarSaldo implements Operacion{
    @Override
    public void ejecutar(Cuenta cuenta, double monto){
        System.out.println("El saldo de la cuenta" + cuenta.getNumeroCuenta() + " es de $" + cuenta.getSaldo());
    }
}
