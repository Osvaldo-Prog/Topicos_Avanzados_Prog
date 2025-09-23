package ATM.Strategy;
import ATM.Cuenta;

public interface Operacion {
    void ejecutar(Cuenta cuenta, double monto);
}
