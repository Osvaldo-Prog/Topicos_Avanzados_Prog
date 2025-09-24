package ATM.Strategy;

import ATM.Cuenta;
import ATM.CajeroModel;
import ATM.Views.CajeroView;

public class CambiarNip implements Operacion {
    @Override
    public void ejecutarCambioPin(Cuenta cuenta, String pinActual, String nuevoPin,
                                  CajeroModel model, CajeroView view) {
        if (model.cambiarNip(pinActual, nuevoPin)) {
            view.mostrarMensajeExito("PIN cambiado con éxito");
        } else {
            view.mostrarError("PIN actual incorrecto");
        }
    }
}
