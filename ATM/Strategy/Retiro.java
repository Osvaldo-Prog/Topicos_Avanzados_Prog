package ATM.Strategy;

import ATM.Cuenta;
import ATM.CajeroModel;
import ATM.Views.CajeroView;

public class Retiro implements Operacion {
    @Override
    public void ejecutar(Cuenta cuenta, double monto, String cuentaDestino, CajeroModel model, CajeroView view) {
        if (model.realizarRetiro(monto)) {
            view.mostrarMensajeExito("Retiro de $" + monto + " realizado con éxito");
        } else {
            view.mostrarError("Fondos insuficientes");
        }
    }
}
