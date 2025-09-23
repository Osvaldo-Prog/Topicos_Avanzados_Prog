package ATM.Strategy;
import ATM.Cuenta;
public class Deposito implements Operacion{
    @Override
    public void ejecutar(Cuenta cuenta, double monto){
        if(monto == 0){
            System.out.println("Error, ingresa un monto mayor a 0");
        }else{
            System.out.println("Deposito de $" + monto + " realizado con exito a la cuenta " + cuenta.getNumeroCuenta());
        }
    }
}
