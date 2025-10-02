package ATM.Strategy;

import ATM.Cuenta;
import ATM.CajeroModel;
import ATM.Views.CajeroView;

public class Transferencia implements Operacion {
    @Override
    public void ejecutar(Cuenta cuenta, double monto, String cuentaDestino, CajeroModel model, CajeroView view) {
        if (model.realizarTransaccion(cuentaDestino, monto)) {
            view.mostrarMensajeExito("Transferencia de $" + monto + " a " + cuentaDestino + " realizada con éxito");
        } else {
            view.mostrarError("No se pudo realizar la transferencia");
        }
    }
}
