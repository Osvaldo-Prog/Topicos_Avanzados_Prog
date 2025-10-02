package ATM.Strategy;

import ATM.Cuenta;
import ATM.CajeroModel;
import ATM.Views.CajeroView;

public class Deposito implements Operacion {
    @Override
    public void ejecutar(Cuenta cuenta, double monto, String cuentaDestino, CajeroModel model, CajeroView view) {
        if (model.realizarDeposito(monto)) {
            view.mostrarMensajeExito("Depósito de $" + monto + " realizado con éxito");
        } else {
            view.mostrarError("Error al realizar depósito");
        }
    }
}
