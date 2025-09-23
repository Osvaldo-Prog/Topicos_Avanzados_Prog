package ATM.Strategy;
import ATM.Cuenta;
public class Retiro implements Operacion{
    @Override
    public void ejecutar(Cuenta cuenta, double monto){
        if(cuenta.retirar(monto)){
            System.out.println("Retiro exitoso de $" + monto);
        }else{
            System.out.println("Fondos insuficientes");
        }
    }
}
