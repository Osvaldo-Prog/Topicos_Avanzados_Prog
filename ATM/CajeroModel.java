package ATM;

import java.util.HashMap;
import java.util.Map;

public class CajeroModel {

    private Map<String, Cuenta> cuentas;
    private Cuenta cuentaActual;

    public CajeroModel() {
        cuentas = new HashMap<>();
        inicializarCuentas();
    }

    private void inicializarCuentas() {
        // Usando Builder
        Cuenta cuenta1 = new Cuenta.CuentaBuilder()
                .numeroCuenta("12345")
                .pin("1111")
                .saldo(5000)
                .titular("Osvaldo")
                .build();

        Cuenta cuenta2 = new Cuenta.CuentaBuilder()
                .numeroCuenta("56789")
                .pin("6789")
                .saldo(7000)
                .titular("Adrian")
                .build();

        Cuenta cuenta3 = new Cuenta.CuentaBuilder()
                .numeroCuenta("54321")
                .pin("2412")
                .saldo(8600)
                .titular("Ambar")
                .build();

        cuentas.put(cuenta1.getNumeroCuenta(), cuenta1);
        cuentas.put(cuenta2.getNumeroCuenta(), cuenta2);
        cuentas.put(cuenta3.getNumeroCuenta(), cuenta3);
    }

    public boolean autenticar(String numeroCuenta, String pin) {
        Cuenta cuenta = cuentas.get(numeroCuenta);
        if (cuenta != null && cuenta.validarPin(pin)) {
            this.cuentaActual = cuenta;
            return true;
        }
        return false;
    }

    public Cuenta getCuentaActual() { return cuentaActual; }

    public double consultarSaldo() {
        return cuentaActual != null ? cuentaActual.getSaldo() : 0;
    }

    public boolean realizarRetiro(double cantidad) {
        return cuentaActual != null && cuentaActual.retirar(cantidad);
    }

    public boolean realizarDeposito(double cantidad) {
        if (cuentaActual != null && cantidad > 0) {
            cuentaActual.depositar(cantidad);
            return true;
        }
        return false;
    }

    public boolean cuentaExistente(String numeroCuenta) {
        return cuentas.containsKey(numeroCuenta);
    }

    public boolean realizarTransaccion(String cuentaDestino, double cantidad) {
        if (cuentaActual != null && cantidad > 0 && cuentaExistente(cuentaDestino)) {
            Cuenta destino = cuentas.get(cuentaDestino);
            if (cuentaActual.retirar(cantidad)) {
                destino.depositar(cantidad);
                return true;
            }
        }
        return false;
    }

    public boolean cambiarNip(String pinActual, String nuevoPin) {
        if (cuentaActual != null && cuentaActual.validarPin(pinActual)) {
            cuentaActual.setPin(nuevoPin);
            return true;
        }
        return false;
    }
}
