package ATM.Strategy;

import ATM.Cuenta;
import ATM.CajeroModel;
import ATM.Views.CajeroView;

public class ConsultarSaldo implements Operacion {
    @Override
    public void ejecutar(Cuenta cuenta, double monto, String cuentaDestino, CajeroModel model, CajeroView view) {
        view.mostrarSaldo(cuenta.getSaldo());
    }
}
