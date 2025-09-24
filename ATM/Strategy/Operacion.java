package ATM.Strategy;

import ATM.Cuenta;
import ATM.CajeroModel;
import ATM.Views.CajeroView;

public interface Operacion {

    // Para operaciones normales: consultar saldo, retiro, deposito, transferencia
    default void ejecutar(Cuenta cuenta, double monto, String cuentaDestino, CajeroModel model, CajeroView view) {}

    // Para cambiar PIN
    default void ejecutarCambioPin(Cuenta cuenta, String pinActual, String nuevoPin, CajeroModel model, CajeroView view) {}
}
